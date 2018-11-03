package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	PrintWriter out=response.getWriter();
	if(session!=null){
		if(null!=session.getAttribute("user")){
			session.removeAttribute("user");
			session.invalidate();
			out.print("<script>alert(\"您已退出登录!\")</script>");
			out.print("<script>window.parent.location='login.jsp'</script>");
//			response.sendRedirect("login.jsp");
		}
		else if(null!=session.getAttribute("admin")){
			session.removeAttribute("admin");
			session.invalidate();
			out.print("<script>alert(\"您已退出登录!\")</script>");
			response.sendRedirect("admin/admin_login.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
