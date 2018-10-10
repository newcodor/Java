package com.liuyang.crm.service.impl;

import com.liuyang.crm.dao.CustomerDao;
import com.liuyang.crm.entity.Customer;
import com.liuyang.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private  CustomerDao  customerDao;
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		
		return customerDao.findById(id);
	}

}
