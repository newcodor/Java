package com.ly.novel.entity;

import java.util.Date;

public class Novel {
	private int bid;
	private int userid;
	private int cid;
	private String bookname;
	private String bookintroduction;
	private String status;
	private Date posttime;
	private String postip;
	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Novel(int bid, int userid, int cid, String bookname,
			String bookintroduction, String status, Date posttime, String postip) {
		super();
		this.bid = bid;
		this.userid = userid;
		this.cid = cid;
		this.bookname = bookname;
		this.bookintroduction = bookintroduction;
		this.status = status;
		this.posttime = posttime;
		this.postip = postip;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookintroduction() {
		return bookintroduction;
	}
	public void setBookintroduction(String bookintroduction) {
		this.bookintroduction = bookintroduction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public String getPostip() {
		return postip;
	}
	public void setPostip(String postip) {
		this.postip = postip;
	}
	@Override
	public String toString() {
		return "Novel [bid=" + bid + ", userid=" + userid + ", cid=" + cid
				+ ", bookname=" + bookname + ", bookintroduction="
				+ bookintroduction + ", status=" + status + ", posttime="
				+ posttime + ", postip=" + postip + "]";
	}
	

	
}
	