package com.ly.novel.vo;

import java.util.Date;

public class ChapterVo {
	private int chaid;
	private int aid;
	private int bid;
	private int cid;  //分类id
	private String categoryname; //作品分类
	private String username;
	private String bookname;
	private String title;
	private String contents;
	private Date posttime;
	public ChapterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChapterVo(int chaid, int aid, int bid, int cid, String categoryname,
			String username, String bookname, String title, String contents,
			Date posttime) {
		super();
		this.chaid = chaid;
		this.aid = aid;
		this.bid = bid;
		this.cid = cid;
		this.categoryname = categoryname;
		this.username = username;
		this.bookname = bookname;
		this.title = title;
		this.contents = contents;
		this.posttime = posttime;
	}
	public int getChaid() {
		return chaid;
	}
	public void setChaid(int chaid) {
		this.chaid = chaid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	@Override
	public String toString() {
		return "ChapterVo [chaid=" + chaid + ", aid=" + aid + ", bid=" + bid
				+ ", cid=" + cid + ", categoryname=" + categoryname
				+ ", username=" + username + ", bookname=" + bookname
				+ ", title=" + title + ", contents=" + contents + ", posttime="
				+ posttime + "]";
	}
	
	
}
