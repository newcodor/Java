package com.ly.novel.entity;

import java.util.Date;

public class Chapter {
	private int chaid;
	private int bid;
	private String title;
	private String contents;
	private Date posttime;
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chapter(int bid, String title, String contents,
			Date posttime) {
		super();
		this.bid = bid;
		this.title = title;
		this.contents = contents;
		this.posttime = posttime;
	}
	public Chapter(int chaid, int bid, String title, String contents,
			Date posttime) {
		super();
		this.chaid = chaid;
		this.bid = bid;
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
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
		return "Chapter [chaid=" + chaid + ", bid=" + bid + ", title=" + title
				+ ", contents=" + contents + ", posttime=" + posttime + "]";
	}
	
}
