package com.ly.novel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//1.注解配置filter
@WebFilter(filterName="CharactorEncodingFilter",urlPatterns="/*")
public class CharactorEncodingFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		System.out.println("字符编码过滤器……");
		//避免中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//转发给下一个Filter或接着由Servlet处理
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
