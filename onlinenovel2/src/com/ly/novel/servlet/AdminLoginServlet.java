package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Admin;
import com.ly.novel.service.AdminService;
import com.ly.novel.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  AdminService adminService =new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		Admin admin=new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin=adminService.login(admin);
		PrintWriter out =response.getWriter();
		if(null!=admin){
			out.write("登录成功!");
			request.getSession().setAttribute("admin", admin);
//			request.getSession().getId();
			request.getSession().setMaxInactiveInterval(18000);  //有效期
//			saveCookie("adminId",request.getSession().getId(),18000,response);
//			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
			response.sendRedirect("admin/admin.jsp");
		}else{
			out.write("用户名或密码错误!");
			
			response.sendRedirect("admin/admin_login.jsp");
		}
		out.close();
	}
	protected void saveCookie(String name, String value, int maxAge, HttpServletResponse response)  
	{  
	    javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name,  
	            value);  
	    cookie.setMaxAge(maxAge);  
	    response.addCookie(cookie);  
	}  
}
