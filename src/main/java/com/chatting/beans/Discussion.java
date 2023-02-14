package com.chatting.beans;

import java.util.Date;

public class Discussion {
	
	private int id;
	private int sujet;
	private String message;
	private int user;
	private String usernom;
	private String userprenom;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSujet() {
		return sujet;
	}
	public void setSujet(int sujet) {
		this.sujet = sujet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getUsernom() {
		return usernom;
	}
	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}
	public String getUserprenom() {
		return userprenom;
	}
	public void setUserprenom(String userprenom) {
		this.userprenom = userprenom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	

}
