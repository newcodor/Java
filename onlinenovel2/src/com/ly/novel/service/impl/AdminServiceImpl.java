package com.ly.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.novel.dao.AdminMapper;
import com.ly.novel.entity.Admin;
import com.ly.novel.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
	private AdminMapper adminMapper;
	
 
	@Override
	public Admin login(Admin a) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminByInfo(a);
	}
	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
			return adminMapper.addAdmin(admin)>0?true:false;
		
	}
	@Override
	public Admin queryAdmin() {
		// TODO Auto-generated method stub
		return adminMapper.queryAdmin();
	}
	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
			return adminMapper.updateAdmin(admin)>0?true:false;
	}
	@Override
	public boolean updateAdminPass(Admin admin) {
		// TODO Auto-generated method stub
		return	adminMapper.updateAdminPass(admin)>0?true:false;
	}
	@Override
	public Admin queryAdminById(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.queryAdminById(id);
	}

}
