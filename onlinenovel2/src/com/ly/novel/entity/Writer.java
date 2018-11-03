package com.ly.novel.entity;

import java.util.Date;

public class Writer {
	private int aid;
	private String username;
	private String password;
	private String role;
	private String sex;
	private String qq;
	private String email;
	private Date createtime;
	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Writer(String username, String password, String role, String sex,
			String qq, String email, Date createtime) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.qq = qq;
		this.email = email;
		this.createtime = createtime;
	}
	public Writer(int aid, String username, String password, String role,
			String sex, String qq, String email, Date createtime) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.qq = qq;
		this.email = email;
		this.createtime = createtime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
		return "Writer [aid=" + aid + ", username=" + username + ", password="
				+ password + ", role=" + role + ", sex=" + sex + ", qq=" + qq
				+ ", email=" + email + ", createtime=" + createtime + "]";
	}
	
}
