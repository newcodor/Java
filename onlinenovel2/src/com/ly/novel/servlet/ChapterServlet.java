package com.ly.novel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.Chapter;
import com.ly.novel.service.ChapterService;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.ChapterServiceImpl;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.ChapterVo;

/**
 * Servlet implementation class ChapterServlet
 */
@WebServlet("/chapterServlet")
public class ChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NovelService novelService=new NovelServiceImpl();
	private ChapterService chapterService=new ChapterServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterServlet() {
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
		if("queryAll".equals(action))
			queryAllChapters(request, response);
		else if("query".equals(action))
			queryChapter(request, response);
		else if("add".equals(action))
			addChapter(request, response);
		else if("update".equals(action))
			updateChapter(request, response);
		else if("del".equals(action))
			delChapter(request, response);
		else 
			response.sendRedirect("index.jsp");
			
	}
	protected void queryAllChapters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int  bid=Integer.parseInt(request.getParameter("bid"));
		request.setAttribute("action", "from");
		int totalCount=novelService.getChapterCount(bid);
		int currentPage=1;
		try{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		List<Chapter> mList=novelService.queryChaptersByPage(bid,page);
		page.setList(mList);
		request.setAttribute("page", page);
		String requestFrom=request.getParameter("from");
		String destinationPage=null;
			destinationPage="detail.jsp";
		request.getRequestDispatcher(destinationPage).forward(request, response);
	
	}
	protected void queryChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		int chaid=Integer.parseInt(request.getParameter("chaid"));
		ChapterVo chapterVo=chapterService.queryChapterVo(bid, chaid);
		int frontChapterId=chapterService.queryfrontChapterId(bid,chaid);
	    int nextChapterId=chapterService.querynextChapterId(bid,chaid);
	    String fromPage=request.getParameter("fromPage");
		if(null!=chapterVo){
			request.setAttribute("fromPage", "chapterServlet");
			request.setAttribute("chapterVo", chapterVo);
			Map<String,Integer> frontAndNextchapterIdInfo=new HashMap<String,Integer>();
			frontAndNextchapterIdInfo.put("frontChapterId", frontChapterId);
			frontAndNextchapterIdInfo.put("nextChapterId", nextChapterId);
			request.setAttribute("frontAndNextchapterIdInfo", frontAndNextchapterIdInfo);
			request.getRequestDispatcher(fromPage+".jsp?bid="+String.valueOf(bid)+"&chaid="+String.valueOf(chaid)+"").forward(request, response);
		}
		return;
	}
	protected void addChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		Chapter chapter=new Chapter(bid,title,contents,new Date());
		PrintWriter out=response.getWriter();
		boolean result=chapterService.addChapter(chapter);
		if(result){
			out.print("<script>alert('发表成功!');window.location.href='writer/addChapter.jsp?bid="+bid+"'</script>");
		}else{
			out.print("<script>alert('发表失败!');window.location.href='writer/addChapter.jsp?bid="+bid+"'</script>");

		}
		out.close();
	}
	protected void updateChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		int chaid=Integer.parseInt(request.getParameter("chaid"));
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		Chapter chapter=new Chapter();
		chapter.setBid(bid);
		chapter.setChaid(chaid);
		chapter.setTitle(title);
		chapter.setContents(contents);
		boolean result=chapterService.updateChapter(chapter);
		PrintWriter out=response.getWriter();
		if(result){
			out.print("<script>alert('修改成功!')</script>");
		}else{
			out.print("<script>alert('修改失败!')</script>");
		}
	    queryChapter(request, response);
	    out.close();
	}
	protected void delChapter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		int chaid=Integer.parseInt(request.getParameter("chaid"));
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		boolean result=chapterService.delChapterById(bid,chaid);
		PrintWriter out=response.getWriter();
		if(result){
			out.print("<script>alert('删除成功!');window.location.href='writer/novel_list.jsp?currentPage="+currentPage+"&bid="+bid+"'</script>");
		}else{
			out.print("<script>alert('删除失败!');window.location.href='writer/novel_list.jsp?currentPage="+currentPage+"&bid="+bid+"'</script>");
		}
		out.close();
		
	}
}
