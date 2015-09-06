package com.luohj.privileges.core.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class AbstractController {
	/**
	 * 拦截请求异常
	 * 
	 * @param request
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler
	public void exception(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws IOException {

		e.printStackTrace();
		// TODO 添加异常处理逻辑，如日志记录
		request.setAttribute("exceptionMessage", e.getMessage());
		if (e.getClass() == NoSuchRequestHandlingMethodException.class) {
			response.sendRedirect(request.getContextPath()
					+ "/common/view/404.jsp");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/common/view/500.jsp");
		}
	}
}
