package com.tnas.wa.crud.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnas.wa.crud.model.User;
import com.tnas.wa.crud.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRespository;
	
	public User retrieveUser(Long id) {
		return this.userRespository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
	}
	
	public User createUser(User user) {
		
		user.setUpCreationDate();
		
		return this.userRespository.save(user);
	}
	
	public User updateUser(User user, Long id) {
		
		var savedUser = this.retrieveUser(id);
		
		savedUser.setName(user.getName());
		savedUser.setDocument(user.getDocument());
		savedUser.setUpdateDate(LocalDateTime.now());
		
		return this.userRespository.save(savedUser);
	}
}
