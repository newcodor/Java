package com.newcodor.mybatisdemos.mapper;

import java.util.List;

import com.newcodor.mybatisdemos.entity.OrderUser;
import com.newcodor.mybatisdemos.entity.Orders;
import com.newcodor.mybatisdemos.entity.QueryVo;
import com.newcodor.mybatisdemos.entity.User;


public interface OrderMapper {
	public List<Orders> queryAllOrders();

	public List<Orders> queryOrdersByIds(QueryVo vo);

	public List<Orders> queryOrdersByArray(Integer[] ids);

	public List<Orders> queryOrdersByList(List<Integer> idsList);

	public List<OrderUser> queryOrderUser();

	public List<OrderUser> queryOrderAndUser();

	
}
