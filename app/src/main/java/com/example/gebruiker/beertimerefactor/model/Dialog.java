package com.example.gebruiker.beertimerefactor.model;

import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.ArrayList;
import java.util.List;

public class Dialog implements IDialog<Message> {

	public Dialog(){

	}

	public void setId(String id) {
		Id = id;
	}

	public void setDialogPhoto(String dialogPhoto) {
		DialogPhoto = dialogPhoto;
	}

	public void setDialogName(String dialogName) {
		DialogName = dialogName;
	}

	public void setUsers(ArrayList<User> users) {
		Users = users;
	}

	private String Id;
	private String DialogPhoto;
	private String DialogName;
	private ArrayList<User> Users;
	private Message LastMessage;
	private int unreadcount;

	@Override
	public String getId() {
		return Id;
	}

	@Override
	public String getDialogPhoto() {
		return DialogPhoto;
	}

	@Override
	public String getDialogName() {
		return DialogName;
	}

	@Override
	public List<User> getUsers() {
		return Users;
	}

	@Override
	public Message getLastMessage() {
		return LastMessage;
	}

	@Override
	public void setLastMessage(Message message) {
		LastMessage = (Message) message;
	}


	@Override
	public int getUnreadCount() {
		return unreadcount;
	}

}
