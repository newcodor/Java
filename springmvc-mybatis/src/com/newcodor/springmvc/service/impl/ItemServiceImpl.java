package com.newcodor.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcodor.springmvc.dao.ItemsMapper;
import com.newcodor.springmvc.entity.Items;
import com.newcodor.springmvc.service.ItemService;

/**
 * 查询商品信息
 * @author lenovo
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private   ItemsMapper itemsMapper;
	
	public List<Items>  selectItemList(){
//	  ItemsExample null;
	return 	itemsMapper.selectByExampleWithBLOBs(null);
	}
}
