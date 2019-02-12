package com.example.gebruiker.beertimerefactor.model;

import com.google.firebase.database.IgnoreExtraProperties;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.io.Serializable;
import java.util.Date;

@IgnoreExtraProperties
public class Message implements IMessage,Serializable {

	public Message(){

	}

	private String id;
	private String text;
	private User user;
	private Date createdAt;

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreaedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public IUser getUser() {
		return user;
	}

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}
}
