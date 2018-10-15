package com.newcodor.mybatisdemos.entity;

public class OrderUser extends Orders {
	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderUser [username=" + username + ", address=" + address + ", getUser()=" + getUser() + ", getId()="
				+ getId() + ", getUserId()=" + getUserId() + ", getNumber()=" + getNumber() + ", getCreatetime()="
				+ getCreatetime() + ", getNote()=" + getNote() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}


	
}
