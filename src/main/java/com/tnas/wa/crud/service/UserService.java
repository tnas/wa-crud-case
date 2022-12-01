package com.tnas.wa.crud.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnas.wa.crud.dto.UserDto;
import com.tnas.wa.crud.model.User;
import com.tnas.wa.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Optional<UserDto> retrieveUser(Long id) {
		return this.mapUserToDto(this.userRespository.findById(id));
	}
	
	public Optional<UserDto> createUser(UserDto dto) {
		
		var user = this.modelMapper.map(dto, User.class);
		user.setUpCreationDate();
		
		return this.mapUserToDto(Optional.of(this.userRespository.save(user)));
	}
	
	public Optional<UserDto> updateUser(UserDto dto, Long id) {
		
		var optSavedUser = this.userRespository.findById(id);
		
		if (optSavedUser.isPresent()) {
			
			var savedUser = optSavedUser.get();
			
			savedUser.setName(dto.getName());
			savedUser.setDocument(dto.getDocument());
			savedUser.setUpdateDate(LocalDateTime.now());
			
			return this.mapUserToDto(Optional.of(this.userRespository.save(savedUser))) ; 
		}
		else {
			return Optional.empty();
		}
	}
	
	private Optional<UserDto> mapUserToDto(Optional<User> optUser) {
		return optUser.isPresent() ?
				Optional.of(this.modelMapper.map(optUser.get(), UserDto.class)) :
					Optional.empty();
	}
}
