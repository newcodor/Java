package com.ly.novel.service;

import com.ly.novel.entity.Chapter;
import com.ly.novel.vo.ChapterVo;

public interface ChapterService {

	ChapterVo queryChapterVo(int bid, int chaid);

	int queryfrontChapterId(int bid, int chaid);  //查询上一篇

	int querynextChapterId(int bid, int chaid);   //查询下一篇

	boolean addChapter(Chapter chapter);   //发表新章节

	boolean updateChapter(Chapter chapter);  //修改章节

	boolean delChapterById(int bid, int chaid);  //删除章节

}
