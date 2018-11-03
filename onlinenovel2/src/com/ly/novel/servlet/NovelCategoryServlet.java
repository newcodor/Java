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

import com.ly.novel.entity.category;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.TestService;
import com.ly.novel.service.impl.NovelServiceImpl;
import com.ly.novel.service.impl.TestServiceImpl;

/**
 * Servlet implementation class NovelCategoryServlet
 */
@WebServlet("/novelCategoryServlet")
public class NovelCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  NovelService novelService=new NovelServiceImpl();
    private  TestService testService=new TestServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelCategoryServlet() {
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
			queryCategorys(request, response);
		else if("add".equals(action))
			addCategory(request,response);
		else if("del".equals(action))
			delCategory(request,response);
	}
	private void delCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("cid"));
		PrintWriter out=response.getWriter();
		if(novelService.delCategory(cid)){
			out.print("<script>alert('删除成功!')</script>");
		}else{
			out.print("<script>alert('删除失败!')</script>");
		}
		out.print("<script>window.location.href='novelCategoryServlet?action=query'</script>");
	}

	protected void queryCategorys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		List<category> categorys;
		

		testService.queryAllCategorys();
		System.out.println("ok");
		if(null==testService.queryAllCategorys()) {
			System.out.println("categorys is null!");
			return;
		}
		System.out.println("ok");
		categorys=testService.queryAllCategorys();
		System.out.println(categorys);
		String fromPage=request.getParameter("fromPage");
		if(null!=categorys){
			request.setAttribute("categorys", categorys);
			request.setAttribute("origin", "forward");
			request.getRequestDispatcher(fromPage+".jsp").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script>alert('分类信息查询失败!');window.location.href='"+fromPage+".jsp'</script>");
		}
		
	}
	protected void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String categoryName=request.getParameter("categoryname");
		Date createTime=new Date();
		PrintWriter out=response.getWriter();
		if(novelService.addCategory(categoryName,createTime)){
			out.print("<script>alert('添加成功!')</script>");
		}else{
			out.print("<script>alert('添加失败!')</script>");
		}
		out.print("<script>window.location.href='novelCategoryServlet?action=query'</script>");
	}
}
