package com.ly.novel.entity;

import java.util.Date;

public class Review {
   private int rid;
   private int userid;
   private int cid;
   private int bid;
   private String bookname;
   private String bookintroduction;
   private String bookSampleDraft;
   private String reviewStatus="nopass";
   private Date applyTime;
   private String postip;
public Review() {
	super();
	// TODO Auto-generated constructor stub
}

public Review(int userid, int cid, int bid, String bookname,
		String bookintroduction, String bookSampleDraft, String reviewStatus,
		Date applyTime, String postip) {
	super();
	this.userid = userid;
	this.cid = cid;
	this.bid = bid;
	this.bookname = bookname;
	this.bookintroduction = bookintroduction;
	this.bookSampleDraft = bookSampleDraft;
	this.reviewStatus = reviewStatus;
	this.applyTime = applyTime;
	this.postip = postip;
}

public Review(int rid, int userid, int cid, int bid, String bookname,
		String bookintroduction, String bookSampleDraft, String reviewStatus,
		Date applyTime, String postip) {
	super();
	this.rid = rid;
	this.userid = userid;
	this.cid = cid;
	this.bid = bid;
	this.bookname = bookname;
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
	return "Review [rid=" + rid + ", userid=" + userid + ", cid=" + cid
			+ ", bid=" + bid + ", bookname=" + bookname + ", bookintroduction="
			+ bookintroduction + ", bookSampleDraft=" + bookSampleDraft
			+ ", reviewStatus=" + reviewStatus + ", applyTime=" + applyTime
			+ ", postip=" + postip + "]";
}


   
}
