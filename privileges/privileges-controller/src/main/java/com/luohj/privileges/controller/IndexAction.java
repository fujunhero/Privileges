package com.luohj.privileges.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luohj.privileges.core.control.AbstractController;

@Controller
@RequestMapping("/index/index")
public class IndexAction extends AbstractController {
	private final static Logger logger = Logger.getLogger(IndexAction.class);

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpSession session, HttpServletRequest request) {
		logger.debug("进入：test方法");
		return "SUCCESS";
	}
}
