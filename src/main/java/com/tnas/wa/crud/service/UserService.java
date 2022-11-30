package com.tnas.wa.crud.service;

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
	
	public void saveUser(User user) {
		this.userRespository.save(user);
	}
}
