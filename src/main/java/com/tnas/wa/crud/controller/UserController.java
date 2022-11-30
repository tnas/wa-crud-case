package com.tnas.wa.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tnas.wa.crud.model.User;
import com.tnas.wa.crud.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> detail(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(this.userService.retrieveUser(id));
	}
	
	@PostMapping
	public ResponseEntity<User> create(
			@RequestBody @Valid User user, UriComponentsBuilder uriBuilder) {
		
		var freshUser = this.userService.createUser(user);
		var address = uriBuilder.path("/users/{id}").buildAndExpand(freshUser.getId()).toUri(); 
		
		return ResponseEntity.created(address).body(freshUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(
			@PathVariable @NotNull Long id, @RequestBody @Valid User user) {
		return ResponseEntity.ok(this.userService.updateUser(user, id));
	}
}
