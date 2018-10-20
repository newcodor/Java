package com.newcodor.ssm.web;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newcodor.ssm.entity.BaseDict;
import com.newcodor.ssm.entity.Customer;
import com.newcodor.ssm.entity.QueryVo;
import com.newcodor.ssm.service.BaseDictService;
import com.newcodor.ssm.service.CustomerService;
import com.newcodor.ssm.utils.Page;

@Controller
public class CustomerController {
	

	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
		
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;

	

	
	@RequestMapping(value= {"/customer/customer/{id}","/customer/cutomer"})
	public String queryCustomer(@PathVariable Integer id,Model model) {
		
		Customer customer = customerService.queryCustomerById(id);
		model.addAttribute("customer",customer);
		return "forward:/jsp/list.jsp";
	}
	
	@RequestMapping("/customer/list")
	public String list(QueryVo vo,Model model) {
		
		
		List<BaseDict>  fromType=baseDictService.quertyBaseDictType(fromTypeCode);
		List<BaseDict>  industryType=baseDictService.quertyBaseDictType(industryTypeCode);
		List<BaseDict>  levelType=baseDictService.quertyBaseDictType(levelTypeCode);
		
		Page<Customer> page =customerService.queryPageByQueryVo(vo);
		
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("page",page);
		
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "forward:/jsp/customer.jsp";
	}
	
	@RequestMapping(value="/customer/edit.action")
	  public @ResponseBody Customer  toEdit(Integer id){
		
		Customer customer = customerService.queryCustomerById(id);
		
		return customer;
		
	}
	@RequestMapping(value="/customer/update.action")
	  public @ResponseBody String  update(Customer customer){
		
		int count=  customerService.updateCustomerById(customer).intValue();
		String result=count>0?"ok":"fail";
		
		return result;
		
	}
	@RequestMapping(value="/customer/delete.action")
	  public @ResponseBody String  delete(Integer id){
		
		int count=  customerService.deleteCustomerById(id);
		String result=count>0?"ok":"fail";
		
		return result;
		
	}
}
