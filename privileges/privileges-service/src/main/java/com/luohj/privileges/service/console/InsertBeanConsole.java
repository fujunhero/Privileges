package com.luohj.privileges.service.console;

import java.util.Timer;

import org.apache.log4j.Logger;

import com.luohj.privileges.service.thread.InsertBeanArchTask;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 下午09:08:28
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class InsertBeanConsole {
	private static Logger logger = Logger.getLogger(InsertBeanConsole.class);
	
	public static void startHandler(){
		//启动会话日志处理线程的守护进程
		logger.info("启动插入BEAN处理线程的守护进程...");
		(new Timer()).schedule(new InsertBeanArchTask(), 0L);
	}
}
