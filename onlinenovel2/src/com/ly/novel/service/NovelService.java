package com.ly.novel.service;

import java.util.Date;
import java.util.List;

import com.ly.novel.entity.Chapter;
import com.ly.novel.entity.Novel;
import com.ly.novel.entity.Review;
import com.ly.novel.entity.category;
import com.ly.novel.util.Page;
import com.ly.novel.vo.BookSelfVo;
import com.ly.novel.vo.ChapterVo;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReviewVo;

public interface NovelService {

	boolean addNovel(Novel novel);  //发布新小说

	List<NovelVo> queryAllNovels(); //查询所有小说
	
	NovelVo queryNovelById(int bid);

	int getNovelsCount();  //获取小说数量


	boolean addCategory(String categoryname, Date createTime); //添加分类

	List<category> queryAllCategorys();

	boolean delCategory(int cid);

	int getChapterCount(int bid);

	List<Chapter> queryChaptersByPage(int bid,Page page);

	List<BookSelfVo> queryAllBookSelfsByUserId(int userid);

	int addBookSelf(int userid, int bid);  //加入书架

	boolean delBookSelf(int userid, int[] bids);  //移除书架

	List<NovelVo> queryNovelsByPage(Page page, String keyword, int cid);

	boolean addReviewNovel(Review reviewNovel); //添加待审核小说
	List<ReviewVo> queryAllReviews();  //查询所有审核申请

	List<Novel> queryAllNovelsByUserid(int userid);

	boolean reviewNovel(int rid, int userid, String reviewStatus);  //审核新作者

	boolean finishNovelById(int bid); //小说完本

	boolean delNovelById(int bid);  //删除小说

	ReviewVo queryAllReviewById(int rid); //根据ID查询审核信息

	boolean updateNovel(Novel novel);  //修改小说信息

	List<NovelVo> queryNovelsByPage(Page page);

	List<NovelVo> querySearchNovelsByPage(Page page, String keyword);  //搜索小说

	List<NovelVo> queryCategoryNovelsByCid(Page page, int cid); //查询分类小说


	

}
