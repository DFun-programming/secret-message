package com.secret.message.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {

	@Id
	private ObjectId id;
	private String message; 
	private String displayName;
	private String photo;
	private String email;
	
	public Message(ObjectId id, String message, String displayName, String photo, String email) {
		super();
		this.id = id;
		this.message = message;
		this.displayName = displayName;
		this.photo = photo;
		this.email = email;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", displayName=" + displayName + ", photo=" + photo
				+ ", email=" + email + "]";
	}
	
	


}

