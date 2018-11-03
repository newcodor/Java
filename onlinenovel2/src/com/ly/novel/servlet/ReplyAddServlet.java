package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Reply;
import com.ly.novel.entity.User;
import com.ly.novel.service.ReplyService;
import com.ly.novel.service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class ReplyAddServlet
 */
@WebServlet("/replyAddServlet")
public class ReplyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyService replyService=new ReplyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyAddServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		User u= (User)request.getSession().getAttribute("user");
		if(null!=u){
			if(request.getParameter("bid").equals("0")){
				out.print("<script>alert('"+"评论失败!错误:缺少bid值"+"');window.parent.location=\"index.jsp\"</script>");
			}
			int bid=Integer.parseInt(request.getParameter("bid"));
			int userid=u.getUserid();
			String replycontent=request.getParameter("replycontents");
			Date replytime=new Date();
			String replyip=request.getRemoteAddr();
			Reply reply=new Reply(bid,userid,replycontent,replytime,replyip);
			boolean result=replyService.addReply(reply);
			if(result){
				out.print("<script>alert('"+"回复成功!"+"');window.location.href=\"detail.jsp?bid="+bid+"\"</script>");
			}else{
				out.print("<script>alert('"+"回复成功!"+"');window.location.href=\"detail.jsp?bid="+bid+"\"</script>");
				
			}
		}
		else {
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			out.print("<script>alert('"+"请登录后评论!"+"');window.parent.location=\"login.jsp\"</script>");
//			
			//response.sendRedirect("login.jsp");
		}
		out.close();
		
		
	}

}
