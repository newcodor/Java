package com.ly.novel.servlet;

import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.PageRanges;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.service.NovelService;
import com.ly.novel.service.ReplyService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.service.impl.ReplyServiceImpl;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReplyVo;

/**
 * Servlet implementation class NovelQueryPageServlet
 */
@WebServlet("/novelQueryPageServlet")
public class NovelQueryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NovelService novelService=new NovelServiceImpl();
	private ReplyService replyService=new ReplyServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelQueryPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		if("queryAll".equals(action))
			queryAllNovels(request, response);
		else if("query".equals(action))
			queryNovelInfoById(request, response);
		else if("search".equals(action))
			searchNovelInfoById(request, response);
		else if("category".equals(action))
			categoryNovelsByCid(request, response);
		
//		String bid=request.getParameter("bid");
//		request.setAttribute("action", "from");
//		if(null!=bid){
//			queryNovelInfoById(request,response,bid);
//		}
//		int totalCount=novelService.getNovelsCount();
//		int currentPage=1;
//		try{
//			currentPage=Integer.parseInt(request.getParameter("currentPage"));
//			currentPage=currentPage>0?currentPage:1;
//		}catch(Exception e){
//			currentPage=1;
//		}
//		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=UTF-8");
//		String keyword="";
//		keyword=request.getParameter("keyword");
//		String destinationPage="index.jsp";
//		String keyword2="";
//		if("".equals(keyword))
//			keyword="%";
//		else{
//			keyword2=keyword;
//			keyword="%"+keyword+"%";
//			destinationPage="search.jsp";
//		}
//		int cid=0;
//		//cid=Integer.parseInt(request.getParameter("cid"));
//		List<NovelVo> mList=novelService.queryNovelsByPage(page,keyword,cid);
//		page.setList(mList);
//		if(!"".equals(keyword2))
//			request.setAttribute("keyword", keyword2);
//		if(cid!=0){
//			destinationPage="category.jsp";
//			request.setAttribute("cid", cid);
//		}
//		request.setAttribute("page", page);
//		//String requestFrom=request.getParameter("from");
//		request.getRequestDispatcher(destinationPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void queryAllNovels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int totalCount=novelService.getNovelsCount();
		int currentPage=1;
		try{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("from", "novelQueryPageServlet");
		List<NovelVo> mList=novelService.queryNovelsByPage(page);
		page.setList(mList);
		String fromPage=request.getParameter("fromPage");
		request.setAttribute("page", page);
		request.getRequestDispatcher(fromPage+".jsp").forward(request, response);
	}
	   protected void queryNovelInfoById(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		    String bid=request.getParameter("bid");
		    NovelVo novelVo=novelService.queryNovelById(Integer.parseInt(bid));	
			List<ReplyVo> replyVos=replyService.findReplyByBid(Integer.parseInt(bid));
			request.setAttribute("mi", novelVo);
			request.setAttribute("rList", replyVos);
			request.setAttribute("from", "novelQueryPageServlet");
			String fromPage=request.getParameter("fromPage");
			try {
				request.getRequestDispatcher(fromPage+".jsp?bid="+bid).forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	   
	   protected void searchNovelInfoById(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		    int totalCount=novelService.getNovelsCount();
			int currentPage=1;
			try{
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
				currentPage=currentPage>0?currentPage:1;
			}catch(Exception e){
				currentPage=1;
			}
			String keyword=request.getParameter("keyword");
			Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			request.setAttribute("from", "novelQueryPageServlet");
			List<NovelVo> mList=novelService.querySearchNovelsByPage(page,keyword);
			page.setList(mList);
			String fromPage=request.getParameter("fromPage");
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			request.getRequestDispatcher(fromPage+".jsp").forward(request, response);
			return;
	    }
	   protected void categoryNovelsByCid(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		    int totalCount=novelService.getNovelsCount();
			int currentPage=1;
			try{
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
				currentPage=currentPage>0?currentPage:1;
			}catch(Exception e){
				currentPage=1;
			}
			int cid=Integer.parseInt(request.getParameter("cid"));
			String categoryname=request.getParameter("categoryname");
			Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			request.setAttribute("from", "novelQueryPageServlet");
			List<NovelVo> mList=novelService.queryCategoryNovelsByCid(page,cid);
			page.setList(mList);
			String fromPage=request.getParameter("fromPage");
			request.setAttribute("page", page);
			request.setAttribute("categoryname", categoryname);
			request.getRequestDispatcher(fromPage+".jsp").forward(request, response);
	    }
}
