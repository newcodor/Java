package com.ly.novel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.novel.vo.BookMarkVo;

public interface BookMarkMapper {

	List<BookMarkVo> queryAllBookMarksByUserId(int userid);

	int delBookMarks(@Param("userid") int userid,@Param("bids") int[] bid,@Param("chaid") int chaid);

	int addBookMark(@Param("userid") int userid,@Param("bid") int bid,@Param("chaid") int chaid);

	int queryBookMarkById(@Param("userid") int userid,@Param("bid") int bid,@Param("chaid") int chaid);

	int delBookMarkById(@Param("bid") int bid,@Param("chaid") int chaid);

	int delBookMarkByUid(int userid);

	int delBookMarkByBid(int bid);


}
