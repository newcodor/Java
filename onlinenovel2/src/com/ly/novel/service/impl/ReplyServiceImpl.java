package com.ly.novel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.CountMapper;
import com.ly.novel.dao.ReplyMapper;
import com.ly.novel.entity.Reply;
import com.ly.novel.service.ReplyService;
import com.ly.novel.vo.ReplyVo;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private CountMapper countMapper;
	@Override
	public List<ReplyVo> findReplyByBid(int bid) {
		// TODO Auto-generated method stub
		return replyMapper.findReplyByBid(bid);
	}
	@Override
	public boolean addReply(Reply reply) {
		// TODO Auto-generated method stub
//		countMapper.updateReplyCount(reply.getBid());  //改用触发器实现
		return replyMapper.addReply(reply)>0?true:false;
	}

}
