package com.ly.novel.vo;

import java.util.Date;

public class ReplyVo {
	private  int replyid;
	private	 int msgid;
	private  int userid;
	private  String replycontents;
	private  Date replytime;
	private  String replyip;
	private String username;
	private String city;
	private String sex;
	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public ReplyVo(int replyid, int msgid, int userid, String replycontents,
			Date replytime, String replyip, String username, String city,
			String sex) {
		super();
		this.replyid = replyid;
		this.msgid = msgid;
		this.userid = userid;
		this.replycontents = replycontents;
		this.replytime = replytime;
		this.replyip = replyip;
		this.username = username;
		this.city = city;
		this.sex = sex;
	}
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "ReplyVo [replyid=" + replyid + ", msgid=" + msgid + ", userid="
				+ userid + ", replycontents=" + replycontents + ", replytime="
				+ replytime + ", replyip=" + replyip + ", username=" + username
				+ ", city=" + city + ", sex=" + sex + "]";
	}

	
	
}
