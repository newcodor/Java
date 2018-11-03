package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.User;
import com.ly.novel.service.BookMarkService;
import com.ly.novel.service.impl.BookMarkServiceImpl;
import com.ly.novel.vo.BookMarkVo;

/**
 * Servlet implementation class BookMarkServlet
 */
@WebServlet("/bookMarkServlet")
public class BookMarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookMarkService bookMarkService=new BookMarkServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMarkServlet() {
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
		if("query".equals(action))
			queryBookMarks(request, response);
		else if("del".equals(action))
			delBookMark(request, response);
		else if("add".equals(action))
			addBookMark(request, response);
	}
	protected void queryBookMarks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if(null!=currentUser){
	    int userid=currentUser.getUserid();
		List<BookMarkVo>  bookMarkVos=null;
		bookMarkVos=bookMarkService.queryAllBookMarksByUserId(userid);
		if(null!=bookMarkVos){
			request.setAttribute("bookMarkVos", bookMarkVos);
			request.setAttribute("fromPage", "bookMarkServlet");
			request.getRequestDispatcher("bookmark.jsp").forward(request, response);
		}
		}else {
			out.print("<script>alert(\"您尚未登录!\");window.location.href='login.jsp'</script>");
		}
		//out.close();
			
	}
	
	protected void delBookMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] selecedNovels=request.getParameterValues("selecedNovel");
		int [] bids=new int [selecedNovels.length];
		if(null!=selecedNovels){
			int i=-1;
	         for(String str : selecedNovels) {
				bids[++i]=Integer.parseInt(str);
			}
		}
		//int  chaid=Integer.parseInt(request.getParameter("chaid"));
		PrintWriter  out=response.getWriter();
		User currentUser=(User)request.getSession().getAttribute("user");
		if(null==currentUser){
			out.print("<script>alert(\"您尚未登录!\")</script>");
			response.sendRedirect("login.jsp");
			return;
		}
		int userid=currentUser.getUserid();
        if(bookMarkService.delBookMark(userid,bids,0)){
        	out.print("<script>alert(\"删除成功!\")</script>");
        }else{
        	out.print("<script>alert(\"删除失败!\")</script>");
        }
        response.sendRedirect("bookmark.jsp?userid="+((User)request.getSession().getAttribute("user")).getUserid());
        out.close();
	}
	protected void addBookMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=((User)request.getSession().getAttribute("user"));
		PrintWriter  out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int bid=Integer.parseInt(request.getParameter("bid"));
			int chaid=Integer.parseInt(request.getParameter("chaid"));
			int resultStatus=bookMarkService.addBookMark(userid,bid,chaid);
              if(resultStatus==1)
				out.write("success");
			else if(resultStatus==2)
				out.write("exist");
			else if(resultStatus==0)
				out.write("fail");
		}else{
			out.write("nologin");
		}
		

		
		out.close();
	}
}
