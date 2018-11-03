package com.ly.novel.entity;

import java.util.Date;

public class Editor {
	private int eid;
	private String username;
	private String password;
	private Date createtime;
	private String role;
	private String email;
	private String qq;
	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editor(String username, String password, Date createtime,
			String role, String email, String qq) {
		super();
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.role = role;
		this.email = email;
		this.qq = qq;
	}
	public Editor(int eid, String username, String password, Date createtime,
			String role, String email, String qq) {
		super();
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.role = role;
		this.email = email;
		this.qq = qq;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Override
	public String toString() {
		return "Editor [eid=" + eid + ", username=" + username + ", password="
				+ password + ", createtime=" + createtime + ", role=" + role
				+ ", email=" + email + ", qq=" + qq + "]";
	}
	
}
