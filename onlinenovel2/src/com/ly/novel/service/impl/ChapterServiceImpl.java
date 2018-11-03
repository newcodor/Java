package com.ly.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.BookMarkMapper;
import com.ly.novel.dao.ChapterMapper;
import com.ly.novel.entity.Chapter;
import com.ly.novel.service.ChapterService;
import com.ly.novel.vo.ChapterVo;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
	
	
	
    
    @Autowired
    private ChapterMapper chapterMapper;
    
    @Autowired
    private BookMarkMapper bookMarkMapper;
    
	@Override
	public ChapterVo queryChapterVo(int bid, int chaid) {
		// TODO Auto-generated method stub
		return chapterMapper.queryChapterVo(bid,chaid);
	}
	@Override
	public int queryfrontChapterId(int bid, int chaid) {
		// TODO Auto-generated method stub
		return chapterMapper.queryfrontChapterId(bid,chaid);
	}
	@Override
	public int querynextChapterId(int bid,int chaid) {
		// TODO Auto-generated method stub
		return chapterMapper.querynextChapterId(bid,chaid);
	}
	@Override
	public boolean addChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterMapper.addChapter(chapter)>0?true:false;
	}
	@Override
	public boolean updateChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterMapper.updateChapter(chapter)>0?true:false;
	}
	@Override
	public boolean delChapterById(int bid, int chaid) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			bookMarkMapper.delBookMarkById(bid, chaid);
			result=chapterMapper.delChapter(bid, chaid)>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
			result=false;
			e.printStackTrace();
		}
		return result;
	}

}
