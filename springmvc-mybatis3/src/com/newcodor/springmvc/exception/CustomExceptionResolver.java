package com.newcodor.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器
 * @author lenovo
 *
 */
public class CustomExceptionResolver  implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		// TODO Auto-generated method stub
		
		ModelAndView mav =new  ModelAndView();
		if(e instanceof MessageException) {
			//预期异常
			MessageException me=(MessageException)e;
			mav.addObject("error", me.getMsg());
		}
		else
			mav.addObject("error", "未知异常");
		mav.setViewName("error");
		
		return mav;
	}

}
