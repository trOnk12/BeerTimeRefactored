package com.example.gebruiker.beertimerefactor.model;

import com.stfalcon.chatkit.commons.models.IUser;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class User implements IUser {

    @Nullable
    public String email;

    public User(){

	}
	private String Id;

	private String Name;

	private String Avatar;

	private ArrayList<String> dialogs;

	public ArrayList<String> getDialogs() {
		return dialogs;
	}

	public void setDialogs(ArrayList<String> dialogs) {
		this.dialogs = dialogs;
	}

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
