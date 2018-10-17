package com.newcodor.springmvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newcodor.springmvc.entity.Items;
import com.newcodor.springmvc.service.ItemService;

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
}
