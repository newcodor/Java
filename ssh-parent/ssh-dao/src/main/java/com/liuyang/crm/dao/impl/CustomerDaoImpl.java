package com.liuyang.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.liuyang.crm.dao.CustomerDao;
import com.liuyang.crm.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return   getHibernateTemplate().get(Customer.class, id);
	}

}
