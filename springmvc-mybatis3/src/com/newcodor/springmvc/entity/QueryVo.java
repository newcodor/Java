package com.newcodor.springmvc.entity;

import java.util.List;

public  class QueryVo {
	private Items item;
	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	private List<Items> itemList;
	
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
	
}
