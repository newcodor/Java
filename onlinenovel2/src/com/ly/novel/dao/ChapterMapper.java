package com.ly.novel.dao;

import org.apache.ibatis.annotations.Param;

import com.ly.novel.entity.Chapter;
import com.ly.novel.vo.ChapterVo;

public interface ChapterMapper {

	ChapterVo queryChapterVo(@Param("bid") int bid,@Param("chaid") int chaid);

	int queryfrontChapterId(@Param("bid") int bid,@Param("chaid") int chaid);

	int querynextChapterId(@Param("bid") int bid,@Param("chaid") int chaid);

	int addChapter(Chapter chapter);

	int delChapter(@Param("bid") int bid,@Param("chaid") int chaid);

	int updateChapter(Chapter chapter);

	void delChapterByBid(int bid);

}
