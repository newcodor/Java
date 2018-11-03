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
import com.ly.novel.entity.Review;
import com.ly.novel.entity.User;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.vo.ReviewVo;

/**
 * Servlet implementation class NovelServlet
 */
@WebServlet("/novelApplyServlet")
public class NovelApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NovelService novelService =new NovelServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelApplyServlet() {
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
			queryAllReviews(request, response);
		}else if("apply".equals(action)){
			applyBook(request, response);
		}else if("query".equals(action)){
			queryReview(request, response);
		}
		else if("review".equals(action)){
			doReview(request, response);
		}
	}
	protected void queryAllReviews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin currentAdmin=(Admin)(request.getSession().getAttribute("admin"));
		PrintWriter out=response.getWriter();
		if(null!=currentAdmin){
			List<ReviewVo> reviewVos=novelService.queryAllReviews();
			request.setAttribute("reviewVos", reviewVos);
			request.setAttribute("fromPage", "novelApplyServlet");
			request.getRequestDispatcher("admin/reviewList.jsp").forward(request, response);
		}else{
			out.print("<script>alert('您未登录!');window.location.href='admin/admin_login.jsp'</script>");

		}
		out.close();
	}
	protected void doReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("rid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		String reviewStatus=request.getParameter("reviewStatus");
		boolean result=novelService.reviewNovel(rid, userid, reviewStatus);
		PrintWriter out=response.getWriter();
		if(result){
			if("pass".equals(reviewStatus)){
				out.print("<script>alert('审核通过!');window.location.href='novelApplyServlet?action=queryAll'</script>");
			}else if("nopass".equals(reviewStatus)){
				out.print("<script>alert('审核不通过!');window.location.href='novelApplyServlet?action=queryAll'</script>");

			}
				
		}else{
			out.print("<script>alert('操作失败!');window.location.href='novelApplyServlet?action=queryAll'</script>");

		}
		out.close();
	}
	protected void queryReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin currentAdmin=(Admin)(request.getSession().getAttribute("admin"));
		PrintWriter out=response.getWriter();
		if(null!=currentAdmin){
			int rid=Integer.parseInt(request.getParameter("rid"));
			ReviewVo reviewVo=novelService.queryAllReviewById(rid);
			request.setAttribute("reviewVo", reviewVo);
			request.setAttribute("fromPage", "novelApplyServlet");
			request.getRequestDispatcher("admin/reviewUser.jsp").forward(request, response);
		}else{
			out.print("<script>alert('您未登录!');window.location.href='admin/admin_login.jsp'</script>");

		}
		out.close();
	}
	protected void applyBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int cid=Integer.parseInt(request.getParameter("cid"));
			String  bookname=request.getParameter("bookname");
			String  bookintroduction=request.getParameter("bookintroduction");
			String  bookSampleDraft=request.getParameter("bookSampleDraft");
			String reviewStatus="waitpass";
			Date applyTime=new Date();
			String postip=request.getRemoteAddr();
			response.setContentType("text/html; charset=UTF-8");
			Review reviewNovel=new Review(userid,cid,0,bookname,bookintroduction,bookSampleDraft,reviewStatus,applyTime,postip);
			if(novelService.addReviewNovel(reviewNovel)){
				
				out.print("<script>alert('提交成功,请等待审核!');window.location.href='user/applyWriter.jsp'</script>");
			}
		}else{
			
		out.print("<script>alert('您未登录!');window.location.href='login.jsp'</script>");
		}
		out.close();
	}
}
