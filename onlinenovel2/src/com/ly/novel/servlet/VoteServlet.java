package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.novel.entity.User;
import com.ly.novel.service.VoteService;
import com.ly.novel.service.impl.VoteServiceImpl;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/voteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoteService voteService=new VoteServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
		doVote(request, response);
	}
	protected void doVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int voteStatus=voteService.addVote(userid,bid);
			if(voteStatus==1)
				out.write("success");
			else if(voteStatus==2)
				out.write("exist");
			else if(voteStatus==0)
				out.write("fail");
		}else{
			out.write("nologin");
		}
		out.close();

	}
}
