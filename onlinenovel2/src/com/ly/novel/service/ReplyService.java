package com.ly.novel.service;

import java.util.List;

import com.ly.novel.entity.Reply;
import com.ly.novel.vo.ReplyVo;

public interface ReplyService {
     public List<ReplyVo> findReplyByBid(int bid);

	public boolean addReply(Reply reply);
}
