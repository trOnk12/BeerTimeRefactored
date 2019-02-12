package com.example.gebruiker.beertimerefactor.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@IgnoreExtraProperties
public class Dialog implements IDialog<Message>,Serializable {

	public Dialog(){

	}

	private  String id;
	private  String dialogPhoto;
	private  String dialogName;
	private  ArrayList<User> users;
	private  Message lastMessage;
	private  int unreadCount;

	public void setId(String id) {
		this.id = id;
	}

	public void setDialogPhoto(String dialogPhoto) {
		this.dialogPhoto = dialogPhoto;
	}

	public void setDialogName(String dialogName) {
		this.dialogName = dialogName;
	}

	public void setUnreadCount(int unreadCount){
		this.unreadCount = unreadCount;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getDialogPhoto() {
		return dialogPhoto;
	}

	@Override
	public String getDialogName() {
		return dialogName;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Exclude
	@Override
	public Message getLastMessage() {
		return lastMessage;
	}

	@Override
	public void setLastMessage(Message lastMessage) {
		this.lastMessage = lastMessage;
	}

	@Override
	public int getUnreadCount() {
		return unreadCount;
	}

}
