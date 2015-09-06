package com.luohj.privileges.service.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.luohj.privileges.dao.IPrivilegeDao;
import com.luohj.privileges.dao.IUserDao;
import com.luohj.privileges.model.Module;
import com.luohj.privileges.model.Privilege;
import com.luohj.privileges.model.User;
import com.luohj.privileges.service.utils.InsertBeanUtil;

/**
 * @title: 权限拦截器
 * 
 * @description 每个请求需鉴权处理，如果当前请求不存在权限数据，需定义权限数据。
 * 
 * @author luohj
 * 
 * @Date 2015-9-4 上午12:53:11
 * 
 * 
 *       版本号 | 作者 | 修改时间 | 修改内容
 * 
 */
public class PrivilegesInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = Logger
			.getLogger(PrivilegesInterceptor.class);

	private List<String> passUrl;
	
	@Resource
	private IUserDao userDao;
	@Resource
	private IPrivilegeDao privilegeDao;

	public List<String> getPassUrl() {
		return passUrl;
	}

	public void setPassUrl(List<String> passUrl) {
		this.passUrl = passUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		log.info("requestUri:" + requestUri);
		log.info("contextPath:" + contextPath);
		log.info("url:" + url);

		String userId = (String) request.getSession().getAttribute("userId");
		userId = "1";
		if (userId == null) {
			return false;
		}
		User user = getUserInfo(userId);
		if (user == null) {
			log.info("Interceptor：跳转到login页面！");
			request.getRequestDispatcher("/views/login/login.jsp").forward(
					request, response);
			return false;
		} else {
			// 检查当前权限项在数据库中是否存在
			Privilege privi = new Privilege(url);
			String tempPriviId = isExistsPrivilegeItem(privi);
			if (tempPriviId==null||tempPriviId.equals("")) {
				// 否，检查用户是否有此权限项权限（依靠模块）
				Module mod = new Module();
				mod.setModule(privi.getModule());
				mod.setModuleType("1");//主模块
				insertModule(mod);
				
				return hasPrivilege(user, privi, false);
			} else {
				// 是，则检查用户是否有此权限项权限
				return hasPrivilege(user, privi, true);
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 成功执行后，检查当前权限项是否存在，不存在则插入数据库
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		Privilege privi = new Privilege(url);
		String tempPriviId = isExistsPrivilegeItem(privi);
		if (tempPriviId==null||tempPriviId.equals("")) {
			Module mod = new Module();
			mod.setModule(privi.getModule());
			mod.setModuleType("1");//主模块
			insertModule(mod);
			
			Module mod1 = new Module();
			mod1.setModule(privi.getChildModule());
			mod1.setModuleType("0");//子模块			
			mod1.setParModule(privi.getModule());
			insertModule(mod1);
			
			insertPrivilege(privi);
		}

		// 日志统计请求执行记录
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("---------------------");
	}

	/**
	 * 当前权限项是否存在
	 * 
	 * @param privilegeItem
	 * @return
	 */
	private String isExistsPrivilegeItem(Privilege privi) {
		return privilegeDao.isExistsPrivilegeItem(privi);
	}

	/**
	 * 用户是否拥有当前权限
	 * 
	 * @param user
	 * @param privi
	 * @return
	 */
	private boolean hasPrivilege(User user, Privilege privi, boolean isPriviExists) {
		return privilegeDao.hasPrivilege(user, privi, isPriviExists);
	}

	/**
	 * 插入权限项
	 * 
	 * @param privi
	 */
	private Long insertPrivilege(Privilege privi) {
		InsertBeanUtil.insertBean(privi);
		return 1l;
		//return privilegeDao.insertPrivilege(privi);
	}

	/**
	 * 插入模块项
	 * 
	 * @param privi
	 */
	private Long insertModule(Module module) {
		InsertBeanUtil.insertBean(module);
		return 1l;
		//return privilegeDao.insertModule(module);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	private User getUserInfo(String userId) {
		User ur = new User();
		ur.setUserId(Long.valueOf(userId));
		User user = userDao.getUser(ur);
		return user;
	}

}
