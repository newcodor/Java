package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.User;
import com.ly.novel.service.UserService;
import com.ly.novel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserQueryServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService =new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if("queryAll".equals(action))
			queryAllUsers(request,response);
		else if("add".equals(action))
			addUser(request, response);
		else if("update".equals(action)){
			updateUser(request,response);
		}
		else if("updatePass".equals(action)){
			updateUserPass(request,response);
		}
		else if("query".equals(action)){
			queryUser(request,response);
		}
		else if("del".equals(action)){
			delUser(request,response);
		}
	}
	protected void queryAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users=null;
		users=userService.queryAllUsers();
		if(null!=users){
			request.setAttribute("users", users);
			request.getRequestDispatcher("admin/member.jsp").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script>alert('用户信息查询失败!');window.parent.location='admin/admin.jsp'</script>");
		}
		
	}
	protected void queryUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		Admin currentAdmin=null;
		currentUser=(User)(request.getSession().getAttribute("user"));
		currentAdmin=(Admin)(request.getSession().getAttribute("admin"));
		PrintWriter out=response.getWriter();
		if(null!=currentUser||null!=currentAdmin){
		User user=null;
		String tmp="";
		tmp=request.getParameter("userid");
		int userid=0;
		if(null==tmp)
			userid=currentUser.getUserid();
		else
		    userid=Integer.parseInt(tmp);
		String fromPage=request.getParameter("fromPage");
		user=userService.queryUserById(userid);
		if(null!=user){
			request.setAttribute("currentUser", user);
		}else
			out.print("<script>alert('用户信息查询失败!')</script>");
		//request.setAttribute("from", "userServlet");
		request.getRequestDispatcher(""+fromPage+".jsp?from=userServlet").forward(request, response);
		
		}else{
			
			out.print("<script>alert('您未登录!');window.parent.location='login.jsp'</script>");
		}
		out.close();
		
	}
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		PrintWriter out=response.getWriter();
		if(result){
			out.print("<script>alert('"+"操作成功!"+"')</script>");
		}else{
			out.print("<script>alert('"+"已失败!"+"')</script>");
		}
		out.print("<script>window.location=\"admin/addMember.jsp\"</script>");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=((User)request.getSession().getAttribute("user"));
		int userid=0;
		String userID=request.getParameter("userid");
		if(null!=userID){
			 userid=Integer.parseInt(userID);
		}else {
			userid=currentUser.getUserid();
		}
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
		PrintWriter out=response.getWriter();
		//request.setAttribute("from", "userServlet");
		String fromPage=request.getParameter("fromPage");
		if(result){
			out.print("<script>alert('"+"更新成功!"+"')</script>");
		}else{
			out.print("<script>alert('"+"更新失败!"+"')</script>");
		}
		queryUser(request,response);
		out.close();
	}
	protected void updateUserPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password=request.getParameter("password");
		User currentUser=(User)request.getSession().getAttribute("user");
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			boolean result=userService.updateUserPass(userid,password);
			PrintWriter out=response.getWriter();
			if(result){
				out.print("<script>alert(\"修改成功！\");window.location.href='user/updatepass.jsp'</script>");
			}else{
				out.print("<script>alert(\"修改失败！\");window.location.href='user/updatepass.jsp'</script>");	
			}
			out.close();
			//request.getRequestDispatcher("updatepass.jsp").forward(request, response);
			//response.sendRedirect("updatepass.jsp");
		}
				
	}
	protected void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid=Integer.parseInt(request.getParameter("userid"));
		String role=request.getParameter("role");
		boolean result=userService.delUserById(userid,role);
		PrintWriter  out=response.getWriter();
		if(result)
			out.print("<script>alert('"+"删除成功!"+"')</script>");
		else 
			out.print("<script>alert('"+"删除失败!"+"')</script>");
		out.print("<script>window.location.href='userServlet?action=queryAll'</script>");	
		out.close();
	}
}
