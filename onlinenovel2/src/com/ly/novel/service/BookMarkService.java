package com.ly.novel.service;

import java.util.List;

import com.ly.novel.vo.BookMarkVo;

public interface BookMarkService {

	List<BookMarkVo> queryAllBookMarksByUserId(int userid);

	boolean delBookMark(int userid, int[] bids, int chaid);

	int addBookMark(int userid, int bid, int chaid);

}
