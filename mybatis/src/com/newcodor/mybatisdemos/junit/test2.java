package com.newcodor.mybatisdemos.junit;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import com.newcodor.mybatisdemos.entity.OrderUser;
import com.newcodor.mybatisdemos.entity.Orders;
import com.newcodor.mybatisdemos.entity.QueryVo;
import com.newcodor.mybatisdemos.entity.User;
import com.newcodor.mybatisdemos.mapper.OrderMapper;
import com.newcodor.mybatisdemos.mapper.UserMapper;

public class test2 {

	private SqlSessionFactory  sqlSessionFactory;
	
	@Before
	public void init()throws IOException {
		String resource="sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
	}
	

	//查询所有订单
	@Test
	public void queryAllOrders() throws IOException {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Orders> orders=orderMapper.queryAllOrders();
		for (Orders o : orders) {
			System.out.println(o);
			
		}
		sqlSession.close();
		
	}
	//if、where片段查询
	@Test
	public void queryUserByWhere() throws IOException {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=new User();
//		user.setSex("2");
		user.setUsername("五");
		List<User> users=userMapper.queryUserByWhere(user);
		for (User u : users) {
			System.out.println(u);
			
		}
		sqlSession.close();
		
	}
	//pojo查询
	@Test
	public void queryOrdersByIds(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Integer>  idsList=new ArrayList<Integer>();
		idsList.add(3);
		idsList.add(4);
		idsList.add(5);
		QueryVo vo=new QueryVo();
		vo.setIdsList(idsList);
		List<Orders> orders=orderMapper.queryOrdersByIds(vo);
		for (Orders o : orders) {
			System.out.println(o);
			
		}
		sqlSession.close();
	}
	//数组查询
	@Test
	public void queryOrdersByArray(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		Integer [] ids=new Integer[]{3,4,5};

		List<Orders> orders=orderMapper.queryOrdersByArray(ids);
		for (Orders o : orders) {
			System.out.println(o);		
		}
		sqlSession.close();
	}
	//list查询
	@Test
	public void queryOrdersByList(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<Integer>  idsList=new ArrayList<Integer>();
		idsList.add(3);
		idsList.add(4);
		idsList.add(5);

		List<Orders> orders=orderMapper.queryOrdersByList(idsList);
		for (Orders o : orders) {
			System.out.println(o);
			
		}
		sqlSession.close();
	}
	
	//一对一查询
	@Test
	public void queryOrderUser(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<OrderUser> orders=orderMapper.queryOrderUser();
		for (OrderUser o : orders) {
			System.out.print(o);
			
		}
		sqlSession.close();
	}
	
	@Test
	public void queryOrderAndUser(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
		List<OrderUser> orders=orderMapper.queryOrderAndUser();
		for (Orders o : orders) {
			System.out.print(o+" --");
			System.out.println(o.getUser());
			
		}
		sqlSession.close();
	}
	//一对多查询
	@Test
	public void queryUserAndOrder(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> users=userMapper.queryUserAndOrder();
		for (User u : users) {
			System.out.print(u+" --");
			if(u.getOrders().size()>1) {
				System.out.println();
				for(Orders o:u.getOrders()) {
					System.out.println("-----"+u.getOrders());
				}
			}
			else
			  System.out.println(u.getOrders());
			
		}
		sqlSession.close();
	}
}
