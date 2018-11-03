package com.ly.novel.entity;

public class Count {
	private  int msgid;
	private  int accessCount;
	private  int replyCount;
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count(int msgid, int accessCount, int replyCount) {
		super();
		this.msgid = msgid;
		this.accessCount = accessCount;
		this.replyCount = replyCount;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
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
	@Override
	public String toString() {
		return "Count [msgid=" + msgid + ", accessCount=" + accessCount
				+ ", replyCount=" + replyCount + "]";
	}
	
	
}
