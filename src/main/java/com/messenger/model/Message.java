package com.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private String id;
	private String message;
	private Date created;
	private String author;
	
	public Message(String id,String message,Date created,String author) {
		this.id=id;
		this.message=message;
		this.created=created;
		this.author=author;
	}
	
	Message() {
		System.out.println("THis is default construct");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	
	
}
