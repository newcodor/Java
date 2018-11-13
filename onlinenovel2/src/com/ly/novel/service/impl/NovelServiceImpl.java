package com.ly.novel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.BookMarkMapper;
import com.ly.novel.dao.ChapterMapper;
import com.ly.novel.dao.CountMapper;
import com.ly.novel.dao.NovelMapper;
import com.ly.novel.dao.ReplyMapper;
import com.ly.novel.dao.UserMapper;
import com.ly.novel.dao.VoteMapper;
import com.ly.novel.entity.Chapter;
import com.ly.novel.entity.Novel;
import com.ly.novel.entity.Review;
import com.ly.novel.entity.category;
import com.ly.novel.service.NovelService;
//import com.ly.novel.util.JdbcUtil;
import com.ly.novel.util.Page;
import com.ly.novel.vo.BookSelfVo;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReviewVo;


@Service
@Transactional
public class NovelServiceImpl implements NovelService {
   
   @Autowired
   private NovelMapper novelMapper;
   @Autowired
   private CountMapper countMapper;
   @Autowired
   private VoteMapper voteMapper;
   @Autowired
   private BookMarkMapper bookMarkMapper;
   @Autowired
   private ChapterMapper chapterMapper;
   @Autowired
   private ReplyMapper replyMapper;
   @Autowired
   private UserMapper userMapper;
	@Override
	public boolean addNovel(Novel novel) {
		// TODO Auto-generated method stub\
		boolean result=false;
		//int bid=0;
		try{
			
//			JdbcUtil.beginTransaction();
			novelMapper.addNovel(novel);
			countMapper.addCount(novel.getBid());
			voteMapper.createVote(novel.getBid());
//			JdbcUtil.commitTransaction();
			result=true;
		}catch(Exception e){
			result=false;
			/*
			try {
				JdbcUtil.rollbackTransaction();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			*/
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<NovelVo> queryAllNovels() {
		// TODO Auto-generated method stub
		return novelMapper.queryAllNovels();
	}
	@Override
	public NovelVo queryNovelById(int bid) {
		// TODO Auto-generated method stub
		countMapper.updateAccessCount(bid);
		return novelMapper.queryNovelById(bid);
	}
   @Override
   public List<NovelVo> queryNovelsByPage(Page page,String keyword,int cid){
	   
	   return novelMapper.queryNovelsByPage(page,keyword,cid);
   }
@Override
public int getNovelsCount() {
	// TODO Auto-generated method stub
	return novelMapper.getNovelsCount();
}
@Override
public boolean addCategory(String categoryName, Date createTime) {
	// TODO Auto-generated method stub
	return novelMapper.addCategory(categoryName,createTime)>0?true:false;
}
@Override
public List<category> queryAllCategorys() {
	// TODO Auto-generated method stub
	return novelMapper.queryAllCategorys();
}
@Override
public boolean delCategory(int cid) {
	// TODO Auto-generated method stub
	return novelMapper.delCategory(cid)>0?true:false;
}
@Override
public int getChapterCount(int bid) {
	// TODO Auto-generated method stub
	return novelMapper.getChapterCount(bid);
}
@Override
public List<Chapter> queryChaptersByPage(int bid,Page page) {
	// TODO Auto-generated method stub
	return novelMapper.queryChaptersByPage(bid,page);
}
@Override
public List<BookSelfVo> queryAllBookSelfsByUserId(int userid) {
	// TODO Auto-generated method stub
	return novelMapper.queryAllBookSelfsByUserId(userid);
}
@Override
public int addBookSelf(int userid, int bid) {
	// TODO Auto-generated method stub
	int resultStatus=0;
	if(!queryBookSelfById(userid,bid)){
		if(novelMapper.addBookSelf(userid,bid)>0?true:false)
			resultStatus=1;  //添加成功
		else
			resultStatus=0;  //添加失败
	}
	else {
		resultStatus=2;  //书架已存在
	}
	return resultStatus;
}
public boolean queryBookSelfById(int userid,int bid) {
	// TODO Auto-generated method stub
	return novelMapper.queryBookSelfById(userid,bid)>0?true:false;
}
@Override
public boolean delBookSelf(int userid, int[] bids) {
	// TODO Auto-generated method stub
	return novelMapper.delBookSelf(userid,bids)>0?true:false;
}
@Override
public boolean addReviewNovel(Review reviewNovel) {
	// TODO Auto-generated method stub
	return novelMapper.addReviewNovel(reviewNovel)>0?true:false;
}
@Override
public List<Novel> queryAllNovelsByUserid(int userid) {
	// TODO Auto-generated method stub
	return novelMapper.queryAllNovelsByUserid(userid);
}


@Override
public boolean reviewNovel(int rid, int userid, String reviewStatus) {
	// TODO Auto-generated method stub
	boolean result=false;
	int bid=0;
	try{
		if("pass".equals(reviewStatus)){
//		JdbcUtil.beginTransaction();
		Review review=novelMapper.queryReviewById(rid,userid);
		Novel novel=new Novel();
		novel.setBookname(review.getBookname());
		novel.setBookintroduction(review.getBookintroduction());
		novel.setUserid(userid);
		novel.setCid(review.getCid());
		novel.setPosttime(new Date());
		novel.setPostip(review.getPostip());
		bid=novelMapper.addNovel(novel);
		countMapper.addCount(bid);
		voteMapper.createVote(bid);
		userMapper.updateRole(userid,"author");
		novelMapper.delReview(rid, userid);
//		JdbcUtil.commitTransaction();
		result=true;
		}else if("nopass".equals(reviewStatus)){
//			JdbcUtil.beginTransaction();
			novelMapper.updateReviewReviewStatus(rid, userid, reviewStatus);
			novelMapper.delReview(rid, userid);
//			JdbcUtil.commitTransaction();
			result=true;
		}
	}catch(Exception e){
		result=false;
		/*
		try {
			JdbcUtil.rollbackTransaction();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		*/
		e.printStackTrace();
	}
	return result;
}
@Override
public boolean finishNovelById(int bid) {
	// TODO Auto-generated method stub
	return novelMapper.finishNovelById(bid)>0?true:false;
}
@Override
public boolean delNovelById(int bid) {
	// TODO Auto-generated method stub
	boolean result=false;
	try {
		//JdbcUtil.beginTransaction();
		novelMapper.delNovelByBid(bid);
		replyMapper.delReplyByBid(bid);
		novelMapper.delBookSelfByBid(bid);
		bookMarkMapper.delBookMarkByBid(bid);
		chapterMapper.delChapterByBid(bid);
		countMapper.delCountByBid(bid);
		voteMapper.delVoteByBid(bid);
		voteMapper.delUserVoteByBid(bid);
		//JdbcUtil.commitTransaction();
		result=true;
	} catch (Exception e) {
		// TODO: handle exception
		result=false;
		/*
		try {
			JdbcUtil.rollbackTransaction();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		*/
		e.printStackTrace();
	}
	return result;
}
@Override
public List<ReviewVo> queryAllReviews() {
	// TODO Auto-generated method stub
	return novelMapper.queryAllReviews();
}
@Override
public ReviewVo queryAllReviewById(int rid) {
	// TODO Auto-generated method stub
	return novelMapper.queryAllReviewById(rid);
}
@Override
public boolean updateNovel(Novel novel) {
	// TODO Auto-generated method stub
	return novelMapper.updateNovel(novel)>0?true:false;
}
@Override
public List<NovelVo> queryNovelsByPage(Page page) {
	// TODO Auto-generated method stub
	return novelMapper.queryAllNovelsByPage(page);
}
@Override
public List<NovelVo> querySearchNovelsByPage(Page page, String keyword) {
	// TODO Auto-generated method stub
	return novelMapper.querySearchNovelsByPage(page,keyword);
}
@Override
public List<NovelVo> queryCategoryNovelsByCid(Page page, int cid) {
	// TODO Auto-generated method stub
	return novelMapper.queryCategoryNovelsByCid(page,cid);
}


}
