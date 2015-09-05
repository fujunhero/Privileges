package com.luohj.privileges.core.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.luohj.privileges.core.cache.impl.CacheContext;
import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Cacheable;

@Aspect
@Component
public class CacheAspect {
	@Resource
	private CacheContext cacheContext ;
	@Around("within(com.luohj.privileges..*) && @annotation(rl)")
	public Object cacheable(ProceedingJoinPoint joinPoint, Cacheable rl) throws Exception {
		try {
			Object[] args = joinPoint.getArgs();
			String key = rl.key();
			if(key.contains("#")){
				if(key.contains("\\.")){
					String temp = key.split("\\.")[1];
					for(int i = 0; i < args.length; i++){
						if (args[i] instanceof BaseBean) {
							BaseBean bean = (BaseBean) args[i];
							Field[] field = bean.getClass().getDeclaredFields(); 
							for (int j = 0; j < field.length; j++) { // 遍历所有属性
				                String name = field[j].getName(); // 获取属性的名字
				                if(name.equals(temp)){
				                	name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				                    Method m = bean.getClass().getMethod("get" + name);
				                    key = (String) m.invoke(bean); // 调用getter方法获取属性值
				                }
							}

							break;
						}
					}
				} else {
					for (int i = 0; i < args.length; i++) {
						key = (String)args[0];
					}
				}
			} 
			//根据key从缓存中获取值
			Object obj = cacheContext.get(key);
			if(obj==null){
				try {
					obj = joinPoint.proceed();
					if(obj!=null){
						cacheContext.addOrUpdateCache(key, obj);
					}
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return obj;
		} catch (Exception e) {
			throw e;
		}
	}
}
