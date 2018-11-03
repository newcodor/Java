package com.ly.novel.service;

import java.util.List;

import com.ly.novel.entity.User;

public interface UserService {
  public User login(User u);   //用户登录判断
 
public boolean addUser(User u); //添加、注册用户

public List<User> queryAllUsers();  //查询所有用户

public boolean updateUserPass(int userid, String password); //修改密码

public boolean updateUser(User u);  //更新用户

public User queryUserById(int userid);    //查询用户信息

public boolean delUserById(int userid,String role);  //根据ID删除用户

}
