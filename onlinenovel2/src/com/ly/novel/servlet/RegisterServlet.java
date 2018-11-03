package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.User;
import com.ly.novel.service.UserService;
import com.ly.novel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		addUser(request,response);
	}
   protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			out.print("<script>alert('"+"注册成功!"+"');window.parent.location=\"index.jsp\"</script>");
		}else{
			out.print("<script>alert('"+"注册失败!"+"');window.parent.location=\"register.jsp\"</script>");
		}
//		request.getRequestDispatcher("index.jsp").forward(request, response);
}
}
