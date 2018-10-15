package com.newcodor.mybatisdemos.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.newcodor.mybatisdemos.entity.QueryVo;
import com.newcodor.mybatisdemos.entity.User;
import com.newcodor.mybatisdemos.mapper.UserMapper;

public class test1 {
  
	
	private  SqlSessionFactory sqlSessionFactory;
	@Test
	public void queryOne() {
		String resource="sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSession sqlSession=sqlSessionFactory.openSession();
//		User user =(User) sqlSession.selectOne("findUserById", 1);
		UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
//		User user  = userMapper.findUserById(1);
		QueryVo queryVo=new QueryVo();
//		queryVo.setId(1);
//		User user  = userMapper.findUserByQueryVo(queryVo);
		User u=new User();
		u.setId(1);
		queryVo.setUser(u);
		User user=userMapper.findUserByQueryVo(queryVo);
		sqlSession.close();
				
		System.out.println(user);
		
	}
	
	@Test
	public void queryList() {
		String resource="sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSession sqlSession=sqlSessionFactory.openSession();
//		List<User>  users =sqlSession.selectList("findUserByUsername", "五");
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//		List<User>   users=userMapper.findUserByUsername("五");
		QueryVo vo=new QueryVo();
		User u1=new User();
		u1.setUsername("五");
		vo.setUser(u1);
		List<User>   users=userMapper.findUserByUsernameAndQueryVo(vo);
		sqlSession.close();
		
		 
		for(User u:users) {
			System.out.println(u);
		}
	}
	@Test
	public void insert() {
		String resource="sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user = new User("王利刚","男",new Date(),"福州巷");
		int  i =sqlSession.insert("insertUser",user );
		sqlSession.commit();
		sqlSession.close();
		System.out.println("Insert ID:"+user.getId());
	}

	@Test
	public void updateUser() {
	String resource="sqlMapConfig.xml";
	InputStream in;
	try {
		in = Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SqlSession sqlSession=sqlSessionFactory.openSession();
	
	User user = new User("王李刚","男",new Date(),"福州巷");
	user.setId(28);
	int  i =sqlSession.update("updateUserById",user );
	sqlSession.commit();
	sqlSession.close();
	System.out.println("count:"+i);
	}
	
	@Test
	public void deleteUser() {
	String resource="sqlMapConfig.xml";
	InputStream in;
	try {
		in = Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SqlSession sqlSession=sqlSessionFactory.openSession();
	
//	User user = new User("王李刚","男",new Date(),"福州巷");
//	user.setId(28);
	int  i =sqlSession.delete("deleteUserById",28 );
	sqlSession.commit();
	sqlSession.close();
	System.out.println("count:"+i);
	}
	
	
	
	
}
