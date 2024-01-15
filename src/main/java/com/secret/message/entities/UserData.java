package com.secret.message.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "users")
public class UserData {

	@Id
	private ObjectId id;
	String name;
	String email;
	String photo;
	String displayName;
	String newid;
	@DocumentReference
	private List<Message>messages;
	

	

	

	public UserData(ObjectId id, String name, String email, String photo, String displayName, String newid,
			List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.displayName = displayName;
		this.newid = newid;
		this.messages = messages;
	}

	public UserData(ObjectId id, String name, String email, String photo, String displayName, List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.displayName = displayName;
		this.messages = messages;
	}

	public UserData(ObjectId id, String name, String email, String photo, String displayName) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.displayName = displayName;
	}
	
	public UserData(String name, String email, String photo, String displayName) {
		super();
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.displayName = displayName;
	}

	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNewid() {
		return newid;
	}

	public void setNewid(String newid) {
		this.newid = newid;
	}

	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	
	
}
