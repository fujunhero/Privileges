package com.luohj.privileges.service.thread;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.luohj.privileges.core.utils.ConfigLoader;

/**
 * 功能说明:
 *
 * @author luohj
 * 
 * @Date 2015-9-5 下午09:08:50
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class InsertBeanArchTask  extends TimerTask{
	private static Logger logger = Logger.getLogger(InsertBeanArchTask.class);
	
	private static final Long THREAD_SIZE_DEFAULT_VAL = 3L;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Runnable thread = new InsertBeanArchHandle();
		for(int i=0;i<this.getThreadSize();i++){
			thread.run();
		}
	}
	
	/**
	 * 获取线程数
	 * @return
	 */
	public long getThreadSize(){
		String threadSize = (String)ConfigLoader.getContextProperty("insertbean.thread.size");
		return (threadSize == null) ? THREAD_SIZE_DEFAULT_VAL:Long.valueOf(threadSize);
	}

}
