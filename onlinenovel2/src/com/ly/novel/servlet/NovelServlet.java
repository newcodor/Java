package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.Novel;
import com.ly.novel.entity.User;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.NovelVo;

/**
 * Servlet implementation class NovelServlet
 */
@WebServlet("/novelServlet")
public class NovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  NovelService novelService=new NovelServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelServlet() {
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
		if("queryAll".equals(action)){
			queryAllNovelsByUserid(request,response);
			return;
		}else if("review".equals(action)){
	    	reviewNovel(request,response);   //提交审核小说
	    }else if("query".equals(action)){
			queryNovel(request,response);
		}else if("manageAll".equals(action)){
			manageAllNovels(request,response);
		}else if("add".equals(action)){
			addNovel(request,response);
		}else if("del".equals(action)){
			delNovel(request,response);
		}
	    else if("update".equals(action)){
		    updateNovel(request,response);
	    }else if("finish".equals(action)){
	    	finishNovelById(request,response);
	    }else{
	    	
	    }
	}
	protected void queryAllNovelsByUserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			response.setContentType("text/html; charset=UTF-8");
			List<Novel> novels=novelService.queryAllNovelsByUserid(userid);
			if(null!=novels){
				request.setAttribute("novels", novels);
				request.setAttribute("fromPage", "novelServlet");
				request.getRequestDispatcher("writer/myNovel.jsp").forward(request, response);
				//out.close();
				//return;
			}
				
		}else{
			
		out.print("<script>alert('您未登录!');window.parent.location='../login.jsp'</script>");
		}
		out.close();
		
	}
	protected void manageAllNovels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin currentAdmin=null;
		currentAdmin=(Admin)request.getSession().getAttribute("admin");
		PrintWriter out=response.getWriter();
		if(null!=currentAdmin){
			response.setContentType("text/html; charset=UTF-8");
			int totalCount=novelService.getNovelsCount();
			int currentPage=1;
			try{
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
				currentPage=currentPage>0?currentPage:1;
			}catch(Exception e){
				currentPage=1;
			}
			Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
			List<NovelVo> novelVos=novelService.queryNovelsByPage(page);
			if(null!=novelVos){
				page.setList(novelVos);
				request.setAttribute("page", page);
				request.setAttribute("fromPage", "novelServlet");
				request.getRequestDispatcher("admin/novelManager.jsp").forward(request, response);
				//out.close();
				//return;
			}
				
		}else{
			
		out.print("<script>alert('您未登录!');window.parent.location='../login.jsp'</script>");
		}
		out.close();
		
	}
	protected void reviewNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int rid=Integer.parseInt(request.getParameter("rid"));
			String reviewStatus =request.getParameter("reviewStatus");
			boolean result=novelService.reviewNovel(rid,userid,reviewStatus);
			if(result){
				if("pass".equals(reviewStatus))
				    out.print("<script>alert('审核通过！');window.location.href='login.jsp'</script>");
				else if("nopass".equals(reviewStatus)){
					out.print("<script>alert('审核不通过！');window.location.href='login.jsp'</script>");
				}
				
			}else{
				out.print("<script>alert('审核失败!');window.location.href='login.jsp'</script>");
				
			}
		}else{
			
			out.print("<script>alert('您未登录!');window.location.href='login.jsp'</script>");
			}
			out.close();
		
	}
	protected void queryNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   PrintWriter out=response.getWriter();
			int bid=Integer.parseInt(request.getParameter("bid"));
			String fromPage=request.getParameter("fromPage");
			response.setContentType("text/html; charset=UTF-8");
			NovelVo novelVo=novelService.queryNovelById(bid);
			if(null!=novelVo){
				request.setAttribute("novelVo", novelVo);
				request.setAttribute("fromPage", fromPage);
				request.getRequestDispatcher(""+fromPage+".jsp?from=novelServlet").forward(request, response);
				//out.close();
				//return;
			}else {
				out.print("<script>alert('查询失败!');window.location.href='"+fromPage+".jsp?from=novelServlet'</script>");
			}
		
		out.close();
		
	}
	protected void addNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int cid=Integer.parseInt(request.getParameter("cid"));
			String  bookname=request.getParameter("bookname");
			String  bookintroduction=request.getParameter("bookintroduction");
			String postip=request.getRemoteAddr();
			Date posttime=new Date();
			response.setContentType("text/html; charset=UTF-8");
			Novel novel=new Novel();
			novel.setUserid(userid);
			novel.setBookname(bookname);
			novel.setBookintroduction(bookintroduction);
			novel.setPostip(postip);
			novel.setPosttime(posttime);
			novel.setCid(cid);
			if(novelService.addNovel(novel)){
				
				out.print("<script>alert('发表成功');window.location.href='writer/addNovel.jsp'</script>");
			}else{
				out.print("<script>alert('发表失败');window.location.href='writer/addNovel.jsp'</script>");
				
			}
		}else{
			
		out.print("<script>alert('您未登录!');window.location.href='login.jsp'</script>");
		}
		out.close();
	}
	protected void delNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		boolean result=novelService.delNovelById(bid);
		PrintWriter out=response.getWriter();
		if(result){
			out.print("<script>window.location.href='writer/myNovel.jsp'</script>");

		}else{
			out.print("<script>alert('删除失败');window.location.href='writer/myNovel.jsp'</script>");

		}
		out.close();
	}
	protected void updateNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		Admin currentAdmin=null;
		currentAdmin=(Admin)request.getSession().getAttribute("admin");
		PrintWriter out=response.getWriter();
		if(null!=currentUser||null!=currentAdmin){
			int bid=Integer.parseInt(request.getParameter("bid"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			String bookname=request.getParameter("bookname");
			String bookintroduction=request.getParameter("bookintroduction");
			Novel novel=new Novel();
			novel.setBid(bid);
			novel.setCid(cid);
			novel.setBookname(bookname);
			novel.setBookintroduction(bookintroduction);
			//String fromPage=request.getParameter("fromPage");
			response.setContentType("text/html; charset=UTF-8");
			boolean result=novelService.updateNovel(novel);
			if(result){
				//request.setAttribute("fromPage","novelServlet");
				//request.getRequestDispatcher(""+fromPage+".jsp?from=novelServlet").forward(request, response);
				//out.close();
				//return;
				out.print("<script>alert('修改成功!')</script>");
			}else {
				out.print("<script>alert('修改失败!')</script>");
			}
				queryNovel(request, response);
		}else{
			
		out.print("<script>alert('您未登录!');window.parent.location='login.jsp'</script>");
		}
		out.close();
	}
	protected void finishNovelById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		boolean result=novelService.finishNovelById(bid);
		PrintWriter out=response.getWriter();
		if(result){
			out.print("<script>window.location.href='writer/myNovel.jsp'</script>");

		}else{
			out.print("<script>alert('完本操作失败');window.location.href='writer/addNovel.jsp'</script>");

		}
		out.close();
	}

}
