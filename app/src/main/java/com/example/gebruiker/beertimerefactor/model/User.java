package com.example.gebruiker.beertimerefactor.model;

import com.stfalcon.chatkit.commons.models.IUser;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class User implements IUser {

    @Nullable
    public String email;

    public User() {

    }

    public User(String email, String Id) {
        this.email = email;
        this.Id = Id;
    }


    private String Id;

    private String Name;

    private String Avatar;

    private ArrayList<String> dialogs;

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    public ArrayList<String> getFriendsID() {
        return friendsID;
    }

    public void setFriendID(ArrayList<String> friends) {
        this.friendsID = friends;
    }

    public void setFriendsID(ArrayList<String> friendsID) {
        this.friendsID = friendsID;
    }

    private ArrayList<String> friendsID;

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
