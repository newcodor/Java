package com.ly.novel.vo;

import java.util.Date;

public class BookMarkVo {
	   private int bmid;
	   private int userid;
	   private int bid;
	   private String username;
	   private String bookname;
	   private String chaid;   
	   private String title;     //书签章节
	   private Date  addTime;
	public BookMarkVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookMarkVo(int userid, int bid, String username, String bookname,
			String chaid, String title, Date addTime) {
		super();
		this.userid = userid;
		this.bid = bid;
		this.username = username;
		this.bookname = bookname;
		this.chaid = chaid;
		this.title = title;
		this.addTime = addTime;
	}
	public BookMarkVo(int bmid, int userid, int bid, String username,
			String bookname, String chaid, String title, Date addTime) {
		super();
		this.bmid = bmid;
		this.userid = userid;
		this.bid = bid;
		this.username = username;
		this.bookname = bookname;
		this.chaid = chaid;
		this.title = title;
		this.addTime = addTime;
	}
	public int getBmid() {
		return bmid;
	}
	public void setBmid(int bmid) {
		this.bmid = bmid;
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
	public String getChaid() {
		return chaid;
	}
	public void setChaid(String chaid) {
		this.chaid = chaid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	   
	   
}

