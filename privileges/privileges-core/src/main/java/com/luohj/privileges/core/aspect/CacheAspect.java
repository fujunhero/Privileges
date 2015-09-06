package com.luohj.privileges.core.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.luohj.privileges.core.cache.impl.CacheContext;
import com.luohj.privileges.core.exception.BusiRuntimeException;
import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.tags.Cacheable;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-7 上午12:08:28
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
@Aspect
@Component
public class CacheAspect {
	private static Logger logger = Logger.getLogger(CacheAspect.class);

	@Resource
	private CacheContext cacheContext;

	@Around("within(com.luohj.privileges..*) && @annotation(rl)")
	public Object cacheable(ProceedingJoinPoint joinPoint, Cacheable rl)
			throws Exception {
		try {
			Object[] args = joinPoint.getArgs();
			String key = rl.key();
			if (key.contains("#")) {
				if (key.contains(".")) {
					String[] tmpArr = key.split("\\.");
					if (tmpArr.length == 2) {
						String tmp = tmpArr[0].substring(1);
						int loc = 0;
						if (tmp != null) {
							try {
								loc = Integer.parseInt(tmp);
							} catch (Exception ex) {
								throw new BusiRuntimeException(
										"E00002",
										"Cacheable注解value值形式只能是值本身或者#开头的表达式！"
												+ "如：#1.userId代表入参的第一个参数内的userId，或者#1，代表入参的第一个参数。");
							}
						}
						String temp = tmpArr[1];
						if (args[loc - 1] instanceof BaseBean) {
							BaseBean bean = (BaseBean) args[loc - 1];
							Field[] field = bean.getClass().getDeclaredFields();
							for (int j = 0; j < field.length; j++) { // 遍历所有属性
								String name = field[j].getName(); // 获取属性的名字
								if (name.equals(temp)) {
									name = name.substring(0, 1).toUpperCase()
											+ name.substring(1); // 将属性的首字符大写，方便构造get，set方法
									Method m = bean.getClass().getMethod(
											"get" + name);
									Object result = (Object) m.invoke(bean); // 调用getter方法获取属性值
									if(result!=null)
										key = String.valueOf(result);
									else
										key = null;
									break;
								}
							}
						} else if (args[loc - 1] instanceof Map) {
							Method m = args[loc - 1].getClass().getMethod(
									"get", Object.class);
							key = (String) m.invoke(args[loc - 1], tmpArr[1]);// 调用getter方法获取属性值
						} else {
							String name = temp.substring(0, 1).toUpperCase()
									+ temp.substring(1); // 将属性的首字符大写，方便构造get，set方法
							Method m = args[loc - 1].getClass().getMethod(
									"get" + name);
							Object result = (Object) m.invoke(args[loc - 1]); // 调用getter方法获取属性值
							if(result!=null)
								key = String.valueOf(result);
							else
								key = null;
						}
					} else {
						throw new BusiRuntimeException(
								"E00003",
								"Cacheable注解使用#bean.xxx开头的表达式取入参对象的属性时，只能取一个深度的属性。"
										+ "如：#1.userId，代表入参的第一个参数内的userId。不能适用#1.xxx.yyy之类的更多的深度");
					}
				} else {
					if (key.length() < 2) {
						throw new BusiRuntimeException(
								"E00002",
								"Cacheable注解value值形式只能是值本身或者#开头的表达式！"
										+ "如：#1.userId，代表入参的第一个参数内的userId，或者#1，代表入参的第一个参数。");
					}
					String tmp = key.substring(1);
					if (tmp != null) {
						int loc = 0;
						try {
							loc = Integer.parseInt(tmp);
						} catch (Exception ex) {
							throw new BusiRuntimeException(
									"E00002",
									"Cacheable注解value值形式只能是值本身或者#开头的表达式！"
											+ "如：#1.userId代表入参的第一个参数内的userId，或者#1，代表入参的第一个参数。");
						}
						try {
							key = (String) args[loc - 1];
						} catch (Exception ex) {
							throw new BusiRuntimeException("E00003",
									"Cacheable注解使用#开头的表达式，未找到对应的入参。");

						}
					}
				}
			}
			// 根据key从缓存中获取值
			Object obj = cacheContext.get(key);
			if (obj == null) {
				try {
					obj = joinPoint.proceed();
					if (obj != null) {
						cacheContext.addOrUpdateCache(key, obj);
					}
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				logger.debug("缓存中取出[" + key + "]的值：" + obj.toString());
			}
			return obj;
		} catch (Exception e) {
			throw e;
		}
	}
}
