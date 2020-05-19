package com.communication.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.communication.entity.Data;
import com.communication.entity.Role;
import com.communication.entity.User;

public class SystemInitInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 免登入 免检查地址
	 */
	private List<String> uncheckUrls;
	private Data data;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取url地址
		String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");
		// 当url地址为登录的url的时候跳过拦截器
		boolean isPass = false;
		if (uncheckUrls.contains(reqUrl)) {
			isPass = true;
		} else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("curUser");
			if (user == null) {
				// 是否为ajax请求
				if (isAjaxRequest(request)) {
					data = Data.failure("对不起，您还没有登陆");
					PrintWriter out = response.getWriter();
					out.print(data.toString());
				} else {
					response.sendRedirect("/login");
				}
			} else {
				if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
					RequiresPermission permission = ((HandlerMethod) handler)
							.getMethodAnnotation(RequiresPermission.class);

					if (permission != null) {
						String[] values = permission.values();
						Role role = user.getRole();
						if (values.length > 0) {
							for (String value : values) {
								if (value.equals(role.getCode())) {
									isPass = true;
									break;
								}
							}
						}

						if (!isPass) {
							// 是否为ajax请求
							if (isAjaxRequest(request)) {
								data = Data.failure("对不起，您没有访问该模块的权限");
								PrintWriter out = response.getWriter();
								out.print(data.toString());
							} else {
								response.sendRedirect("/hasNoRight");
							}

						}

					} else {
						isPass = true;
					}
				}
			}
		}
		return isPass;
	}

	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		boolean isAjax = "XMLHttpRequest".equals(header) ? true : false;
		return isAjax;
	}

}
