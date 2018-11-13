package com.ly.novel.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ly.novel.entity.User;
import com.ly.novel.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String userlogin(@RequestParam("userName") String username,String password,HttpSession session) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User  currentUser=userService.login(user);
		if(null!=currentUser){
			session.setAttribute("user", currentUser);
			return "redirect:/index.jsp";
		}else{
			return "redirect:/login.jsp";
		}
	}
	
	@RequestMapping(value="/logout")
	public String userLogout(@ModelAttribute("user") User user,HttpSession session) {
		//if(null!=user)
//			status.setComplete();
		//if(null!=user)
		session.invalidate();
		return "redirect:/login.jsp";
	}
}
