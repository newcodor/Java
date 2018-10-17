package com.newcodor.springmvc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newcodor.springmvc.entity.Items;
import com.newcodor.springmvc.service.ItemService;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

@Controller
public class ProductController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/product/product.action")
	public ModelAndView show() {
		
	
		ModelAndView mav = new  ModelAndView();
		
		List<Items> list =itemService.selectItemList();
		
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		
		return mav;
	}
	
	
	@RequestMapping(value="/product/toEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse  response,Model model) {
		
		Integer  id=Integer.parseInt(request.getParameter("id"));
		Items item =itemService.selectItemById(id);
		ModelAndView mav =new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	@RequestMapping(value="/product/updateProduct.action")
	public ModelAndView updateProduct(Items item) {
		
		ModelAndView mav = new ModelAndView();
		itemService.updateItem(item);
		mav.setViewName("success");
		return mav;
	}
}
