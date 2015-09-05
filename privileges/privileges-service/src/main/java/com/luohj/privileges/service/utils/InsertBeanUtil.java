package com.luohj.privileges.service.utils;

import org.apache.log4j.Logger;

import com.luohj.privileges.core.model.BaseBean;
import com.luohj.privileges.core.queue.BeanQueue;
import com.luohj.privileges.service.console.InsertBeanConsole;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 下午09:08:59
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class InsertBeanUtil {
	private static Logger logger = Logger.getLogger(InsertBeanUtil.class);
	static {
		logger.info("Start insert bean handler thread......开始运行插入bean的线程了！");
		InsertBeanConsole.startHandler();
	}
	/**
	 * 功能：写会话日志队列
	 */
	public static void insertBean(BaseBean bean){
		BeanQueue.offer(bean);
	}
}
