package com.secret.message.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.secret.message.entities.UserData;
import com.secret.message.repos.UserDataRepo;

@Configuration
public class MongoConfigur {

	   @Bean
	    CommandLineRunner initDb(UserDataRepo repository) {
	        // create an instance of your @Document annotated class
	        UserData myDocument = new UserData("Deb","debmallya@gmail.com","","");
	        
	        myDocument = repository.insert(myDocument);
	        repository.delete(myDocument);
	        return (args) -> {
	        }; 
	    }
}
