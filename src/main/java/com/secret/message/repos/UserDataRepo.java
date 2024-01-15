package com.secret.message.repos;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.secret.message.entities.UserData;

public interface UserDataRepo extends MongoRepository<UserData, ObjectId> {

	Optional<UserData> findByEmail(String email);

}
