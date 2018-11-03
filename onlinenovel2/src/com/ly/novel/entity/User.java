package com.ly.novel.entity;

import java.util.Date;

public class User {
	private int userid;
	private String username;
	private String password;
	private String role;
	private String sex;
	private String  hobbys;
	private Date birthday;
	private String city;
	private String qq;
	private String email;
	private Date createtime;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String role, String sex,
			String hobbys, Date birthday, String city, String qq, String email,
			Date createtime) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.hobbys = hobbys;
		this.birthday = birthday;
		this.city = city;
		this.qq = qq;
		this.email = email;
		this.createtime = createtime;
	}

	public User(int userid, String username, String password, String role,
			String sex, String hobbys, Date birthday, String city, String qq,
			String email, Date createtime) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.hobbys = hobbys;
		this.birthday = birthday;
		this.city = city;
		this.qq = qq;
		this.email = email;
		this.createtime = createtime;
	}
	public User(int userid ,String sex, String hobbys,
			Date birthday, String city, String qq, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.userid=userid;
		this.sex = sex;
		this.hobbys = hobbys;
		this.birthday = birthday;
		this.city = city;
		this.qq = qq;
		this.email = email;
		
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getHobbys() {
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", sex=" + sex
				+ ", hobbys=" + hobbys + ", birthday=" + birthday + ", city="
				+ city + ", qq=" + qq + ", email=" + email + ", createtime="
				+ createtime + "]";
	}
	



	
}
