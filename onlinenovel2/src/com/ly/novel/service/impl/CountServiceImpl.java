package com.ly.novel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.service.CountService;

@Service
@Transactional
public class CountServiceImpl implements CountService {
    
	@Override
	public void updateAccessCount(int msgid) {
		// TODO Auto-generated method stub

	}

}
