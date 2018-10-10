package com.liuyang.crm.action;


import com.liuyang.crm.entity.Customer;
import com.liuyang.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction  extends  ActionSupport {
	 private Long id;
	 private  CustomerService customerService; 
	public String findCustomerById() {
		
		Customer customer=customerService.findById(id);
		ActionContext.getContext().put("customer", customer);
		return SUCCESS;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
