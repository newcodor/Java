package com.ly.novel.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.novel.entity.Chapter;
import com.ly.novel.entity.Novel;
import com.ly.novel.entity.Review;
import com.ly.novel.entity.category;
import com.ly.novel.util.Page;
import com.ly.novel.vo.BookSelfVo;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReviewVo;

public interface NovelMapper {

	int delBookSelfByUid(int userid);

	int delReviewNovelByUid(int userid);

	List<Integer> queryNovelBidByUid(int userid);

	int addNovel(Novel novel);

	List<NovelVo> queryNovelsByPage(@Param("page") Page page,@Param("keyword") String keyword,@Param("cid") int cid);

	int getNovelsCount();

	int addCategory(@Param("categoryName") String categoryName,@Param("createTime") Date createTime);

	List<NovelVo> queryAllNovels();

	NovelVo queryNovelById(int bid);

	List<category> queryAllCategorys();

	int delCategory(int cid);

	int getChapterCount(int bid);

	List<Chapter> queryChaptersByPage(@Param("bid") int bid,@Param("page") Page page);

	List<BookSelfVo> queryAllBookSelfsByUserId(int userid);

	int queryBookSelfById(@Param("userid") int userid,@Param("bid") int bid);

	int delBookSelf(@Param("userid") int userid,@Param("bids") int[] bids);

	int addReviewNovel(Review reviewNovel);

	List<Novel> queryAllNovelsByUserid(int userid);

	int updateReviewReviewStatus(@Param("rid") int rid, @Param("userid") int userid,@Param("reviewStatus") String reviewStatus);

	int delReview(@Param("rid") int rid,@Param("userid") int userid);

	int addBookSelf(@Param("userid") int userid,@Param("bid") int bid);

	List<NovelVo> queryCategoryNovelsByCid(@Param("page") Page page,@Param("chaid") int cid);

	List<NovelVo> querySearchNovelsByPage(@Param("page") Page page,@Param("keyword") String keyword);

	List<NovelVo> queryAllNovelsByPage(Page page);

	int updateNovel(Novel novel);

	List<ReviewVo> queryAllReviews();

	ReviewVo queryAllReviewById(int rid);

	int delNovelByBid(int bid);

	int delBookSelfByBid(int bid);

	Review queryReviewById(@Param("rid") int rid,@Param("userid") int userid);

	int finishNovelById(int bid);

}
