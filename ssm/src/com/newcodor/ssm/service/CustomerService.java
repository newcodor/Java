package com.newcodor.ssm.service;


import com.newcodor.ssm.entity.Customer;
import com.newcodor.ssm.entity.QueryVo;
import com.newcodor.ssm.utils.Page;

public interface CustomerService {
	public Customer queryCustomerById(Integer id);
//	public List<Customer>  queryAllCustomersTop(Integer start,Integer end);

	public Page<Customer> queryPageByQueryVo(QueryVo vo);

	public Integer updateCustomerById(Customer customer);

	public int deleteCustomerById(Integer id);
	
}
