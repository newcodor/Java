package com.ly.novel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ly.novel.entity.User;

public interface UserMapper {

	User findUserByInfo(User u);

	int addUser(User u);

	List<User> queryAllUsers();

	int updateUserPass(@Param("userid") int userid,@Param("password") String password);

	int updateUser(User u);

	User queryUserById(int userid);

	int delUserById(int userid);

	int updateRole(@Param("userid") int userid,@Param("role") String role);

}
