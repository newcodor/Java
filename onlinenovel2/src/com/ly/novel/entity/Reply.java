package com.ly.novel.entity;

import java.util.Date;

public class Reply {
	private int replyid;
	private int bid;
	private int userid;
	private String replycontents;
	private Date replytime;
	private String replyip;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int bid, int userid, String replycontents, Date replytime,
			String replyip) {
		super();
		this.bid = bid;
		this.userid = userid;
		this.replycontents = replycontents;
		this.replytime = replytime;
		this.replyip = replyip;
	}

	public Reply(int replyid, int bid, int userid, String replycontents,
			Date replytime, String replyip) {
		super();
		this.replyid = replyid;
		this.bid = bid;
		this.userid = userid;
		this.replycontents = replycontents;
		this.replytime = replytime;
		this.replyip = replyip;
	}

	public int getReplyid() {
		return replyid;
	}

	public void setReplyid(int replyid) {
		this.replyid = replyid;
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

	public String getReplycontents() {
		return replycontents;
	}

	public void setReplycontents(String replycontents) {
		this.replycontents = replycontents;
	}

	public Date getReplytime() {
		return replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public String getReplyip() {
		return replyip;
	}

	public void setReplyip(String replyip) {
		this.replyip = replyip;
	}

	@Override
	public String toString() {
		return "Reply [replyid=" + replyid + ", bid=" + bid + ", userid="
				+ userid + ", replycontents=" + replycontents + ", replytime="
				+ replytime + ", replyip=" + replyip + "]";
	}

}
