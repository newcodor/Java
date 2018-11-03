package com.ly.novel.entity;

import java.util.Date;

public class Admin {
	private int adminid;
	private String username;
	private String password;
	private String role;
	private String lastip;
	private String email;
	private Date createtime;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminid, String username, String password, String role,
			String lastip, String email, Date createtime) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.lastip = lastip;
		this.email = email;
		this.createtime = createtime;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", lastip=" + lastip + ", email=" + email + ", createtime=" + createtime + "]";
	}
	
}
