package com.ly.novel.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.novel.entity.Reply;
import com.ly.novel.entity.User;
import com.ly.novel.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/reply/add")
	public String addReplyrecord(HttpSession session,HttpServletRequest request) {
		User u= (User)session.getAttribute("user");
		if(null!=u){
			if(request.getParameter("bid").equals("0")){
				return "redirect:/index.jsp";
			}
			int bid=Integer.parseInt(request.getParameter("bid"));
			int userid=u.getUserid();
			String replycontent=request.getParameter("replycontents");
			Date replytime=new Date();
			String replyip=request.getRemoteAddr();
			Reply reply=new Reply(bid,userid,replycontent,replytime,replyip);
			boolean result=replyService.addReply(reply);
			return "redirect:/novel/query?bid="+bid;
		}
		else {
            return "redirect:/login.jsp";
		}
	}
}
