package com.ly.novel.dao;

import java.util.List;

import com.ly.novel.entity.Reply;
import com.ly.novel.vo.ReplyVo;

public interface ReplyMapper {

	int delReplyByUid(int userid);

	int addReply(Reply reply);

	List<ReplyVo> findReplyByBid(int bid);

	int delReplyByBid(int bid);

}
