package com.ly.novel.vo;

import java.util.Date;

public class BookSelfVo {
   private int bsid;
   private int userid;
   private int bid;
   private String username;
   private String bookname;
   private int chaid;
   private String title;
   private Date  posttime;
public BookSelfVo() {
	super();
	// TODO Auto-generated constructor stub
}
public BookSelfVo(int bsid, int userid, int bid, String username,
		String bookname, int chaid, String title, Date posttime) {
	super();
	this.bsid = bsid;
	this.userid = userid;
	this.bid = bid;
	this.username = username;
	this.bookname = bookname;
	this.chaid = chaid;
	this.title = title;
	this.posttime = posttime;
}
public int getBsid() {
	return bsid;
}
public void setBsid(int bsid) {
	this.bsid = bsid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public int getChaid() {
	return chaid;
}
public void setChaid(int chaid) {
	this.chaid = chaid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getPosttime() {
	return posttime;
}
public void setPosttime(Date posttime) {
	this.posttime = posttime;
}

@Override
public String toString() {
	return "BookSelfVo [bsid=" + bsid + ", userid=" + userid + ", bid=" + bid
			+ ", username=" + username + ", bookname=" + bookname + ", chaid="
			+ chaid + ", title=" + title + ", posttime=" + posttime + "]";
}
   
   
}
