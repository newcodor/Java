package com.newcodor.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcodor.ssm.dao.BaseDictMapper;
import com.newcodor.ssm.entity.BaseDict;
import com.newcodor.ssm.entity.BaseDictExample;
import com.newcodor.ssm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict>  quertyBaseDictType(String code){
		BaseDictExample example=new BaseDictExample();
		example.createCriteria().andDictTypeCodeEqualTo(code);
		
		return baseDictMapper.selectByExample(example);
	}

}
