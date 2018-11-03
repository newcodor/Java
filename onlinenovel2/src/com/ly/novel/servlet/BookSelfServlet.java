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
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.vo.BookSelfVo;

/**
 * Servlet implementation class NovelServlet
 */
@WebServlet("/bookSelfServlet")
public class BookSelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NovelService novelService=new NovelServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSelfServlet() {
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
			query(request, response);
		else if("del".equals(action))
			delBookSelf(request, response);
		else if("add".equals(action))
			addBookSelf(request, response);
			
	}
	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User currentUser=(User)request.getSession().getAttribute("user");  //获取当前用户对象
		PrintWriter out=response.getWriter();        //输出对象
		response.setContentType("text/html;charset=utf-8");   //设置编码,防止中文乱码
		if(null!=currentUser){                          //判断用户是否登录
		int userid=currentUser.getUserid();            //获取当前用户userid
	    List<BookSelfVo>  bookSelfVos=null;            //定义书架数据集合
		bookSelfVos=novelService.queryAllBookSelfsByUserId(userid);   //调用Service层方法获取书架信息
		if(null!=bookSelfVos){
			request.setAttribute("bookSelfVos", bookSelfVos);
			request.setAttribute("fromPage", "bookSelfServlet");
			request.getRequestDispatcher("bookself.jsp").forward(request, response);  //转发器
			out.close();
		    }
		}
		else{
			out.print("<script>alert(\"您尚未登录!\");window.location.href='login.jsp'</script>");  //用户未登录，则跳转到登录界面
			out.close();
		}
		out.close();
	}
	
	protected void delBookSelf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] selecedNovels=request.getParameterValues("selecedNovel");
		int [] bids=new int [selecedNovels.length];
		if(null!=selecedNovels){
			int i=-1;
	         for(String str : selecedNovels) {
				bids[++i]=Integer.parseInt(str);
			}
		}
		PrintWriter  out=response.getWriter();
		User currentUser=(User)request.getSession().getAttribute("user");
		if(null==currentUser){
			out.print("<script>alert(\"您尚未登录!\")</script>");
			response.sendRedirect("login.jsp");
			return;
		}
		int userid=currentUser.getUserid();
        if(novelService.delBookSelf(userid,bids)){
        	out.print("<script>alert(\"移除成功!\")</script>");
        }else{
        	out.print("<script>alert(\"移除失败!\")</script>");
        }
        response.sendRedirect("bookself.jsp?userid="+((User)request.getSession().getAttribute("user")).getUserid());
        out.close();
	}
	protected void addBookSelf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=((User)request.getSession().getAttribute("user"));
		PrintWriter  out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int bid=Integer.parseInt(request.getParameter("bid"));
			int resultStatus=novelService.addBookSelf(userid,bid);
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
