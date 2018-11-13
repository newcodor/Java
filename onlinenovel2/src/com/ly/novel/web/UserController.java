package com.ly.novel.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.Review;
import com.ly.novel.entity.User;
import com.ly.novel.service.AdminService;
import com.ly.novel.service.BookMarkService;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.UserService;
import com.ly.novel.vo.BookMarkVo;
import com.ly.novel.vo.BookSelfVo;

@Controller
public class UserController {
	
	@Autowired
	private NovelService novelService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookMarkService bookMarkService;
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value="/register")
	public String userRegister(HttpServletRequest  request ) {
		  String username=request.getParameter("userName");
			String password=request.getParameter("password");
			String role="reader";
			String sex=request.getParameter("sex").equals("male")?"男":"女";
			String [] hobbys=request.getParameterValues("hobbys");
			StringBuffer hobby=new StringBuffer();
			for (String h : hobbys) {
				hobby.append(h);
				hobby.append(h.equals(hobbys[hobbys.length-1])?"":",");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthdays=request.getParameter("birthday");
			Date birthday=null;
			try {
				birthday=sdf.parse(birthdays);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String qq=request.getParameter("qq");
			Date createtime=new Date();
			User u=new User(username,password,role,sex,hobby.toString(),birthday,city,qq,email,createtime);
			boolean result=userService.addUser(u);
			if(result){
				return "redirect:/index.jsp";
			}else{
				return "redirect:/register.jsp";
			}
	}
	
	  @RequestMapping(value="/user/bookself/list",method={RequestMethod.GET})
	  public String queryBookSelf(HttpSession session,Model model) {
		  User currentUser=(User) session.getAttribute("user");
		  if(null!=currentUser){                          //判断用户是否登录
				int userid=currentUser.getUserid();            //获取当前用户userid
			    List<BookSelfVo>  bookSelfVos=null;            //定义书架数据集合
				bookSelfVos=novelService.queryAllBookSelfsByUserId(userid);   //调用Service层方法获取书架信息
				if(null!=bookSelfVos){
					model.addAttribute("bookSelfVos", bookSelfVos);
					model.addAttribute("origin", "forward");
				}
				return "forward:/bookself.jsp";
				
		  		}
				else{
					return "redirect:/login.jsp";
				}
	  }
	
	  @RequestMapping(value="/user/bookmark/list",method={RequestMethod.GET})
	  public String queryBookMarksByUser(HttpSession session,Model model) {
		  User currentUser=(User) session.getAttribute("user");
		  if(null!=currentUser){
			    int userid=currentUser.getUserid();
				List<BookMarkVo>  bookMarkVos=null;
				bookMarkVos=bookMarkService.queryAllBookMarksByUserId(userid);
				if(null!=bookMarkVos){
					model.addAttribute("bookMarkVos", bookMarkVos);
					model.addAttribute("origin", "forward");
				}
				return "forward:/bookmark.jsp";
		  }
		  else
					return "redirect:/login.jsp";
				
	  }
	  
	  
	  @RequestMapping(value="/user/bookmark/delete")
	  public String delBookMark(HttpServletRequest request) {
			String [] selecedNovels=request.getParameterValues("selecedNovel");
			int [] bids=new int [selecedNovels.length];
			if(null!=selecedNovels){
				int i=-1;
		         for(String str : selecedNovels) {
					bids[++i]=Integer.parseInt(str);
				}
			}
			
			User currentUser=(User)request.getSession().getAttribute("user");
			if(null==currentUser){
				return  "redirect:/login.jsp";
			}
			int userid=currentUser.getUserid();
	        bookMarkService.delBookMark(userid,bids,0);
	        return "redirect:/bookmark.jsp?userid="+((User)request.getSession().getAttribute("user")).getUserid();
	  }
	  
	  @RequestMapping(value="/user/bookmark/add",method={RequestMethod.POST})
	  public @ResponseBody String addBookMarkByUser(HttpSession session,@RequestParam(required=false) Integer bid,@RequestParam(required=false) Integer chaid) {
		  
		  
		  User currentUser=((User)session.getAttribute("user"));
			if(null!=currentUser){
				int userid=currentUser.getUserid();
				int resultStatus=bookMarkService.addBookMark(userid,bid,chaid);
	              if(resultStatus==1)
					return "success";
	              else if(resultStatus==2)
					return "exist";
	              else if(resultStatus==0)
					return "fail";
			}
				return  "nologin";
	          }
	  
	  
	  @RequestMapping(value="/user/bookself/add",method={RequestMethod.POST})
	  public @ResponseBody String addBookSelfByUser(HttpSession session,@RequestParam(required=false) Integer bid) {
			User currentUser=((User)session.getAttribute("user"));
			if(null!=currentUser){
				int userid=currentUser.getUserid();
				int resultStatus=novelService.addBookSelf(userid,bid);
			     if(resultStatus==1)
						return "success";
		              else if(resultStatus==2)
						return "exist";
		              else if(resultStatus==0)
						return "fail";
				}
					return  "nologin";
			
	  }
	  
	  @RequestMapping(value="/user/query")
	  public String queryUserById(HttpSession session,@RequestParam(value="userid",required=false) Integer userid,@RequestParam(value="fromPage",required=false) String fromPage,Model model) {
		 User  currentUser=(User)(session.getAttribute("user"));
		 Admin  currentAdmin=(Admin)(session.getAttribute("admin"));
		 if(null != currentUser || null !=currentAdmin) {
		 if(null==userid) 
			 userid=currentUser.getUserid();
		  User user=userService.queryUserById(userid);
		  model.addAttribute("currentUser", user);
		  model.addAttribute("origin", "forward");
		          
		 }
		 else 
			 return  "redirect:/login.jsp";
			 
		 if(null==fromPage || "".equals(fromPage))
			  return  "forward:/user/userInfo.jsp";
			else
				return  "forward:/"+fromPage+".jsp";
	  }
	  
	  @RequestMapping(value="/user/update")
	  public String  updateUserByUid(HttpServletRequest request,@RequestParam(value="userid",required=false)  Integer userid,@RequestParam(value="fromPage",required=false) String fromPage) {
		  
		  if(null==userid)
			  userid=((User)request.getSession().getAttribute("user")).getUserid();
		  String sex=request.getParameter("sex").equals("male")?"男":"女";
			String [] hobbys=request.getParameterValues("hobbys");
			StringBuffer hobby=new StringBuffer();
			for (String h : hobbys) {
				hobby.append(h);
				hobby.append(h.equals(hobbys[hobbys.length-1])?"":",");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthdays=request.getParameter("birthday");
			Date birthday=null;
			try {
				birthday=sdf.parse(birthdays);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String qq=request.getParameter("qq");
			User u=new User(userid,sex,hobby.toString(),birthday,city,qq,email);
			boolean result=userService.updateUser(u);
			//String fromPage=request.getParameter("fromPage");
			
			//queryUserById(session, userid, fromPage, null);
			if(null==fromPage || "".equals(fromPage))
				return "redirect:/user/query?fromPage=user/userInfo";
			else
				return "redirect:/user/query?fromPage="+fromPage;
				
	  }
	  
	  @RequestMapping(value="/user/updatepass")
	  public String updateUserPass(HttpSession session,String password) {
		  User currentUser=(User) session.getAttribute("user");
		  if(null!=currentUser){
				int userid=currentUser.getUserid();
				boolean result=userService.updateUserPass(userid,password);
				return "redirect:/user/updatepass.jsp";
	     }
		  return "redirect:/login.jsp";
	  }
	  
	  @RequestMapping(value="/user/apply")
	  public  String applyBook(HttpServletRequest request) {
			// TODO Auto-generated method stub
			User currentUser=null;
			currentUser=(User)request.getSession().getAttribute("user");
			if(null!=currentUser){
				int userid=currentUser.getUserid();
				int cid=Integer.parseInt(request.getParameter("cid"));
				String  bookname=request.getParameter("bookname");
				String  bookintroduction=request.getParameter("bookintroduction");
				String  bookSampleDraft=request.getParameter("bookSampleDraft");
				String reviewStatus="waitpass";
				Date applyTime=new Date();
				String postip=request.getRemoteAddr();
				Review reviewNovel=new Review(userid,cid,0,bookname,bookintroduction,bookSampleDraft,reviewStatus,applyTime,postip);
				novelService.addReviewNovel(reviewNovel);
				return "redirect:/user/applyWriter.jsp";
			}else
				return "redirect:/login.jsp";
			
		}
	  
	  @RequestMapping(value="/admin/login")
	  public String adminLogin(HttpSession session,@RequestParam("userName") String username,String password) {
		  Admin admin=new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			admin=adminService.login(admin);
			if(null!=admin){
				session.setAttribute("admin", admin);
				session.setMaxInactiveInterval(18000);  //有效期
				return "redirect:/admin/admin.jsp";
			}else{
				return "redirect:/admin/admin_login.jsp";
			}
	  }
	  
	  @RequestMapping(value="/admin/updatepass")
	  public String updateAdminPass(HttpSession session,String password) {
		  
		  Admin currentAdmin=(Admin)session.getAttribute("admin");
		  if(null!=currentAdmin){
			  int adminid=currentAdmin.getAdminid();
				Admin admin=new Admin();
				admin.setAdminid(adminid);
				admin.setPassword(password);
				boolean result=adminService.updateAdminPass(admin);
				return "redirect:/admin/updateAdmin.jsp";
		  }else
			  return "redirect:/admin/admin_login.jsp";
		  
		  
	  }
	  
	  
	  @RequestMapping(value="/user/queryall")
	  public String queryAllUsers(Model model) {
			List<User> users=null;
			users=userService.queryAllUsers();
			if(null!=users){
				model.addAttribute("users", users);
				return "forward:/admin/member.jsp";
			}else{
				return "redirect:/admin/admin.jsp";
			}
	  }
	  
	  
	  @RequestMapping(value="/user/delete")
	  public String delUser(Integer userid,String role) {
		  boolean result=userService.delUserById(userid,role);
		  return "redirect:/user/queryall";
	  }
	  
	  @RequestMapping(value="/user/add")
	  public String addUser(HttpServletRequest  request) {
		  String username=request.getParameter("userName");
			String password=request.getParameter("password");
			String role="reader";
			String sex=request.getParameter("sex").equals("male")?"男":"女";
			String [] hobbys=request.getParameterValues("hobbys");
			StringBuffer hobby=new StringBuffer();
			for (String h : hobbys) {
				hobby.append(h);
				hobby.append(h.equals(hobbys[hobbys.length-1])?"":",");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthdays=request.getParameter("birthday");
			Date birthday=null;
			try {
				birthday=sdf.parse(birthdays);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String qq=request.getParameter("qq");
			Date createtime=new Date();
			User u=new User(username,password,role,sex,hobby.toString(),birthday,city,qq,email,createtime);
			boolean result=userService.addUser(u);
			if(result){
				return "redirect:/admin/admin.jsp";
			}else{
				return "redirect:/admin/addMember.jsp";
			}
	  }
	  
		
}
