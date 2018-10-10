package com.liuyang.crm.dao;

import com.liuyang.crm.entity.Customer;

public interface CustomerDao {
	/**
	 * 根据ID查询用户信息
	 */
	
	public Customer findById(Long id);
}
