package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Novel;
import com.ly.novel.entity.User;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.NovelServiceImpl;

/**
 * Servlet implementation class MessageAddServlet
 */
@WebServlet("/novelAddServlet")
public class NovelAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NovelService novelService=new NovelServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelAddServlet() {
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
		
		String  bookname =request.getParameter("bookname");
		String  bookintroduction = request.getParameter("bookintroduction");
		PrintWriter out=response.getWriter();
		User u= (User)request.getSession().getAttribute("user");
		if(null==u){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			out.print("<script>alert("+"请登录后发表!"+")</script>");
//			response.sendRedirect("login.jsp");
		}
		
		Novel novel=new Novel();
		novel.setUserid(u.getUserid());
		novel.setBookname(bookname);
		novel.setBookintroduction(bookintroduction);
		novel.setPosttime(new Date());
		novel.setPostip(request.getRemoteAddr());
		boolean result= novelService.addNovel(novel);
/*		if(result){
			out.print("<script>alert("+"发表成功!"+")</script>");
		}else{
			out.print("<script>alert("+"发表失败!"+")</script>");
			
		}*/
		request.getRequestDispatcher("/novelQueryPageServlet?currentPage=1").forward(request, response);
		
	}

}
