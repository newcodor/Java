package com.ly.novel.service;

import com.ly.novel.entity.Admin;

public interface AdminService {
	public Admin login(Admin a);

	public boolean addAdmin(Admin admin);

	public Admin queryAdmin();

	public boolean updateAdmin(Admin admin);

	public boolean updateAdminPass(Admin admin);   //修改管理密码

	public Admin queryAdminById(Integer id);
}
