package com.ly.novel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ly.novel.entity.category;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.impl.NovelServiceImpl;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NovelService novelService=new NovelServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
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
	
		queryAllCategorys(request, response);
		
	}
	protected void queryAllCategorys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<category> categorys=novelService.queryAllCategorys();
		request.setAttribute("query", "query");
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//return;
	}
}
