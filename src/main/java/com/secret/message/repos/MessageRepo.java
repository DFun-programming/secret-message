package com.secret.message.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.secret.message.entities.Message;

public interface MessageRepo extends MongoRepository<Message, ObjectId>
{
	
}
