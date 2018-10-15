package com.newcodor.mybatisdemos.mapper;

import java.util.List;

import com.newcodor.mybatisdemos.entity.QueryVo;
import com.newcodor.mybatisdemos.entity.User;

public interface UserMapper {

	
	public User findUserById(int id);
	public User findUserByQueryVo(QueryVo vo);
	public List<User> findUserByUsername(String username);
	
	public List<User> findUserByUsernameAndQueryVo(QueryVo vo);
	
	public List<User> queryUserByWhere(User user);
	public List<User> queryUserAndOrder();
}
