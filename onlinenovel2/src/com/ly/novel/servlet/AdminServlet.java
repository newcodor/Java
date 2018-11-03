package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.User;
import com.ly.novel.service.AdminService;
import com.ly.novel.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdminService  adminService=new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
//		if(null!=flag){
//			if(flag.equals("addAdmin"))
//				addAdmin(request, response);
//			else if(flag.equals("updateAdmin"))
//				updateAdmin(request, response);
//		}
		if("query".equals(action))
			queryAdmin(request, response);
		else if("update".equals(action))
			updateAdmin(request, response);
		else if("updatePass".equals(action))
			updateAdminPass(request, response);
		else {
			response.sendRedirect("admin/admin.jsp");
		}
			
	}
	protected void queryAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Admin admin=null;
		admin=adminService.queryAdmin();
		if(null!=admin){
			request.setAttribute("adminInfo", admin);
			request.getRequestDispatcher("admin/updateAdmin.jsp").forward(request, response);;
		}else{
			PrintWriter out=response.getWriter();
			out.print("<scipr>alert('管理员信息查询失败!')</script>");
			response.sendRedirect("admin/admin.jsp");
		}
		
	}
	protected void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int adminId=Integer.parseInt(request.getParameter("adminid"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		Admin admin=new Admin();
		admin.setAdminid(adminId);
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setEmail(email);
		PrintWriter out=response.getWriter();
		if(adminService.updateAdmin(admin)){
			out.print("<script>alert('更新成功!')</script>");
		}else{
			out.print("<script>alert('更新失败!')</script>");
		}
		out.print("<script>window.location.href='adminServlet?action=query'</script>");
		
	}
	protected void updateAdminPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password=request.getParameter("password");
		Admin currentAdmin=(Admin)request.getSession().getAttribute("admin");
		PrintWriter out=response.getWriter();
		if(null!=currentAdmin){
			int adminid=currentAdmin.getAdminid();
			Admin admin=new Admin();
			admin.setAdminid(adminid);
			admin.setPassword(password);
			boolean result=adminService.updateAdminPass(admin);
			if(result){
				out.print("<script>alert(\"修改成功！\");window.location.href='admin/updateAdmin.jsp'</script>");
			}else{
				out.print("<script>alert(\"修改失败！\");window.location.href='admin/updateAdmin.jsp'</script>");	
			}
			//request.getRequestDispatcher("updatepass.jsp").forward(request, response);
			//response.sendRedirect("updatepass.jsp");
		}else{
			out.print("<script>alert(\"您未登录！\");window.parent.location='admin/admin_login.jsp'</script>");	
			
		}
		out.close();
	}

}
