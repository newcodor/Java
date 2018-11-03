package com.ly.novel.entity;

import java.util.Date;

public class category {
   private int cid;
   private String categoryname;
   private Date createtime;
public category() {
	super();
	// TODO Auto-generated constructor stub
}
public category(String categoryname, Date createtime) {
	super();
	this.categoryname = categoryname;
	this.createtime = createtime;
}
public category(int cid, String categoryname, Date createtime) {
	super();
	this.cid = cid;
	this.categoryname = categoryname;
	this.createtime = createtime;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public Date getCreatetime() {
	return createtime;
}
public void setCreatetime(Date createtime) {
	this.createtime = createtime;
}
@Override
public String toString() {
	return "category [cid=" + cid + ", categoryname=" + categoryname
			+ ", createtime=" + createtime + "]";
}
   
}
