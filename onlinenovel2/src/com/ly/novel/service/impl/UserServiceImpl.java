package com.ly.novel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.BookMarkMapper;
import com.ly.novel.dao.NovelMapper;
import com.ly.novel.dao.ReplyMapper;
import com.ly.novel.dao.UserMapper;
import com.ly.novel.dao.VoteMapper;
import com.ly.novel.entity.User;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
    @Autowired
    private NovelMapper novelMapper;
    @Autowired
    private BookMarkMapper bookMarkMapper;
    @Autowired
	private ReplyMapper replyMapper;
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private  NovelService novelService;
	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		return userMapper.findUserByInfo(u);
	}
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return userMapper.addUser(u)>0?true:false;
	}
	@Override
	public List<User> queryAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.queryAllUsers();
	}
	@Override
	public boolean updateUserPass(int userid, String password) {
		// TODO Auto-generated method stub
		return userMapper.updateUserPass(userid,password)>0?true:false;
	}
	@Override
	public boolean updateUser(User u) {     //用户信息更新
		// TODO Auto-generated method stub
		return userMapper.updateUser(u)>0?true:false;
	}
	@Override
	public User queryUserById(int userid) {   //查询用户信息
		// TODO Auto-generated method stub
		return userMapper.queryUserById(userid);
	}
	@Override
	public boolean delUserById(int userid,String role) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			//JdbcUtil.beginTransaction();
			userMapper.delUserById(userid);
			novelMapper.delBookSelfByUid(userid);
			bookMarkMapper.delBookMarkByUid(userid);
			replyMapper.delReplyByUid(userid);
			voteMapper.delUserVoteByUid(userid);
			novelMapper.delReviewNovelByUid(userid);
			if("author".equals(role)){
				List<Integer> bids=novelMapper.queryNovelBidByUid(userid);
				for (Integer bid : bids) {
					novelService.delNovelById(bid.intValue());
				}
			}
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
			result=false;
			try {
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}

}
