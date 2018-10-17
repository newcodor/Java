package com.newcodor.springmvc.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newcodor.springmvc.entity.Items;
import com.newcodor.springmvc.entity.QueryVo;
import com.newcodor.springmvc.exception.MessageException;
import com.newcodor.springmvc.service.ItemService;

@Controller
public class ProductController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value= {"/product/product.action","/product/list.action"})
	public ModelAndView show() {
//		Integer i=1/0;   //异常测试
	
		ModelAndView mav = new  ModelAndView();
		
		List<Items> list =itemService.selectItemList();
		
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		
		return mav;
	}
	
	
	@RequestMapping(value="/product/toEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse  response,Model model) throws MessageException {
		
		String  id=request.getParameter("id");
		if(null==id||"".equals(id)) {
			throw new MessageException("商品id不可为空!");
		}
		Items item =itemService.selectItemById(Integer.parseInt(id));
		ModelAndView mav =new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	@RequestMapping(value="/product/updateProduct.action",method= {RequestMethod.POST,RequestMethod.GET})
	public String updateProduct(QueryVo  vo,MultipartFile pictureFile,HttpServletRequest request) throws Exception {
		
		
		if(null==vo.getItem()) {
			throw new RuntimeException();
		}
		
		
		String ext= FilenameUtils.getExtension(pictureFile.getOriginalFilename());  //获取文件后缀名
		
		String filename= UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
		
		pictureFile.transferTo(new File(request.getServletContext().getRealPath("/")+"/upload/"+filename));
//		System.out.println(request.getServletContext().getRealPath("/")+"/upload/"+filename);
		vo.getItem().setPic(filename);
//		ModelAndView mav = new ModelAndView();
		itemService.updateItem(vo.getItem());
//		mav.setViewName("success");
		return "redirect:/product/list.action";
	}
	
	@RequestMapping(value="/product/delete.action")
	public String deleteProduction(Integer [] ids,Model model) throws MessageException {
		
		if(null!=ids) {
			throw new MessageException("必须选择至少一个要删除的商品!");
		}
		ModelAndView mav = new ModelAndView();
		for(Integer i:ids) {
			System.out.print(i+"\t");
			
		}
		System.out.println();
		return "/product/product.action";
	}
	
	@RequestMapping(value="/product/updateSelect.action")
	public ModelAndView updateSelectProductions(QueryVo  vo) {
		

		
		ModelAndView mav = new ModelAndView();
		for(Items item:vo.getItemList()) {
			System.out.println(item);
		}
		mav.setViewName("success");
		return mav;
	}
}
