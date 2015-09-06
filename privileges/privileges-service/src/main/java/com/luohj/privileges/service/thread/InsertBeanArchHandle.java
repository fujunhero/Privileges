package com.luohj.privileges.service.thread;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.luohj.privileges.core.exception.BusiRuntimeException;
import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.queue.BeanQueue;
import com.luohj.privileges.core.utils.ApplicationContextUtil;
import com.luohj.privileges.core.utils.ConfigLoader;
import com.luohj.privileges.dao.ICommonDao;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 下午09:08:20
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class InsertBeanArchHandle implements Runnable {
	private static Logger logger = Logger.getLogger(InsertBeanArchHandle.class);
	private static final Integer SLEEP_TIME_DEFAULT_VAL = 2000; // 线程默认休眠时间
	@Resource
	private ICommonDao commonDao;

	public InsertBeanArchHandle() {
		if (commonDao == null) {
			synchronized(InsertBeanArchHandle.class){
				if (commonDao == null) {
					ApplicationContext ac = ApplicationContextUtil.getContext();
					commonDao = ApplicationContextUtil.getBean("commonDao");
				}
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			if (BeanQueue.size() > 0) {
				BaseBean beanBean = BeanQueue.poll();
				if (beanBean == null) {
					continue;
				}
				try {
					if(!commonDao.isExistsBean(beanBean)){
						commonDao.insertBean(beanBean);
					}
				} catch (BusiRuntimeException ex) {
					logger.error(ex.getMessage());
					ex.printStackTrace();
				} catch (Exception ex) {
					logger.error("插入失败");
					ex.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(getSleepTime());
					logger.info("线程队列为空，线程[" + Thread.currentThread().getName()
							+ "]休眠[" + getSleepTime() + "ms]");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 功能:获取线程休眠时间
	 * 
	 * @return
	 */
	private static Integer getSleepTime() {
		String sleepTime = (String) ConfigLoader
				.getContextProperty("session.log.empty.interval");
		return (sleepTime == null) ? SLEEP_TIME_DEFAULT_VAL : Integer.valueOf(sleepTime);
	}

}
