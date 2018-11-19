package org.zico.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object value = request.getSession().getAttribute("id");
		if(value != null) {
			return true;
		} else {
			Cookie idCookie = WebUtils.getCookie(request, "id");
			if(idCookie != null) {
				request.getSession().setAttribute("id", idCookie.getValue());
			}
		}
		return true;
	}


	
}
