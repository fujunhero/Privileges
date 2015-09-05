package com.luohj.privileges.core.control;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {
	/**
	 * 拦截请求异常
	 * @param request
	 * @param e
	 * @return
	 */
    public String exception(HttpServletRequest request, Exception e) {  
        
    	e.printStackTrace();
    	//TODO 添加异常处理逻辑，如日志记录
        request.setAttribute("exceptionMessage", e.getMessage());  
                 
        //返回异常VIEW显示
        return "error";  
    }     
}
