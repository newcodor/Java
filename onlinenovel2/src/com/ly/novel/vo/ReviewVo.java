package com.ly.novel.vo;

import java.util.Date;

public class ReviewVo {
   private int rid;
   private int userid;
   private int cid;
   private int bid;
   private String username;
   private String bookname;
   private String categoryname;
   private String bookintroduction;
   private String bookSampleDraft;
   private String reviewStatus;
   private Date applyTime;
   private String postip;
public ReviewVo() {
	super();
	// TODO Auto-generated constructor stub
}


public ReviewVo(int userid, int cid, int bid, String username, String bookname,
		String categoryname, String bookintroduction, String bookSampleDraft,
		String reviewStatus, Date applyTime, String postip) {
	super();
	this.userid = userid;
	this.cid = cid;
	this.bid = bid;
	this.username = username;
	this.bookname = bookname;
	this.categoryname = categoryname;
	this.bookintroduction = bookintroduction;
	this.bookSampleDraft = bookSampleDraft;
	this.reviewStatus = reviewStatus;
	this.applyTime = applyTime;
	this.postip = postip;
}






public ReviewVo(int rid, int userid, int cid, int bid, String username,
		String bookname, String categoryname, String bookintroduction,
		String bookSampleDraft, String reviewStatus, Date applyTime,
		String postip) {
	super();
	this.rid = rid;
	this.userid = userid;
	this.cid = cid;
	this.bid = bid;
	this.username = username;
	this.bookname = bookname;
	this.categoryname = categoryname;
	this.bookintroduction = bookintroduction;
	this.bookSampleDraft = bookSampleDraft;
	this.reviewStatus = reviewStatus;
	this.applyTime = applyTime;
	this.postip = postip;
}

public int getRid() {
	return rid;
}

public void setRid(int rid) {
	this.rid = rid;
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

public String getCategoryname() {
	return categoryname;
}


public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}


public String getBookintroduction() {
	return bookintroduction;
}

public void setBookintroduction(String bookintroduction) {
	this.bookintroduction = bookintroduction;
}

public String getBookSampleDraft() {
	return bookSampleDraft;
}

public void setBookSampleDraft(String bookSampleDraft) {
	this.bookSampleDraft = bookSampleDraft;
}

public String getReviewStatus() {
	return reviewStatus;
}

public void setReviewStatus(String reviewStatus) {
	this.reviewStatus = reviewStatus;
}

public Date getApplyTime() {
	return applyTime;
}

public void setApplyTime(Date applyTime) {
	this.applyTime = applyTime;
}

public String getPostip() {
	return postip;
}

public void setPostip(String postip) {
	this.postip = postip;
}


@Override
public String toString() {
	return "ReviewVo [rid=" + rid + ", userid=" + userid + ", cid=" + cid
			+ ", bid=" + bid + ", username=" + username + ", bookname="
			+ bookname + ", categoryname=" + categoryname
			+ ", bookintroduction=" + bookintroduction + ", bookSampleDraft="
			+ bookSampleDraft + ", reviewStatus=" + reviewStatus
			+ ", applyTime=" + applyTime + ", postip=" + postip + "]";
}




   
}
