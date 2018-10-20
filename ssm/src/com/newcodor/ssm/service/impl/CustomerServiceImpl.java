package com.newcodor.ssm.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcodor.ssm.dao.CustomerMapper;
import com.newcodor.ssm.entity.Customer;
import com.newcodor.ssm.entity.CustomerExample;
import com.newcodor.ssm.entity.CustomerExample.Criteria;
import com.newcodor.ssm.entity.QueryVo;
import com.newcodor.ssm.service.CustomerService;
import com.newcodor.ssm.utils.Page;
import com.sun.org.apache.xpath.internal.operations.And;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public Customer queryCustomerById(Integer id) {
		// TODO Auto-generated method stub
		
		return customerMapper.selectByPrimaryKey(id.longValue());
	}

	@Override
	public Page<Customer> queryPageByQueryVo(QueryVo vo) {
		// TODO Auto-generated method stub
		Page<Customer> page=new Page<Customer>();
		page.setSize(5);
		vo.setSize(5);
//		CustomerExample example=new CustomerExample();
//		Criteria criteria = example.createCriteria();
		if(null!=vo) {
			
		if(null!=vo.getPage()) {
			page.setPage(vo.getPage());
			vo.setStartRow((vo.getPage() -1)*vo.getSize());
		}
		
		if(null!=vo.getCustName()) {
		    vo.setCustName(vo.getCustName().trim());
//		    if()
//		    criteria.andCustNameLike(vo.getCustName());
		    
		}
		if(null!=vo.getCustSource()) {
			vo.setCustSource(vo.getCustSource().trim());
//			criteria.andCustSourceEqualTo(vo.getCustSource());
		}
		if(null!=vo.getCustIndustry()) {
			vo.setCustIndustry(vo.getCustIndustry().trim());
//			criteria.andCustIndustryEqualTo(vo.getCustIndustry());
		}
		if(null!=vo.getCustLevel()) {
			vo.setCustLevel(vo.getCustLevel().trim());
//			criteria.andCustLevelEqualTo(vo.getCustLevel());
		}
		System.out.println("ok");
	
		}
	    int count=customerMapper.selectCountCustomerByVo(vo);
	    System.out.println(vo);
		page.setTotal(count);
		System.out.println(count);
		page.setRows(customerMapper.selectCustomerListByVo(vo));
		
		return page;
	}

	@Override
	public Integer updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		return  customerMapper.updateByPrimaryKey(customer);
	}

	@Override
	public int deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteByPrimaryKey(id.longValue());
	}


		
}
