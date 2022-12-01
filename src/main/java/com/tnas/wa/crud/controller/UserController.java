package com.tnas.wa.crud.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

import com.tnas.wa.crud.api.UserControllerApi;
import com.tnas.wa.crud.dto.UserDto;
import com.tnas.wa.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController implements UserControllerApi {

	@Autowired
	private UserService userService;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> detail(@PathVariable @NotNull Long id) {
		
		return this.userService.retrieveUser(id)
				.map(user -> ResponseEntity.ok().body(user))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@Override
	@PostMapping
	public ResponseEntity<UserDto> create(
			@RequestBody @Valid UserDto user, UriComponentsBuilder uriBuilder) {
		
		var optFreshUser = this.userService.createUser(user);
		
		if (optFreshUser.isPresent()) {
			var freshUser = optFreshUser.get();
			var address = uriBuilder.path("/users/{id}").buildAndExpand(freshUser.getId()).toUri(); 
			return ResponseEntity.created(address).body(freshUser);
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(
			@PathVariable @NotNull Long id, @RequestBody @Valid UserDto user) {
		
		return this.userService.updateUser(user, id)
				.map(u -> ResponseEntity.ok().body(u))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
