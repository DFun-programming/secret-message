package com.secret.message.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secret.message.entities.Message;
import com.secret.message.entities.UserData;
import com.secret.message.repos.MessageRepo;
import com.secret.message.repos.UserDataRepo;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class MessageController {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserDataRepo userDataRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@CrossOrigin("*")
	@PostMapping("/message")
	public void sendMessage(@RequestBody Message message,@RequestParam String uid )
	{
		Message newMsg = messageRepo.insert(message);
		ObjectId id = new ObjectId(uid);
		mongoTemplate.update(UserData.class)
		.matching(Criteria.where("id").is(id))
		.apply(new Update().push("messages" , newMsg))
		.first();
	}
	@CrossOrigin("*")
	@PostMapping("/get-messages")
	public ResponseEntity<List<Message>> getMessage(@RequestBody UserData userData)
	{
		System.out.println(userData);
		System.out.println(userData.getEmail());
		System.out.println(userData.getId());
		
		List<Message> messages =new ArrayList();
		messages = userDataRepo.findByEmail(userData.getEmail()).orElse(null).getMessages();
//		.forEach(id->{
//			messages.add(messageRepo.findById(null).orElse(null));
//		});
//		System.out.println(messages);
//		System.out.println(userDataRepo.findByEmail(userData.getEmail()).orElse(null).getMessages().get(0));
		System.out.println(messages);
		return new ResponseEntity(messages,HttpStatus.ACCEPTED);
	}
}
