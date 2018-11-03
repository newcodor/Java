package com.ly.novel.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Chapter;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.ReplyService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.service.impl.ReplyServiceImpl;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReplyVo;

/**
 * Servlet implementation class NovelQueryServelt
 */
@WebServlet("/novelQueryServlet")
public class NovelQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NovelService novelService = new NovelServiceImpl();
    private ReplyService replyService=new ReplyServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if("query".equals(action))
			queryNovelInfoById(request,response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    protected void queryNovelInfoById(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String bid=request.getParameter("bid");
		String fromPage=request.getParameter("fromPage");
    	NovelVo novelVo=novelService.queryNovelById(Integer.parseInt(bid));	
		List<ReplyVo> replyVos=replyService.findReplyByBid(Integer.parseInt(bid));
		Page page=queryAllChapters(request, response);
		request.setAttribute("bid", bid);
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		request.setAttribute("from", "novelQueryServlet");
		request.setAttribute("novelVo", novelVo);
		request.setAttribute("createTime",novelVo.getPosttime());
		request.setAttribute("page", page);
		request.setAttribute("rList", replyVos);
		try {
			request.getRequestDispatcher(fromPage+".jsp?bid="+bid).forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    protected Page queryAllChapters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		int totalCount=novelService.getChapterCount(bid);
		int currentPage=1;
		try{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		List<Chapter> chapters=novelService.queryChaptersByPage(bid,page);
		page.setList(chapters);
		//request.setAttribute("page", page);	
        return page;	
	}
}
