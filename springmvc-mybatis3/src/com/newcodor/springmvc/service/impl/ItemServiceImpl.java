package com.newcodor.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcodor.springmvc.dao.ItemsMapper;
import com.newcodor.springmvc.entity.Items;
import com.newcodor.springmvc.entity.ItemsExample;
import com.newcodor.springmvc.service.ItemService;
import com.sun.org.apache.regexp.internal.recompile;

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
	
	public Items selectItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
    public boolean  updateItem(Items item) {
    	ItemsExample example = null;
		int  count=itemsMapper.updateByPrimaryKeyWithBLOBs(item);
		return count>0?true:false;
    }
	
	
}
