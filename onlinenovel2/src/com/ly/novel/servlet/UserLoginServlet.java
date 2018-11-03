package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.User;
import com.ly.novel.service.UserService;
import com.ly.novel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  UserService userService =new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user=userService.login(user);
		PrintWriter out =response.getWriter();
		if(null!=user){
			out.write("登录成功!");
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			out.print("<script>alert('用户名或密码错误!');window.location.href='login.jsp'</script>");
			
		}
		out.close();
	}

}
