package com.secret.message.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secret.message.entities.UserData;
import com.secret.message.repos.UserDataRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserDataRepo userDataRepo;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/user")
	public ResponseEntity<String> storeAfterCreateLink(@RequestBody UserData u)
	{  
		System.out.println(u);
		UserData user=userDataRepo.findByEmail(u.getEmail()).orElse(null);
		if(user == null)
		{
			u = userDataRepo.insert(u);
			u.setNewid(u.getId().toString());
				return new ResponseEntity(u,HttpStatus.CREATED);
		}
		user.setName(u.getName());
		user.setNewid(user.getId().toString());
		userDataRepo.save(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}

}
