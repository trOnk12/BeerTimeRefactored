package com.example.gebruiker.beertimerefactor.model;

import com.stfalcon.chatkit.commons.models.IUser;

public class User implements IUser {

	public User(){

	}
	private String Id;

	private String Name;

	private String Avatar;

	public void setId(String id) {
		Id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	@Override
	public String getId() {
		return Id;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public String getAvatar() {
		return Avatar;
	}
}
