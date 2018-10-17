package com.newcodor.springmvc.service;

import java.util.List;

import com.newcodor.springmvc.entity.Items;

public interface ItemService {
	List<Items>  selectItemList();
	
	public Items selectItemById(Integer id);
	
	public boolean  updateItem(Items item);
}
