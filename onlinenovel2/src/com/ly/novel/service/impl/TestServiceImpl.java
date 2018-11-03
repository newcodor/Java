package com.ly.novel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.novel.dao.NovelMapper;
import com.ly.novel.entity.category;
import com.ly.novel.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private NovelMapper novelMapper;
	@Override
	public List<category> queryAllCategorys(){
		// TODO Auto-generated method stub
        if(null==novelMapper) {
        	System.out.println("is null");
        }
        List<category> categorys=null;
        if(null!=novelMapper.queryAllCategorys())
        	categorys=novelMapper.queryAllCategorys();
        else
        	System.out.println("failed");
        if(null==categorys) {
        	System.out.println("result is null!");
        }
        else {
        	System.out.println("size:"+categorys.size());
        	System.out.println(categorys);
        }
		return categorys;
	}

}
