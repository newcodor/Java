package com.newcodor.springmvc.interceptor;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1  implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("渲染之后");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("之后");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("之前");
		String uri=request.getRequestURI();
		if(!uri.contains("login")) {
			String  token = (String)request.getSession().getAttribute("user_session");
			if(null==token) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return false;
			}
			
		}
		
		return true;
	}

}
