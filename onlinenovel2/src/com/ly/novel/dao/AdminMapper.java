package com.ly.novel.dao;

import com.ly.novel.entity.Admin;

public interface AdminMapper {
	public Admin findAdminByInfo(Admin a);

	public  Integer  addAdmin(Admin a);

	public  Admin queryAdmin();

	public  Integer updateAdmin(Admin admin);

	public  Integer updateAdminPass(Admin admin); //修改管理密码

	public Admin queryAdminById(Integer adminid);
}
