package com.ly.novel.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.category;
import com.ly.novel.service.AdminService;
import com.ly.novel.service.NovelService;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.NovelVo;


@Controller
public class NovelController {
	@Autowired
	private AdminService  adminService;
	@Autowired
	private NovelService novelService;
	
	@RequestMapping(value="/admin/{id}")
	public String queryAdmin(@PathVariable Integer id,Model model) {
		Admin admin=adminService.queryAdminById(id);
		System.out.println(admin);
		model.addAttribute("admin", admin);
		return  "forward:/list.jsp";
	}
	
	@RequestMapping(value="/category/list")
	public String queruCategory(Model model) {
		List<category> categorys=novelService.queryAllCategorys();
		model.addAttribute("origin","forward");
		model.addAttribute("categorys", categorys);
		return  "forward:/head.jsp";
		
	}
	
	@RequestMapping("/novel/list")
	public String novelQueryByPage(String fromPage,Integer currentPage,Model model) {
		int totalCount=novelService.getNovelsCount();
		try{
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		
		List<NovelVo> mList=novelService.queryNovelsByPage(page);
		page.setList(mList);
		model.addAttribute("origin", "forward");
		model.addAttribute("page", page);
		if("".equals(fromPage))
		  return  "forward:/novel.jsp";
		else
			return  "forward:/"+fromPage+".jsp";
			
	}

}
