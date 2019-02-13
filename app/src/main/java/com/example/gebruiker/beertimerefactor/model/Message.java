package com.example.gebruiker.beertimerefactor.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.io.Serializable;
import java.util.Date;

@IgnoreExtraProperties
public class Message implements IMessage,Parcelable {

	public Message(){

	}

	private String id;
	private String text;
	private User user;
	private Date createdAt;

	protected Message(Parcel in) {
		id = in.readString();
		text = in.readString();
	}

	public static final Creator<Message> CREATOR = new Creator<Message>() {
		@Override
		public Message createFromParcel(Parcel in) {
			return new Message(in);
		}

		@Override
		public Message[] newArray(int size) {
			return new Message[size];
		}
	};

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreatedAt(Date createdAt) {
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(text);
	}
}
