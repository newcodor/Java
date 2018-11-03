package com.ly.novel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.BookMarkMapper;
import com.ly.novel.service.BookMarkService;
import com.ly.novel.vo.BookMarkVo;

@Service
@Transactional
public class BookMarkServiceImpl implements BookMarkService {
    
    @Autowired
    private BookMarkMapper bookMarkMapper;
    
	@Override
	public List<BookMarkVo> queryAllBookMarksByUserId(int userid) {
		// TODO Auto-generated method stub
		return bookMarkMapper.queryAllBookMarksByUserId(userid);
	}

	@Override
	public boolean delBookMark(int userid, int bid[], int chaid) {
		// TODO Auto-generated method stub
	
	return bookMarkMapper.delBookMarks(userid,bid,chaid)>0?true:false;
		
	}

	@Override
	public int addBookMark(int userid, int bid, int chaid) {
		// TODO Auto-generated method stub
		int resultStatus=0;
		if(!queryBookMarkById(userid,bid,chaid)){
			if(bookMarkMapper.addBookMark(userid,bid,chaid)>0?true:false) {
				resultStatus=1;  //书签添加成功
			} else{
				resultStatus=0;  //添加失败
			}
		}
		else {
			resultStatus=2;  //书签已存在
		}
		return resultStatus;
	}

	private boolean queryBookMarkById(int userid, int bid, int chaid) {
		// TODO Auto-generated method stub
	  return  bookMarkMapper.queryBookMarkById(userid,bid,chaid)>0?true:false;
		
	}

}
