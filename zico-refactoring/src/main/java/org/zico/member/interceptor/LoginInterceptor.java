package org.zico.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 	ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("LoginInterceptor Call");
		Object id = modelAndView.getModel().get("id");
		Object grade = modelAndView.getModel().get("grade");
		Object storeNo = modelAndView.getModel().get("storeNo");
		if (id != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("grade", grade);
			if (storeNo != null) {
				session.setAttribute("storeNo", storeNo);
			}
			try {
				if (modelAndView.getModel().get("cookie").equals("true")) {
					Cookie loginCookie = new Cookie("id", (String) id);
					loginCookie.setMaxAge(60 * 60 * 24 * 7);
					loginCookie.setPath("/");
					response.addCookie(loginCookie);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}