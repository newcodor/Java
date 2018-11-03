package com.ly.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.VoteMapper;
import com.ly.novel.service.VoteService;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {
 
 @Autowired
 private VoteMapper voteMapper;
	@Override
	public int addVote(int userid, int bid) {
		// TODO Auto-generated method stub
		int voteStatus=0;
		if(!queryUserVoteById(userid,bid)){
			if(voteMapper.addVote(bid)>0?true:false&voteMapper.addUserVote(userid,bid)>0?true:false){
				voteStatus=1;  //投票成功
			}
			else
				voteStatus=0;  //投票失败
		}
		else {
			voteStatus=2;  //此书此用户已投票
		}
		return voteStatus;
	}
	private boolean queryUserVoteById(int userid, int bid) {
		// TODO Auto-generated method stub
		return voteMapper.queryUserVoteById(userid,bid)>0?true:false;
	}

}
