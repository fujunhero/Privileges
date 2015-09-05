package com.luohj.privileges.core.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.luohj.privileges.core.model.BaseBean;

public class BeanQueue {
	private static Logger logger = Logger.getLogger(BeanQueue.class);
	private static BeanQueue instance ;

	private static BlockingQueue<BaseBean> beanQue;
	
	private static BeanQueue getInstance(){
		if(instance==null){
			synchronized(BeanQueue.class){
				instance = new BeanQueue();
			}
			
		}
		return instance;
	}

	private BlockingQueue <BaseBean> getBeanQue(){
		if(beanQue==null){
			synchronized(this){
				beanQue = new LinkedBlockingQueue<BaseBean>();
			}
		}
		return beanQue;
	}
	/**
	 * 功能：获取bean队列长度
	 * @return
	 */
	public static long size(){
		if(beanQue==null||beanQue.size()<=0){
			return 0;
		}else{
			return beanQue.size();
		}
	}

	/**
	 * 功能：处理会话日志进队列请求，如果队列已满，则返回false
	 * @param logConfigBean
	 */
	public static void offer(BaseBean bean){
		BeanQueue me = BeanQueue.getInstance();
		BlockingQueue<BaseBean> que = me.getBeanQue();
		if(!que.offer(bean)){
			logger.error("写入bean队列失败，bean队列已满！");
		}
	}

	/**
	 * 功能：从队列中获取需要处理的数据,如果队列为空则返回空
	 * @return LogConfigBean
	 */
	public static BaseBean poll(){
		BeanQueue me = BeanQueue.getInstance();
		BlockingQueue<BaseBean> que = me.getBeanQue();
		if(que==null||que.size()<=0){
			return null;
		}else{
			return que.poll();
		}
	}
}
