package com.ly.novel.vo;

import java.util.Date;

public class NovelVo {

	private int bid;
	private int cid;
	private int vid;
	private int userid;
	private String username;
	private String categoryname;
	private String sex;
	private String city;
	private String bookname;
	private String bookintroduction;
	private Date posttime;
	private String postip;
	private String status;
	private int accessCount;
	private int replyCount;
	private int voteCount;
	public NovelVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NovelVo(int bid, int cid, int vid, int userid, String username,
			String categoryname, String sex, String city, String bookname,
			String bookintroduction, Date posttime, String postip,
			int accessCount, int replyCount, int voteCount) {
		super();
		this.bid = bid;
		this.cid = cid;
		this.vid = vid;
		this.userid = userid;
		this.username = username;
		this.categoryname = categoryname;
		this.sex = sex;
		this.city = city;
		this.bookname = bookname;
		this.bookintroduction = bookintroduction;
		this.posttime = posttime;
		this.postip = postip;
		this.accessCount = accessCount;
		this.replyCount = replyCount;
		this.voteCount = voteCount;
	}
	public NovelVo(int bid, int cid, int vid, int userid, String username,
			String categoryname, String sex, String city, String bookname,
			String bookintroduction, Date posttime, String postip) {
		super();
		this.bid = bid;
		this.cid = cid;
		this.vid = vid;
		this.userid = userid;
		this.username = username;
		this.categoryname = categoryname;
		this.sex = sex;
		this.city = city;
		this.bookname = bookname;
		this.bookintroduction = bookintroduction;
		this.posttime = posttime;
		this.postip = postip;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
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
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	@Override
	public String toString() {
		return "NovelVo [bid=" + bid + ", cid=" + cid + ", vid=" + vid
				+ ", userid=" + userid + ", username=" + username
				+ ", categoryname=" + categoryname + ", sex=" + sex + ", city="
				+ city + ", bookname=" + bookname + ", bookintroduction="
				+ bookintroduction + ", posttime=" + posttime + ", postip="
				+ postip + ", status=" + status + ", accessCount="
				+ accessCount + ", replyCount=" + replyCount + ", voteCount="
				+ voteCount + "]";
	}


	
}