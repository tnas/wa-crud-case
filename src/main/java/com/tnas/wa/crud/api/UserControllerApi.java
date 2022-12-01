package com.tnas.wa.crud.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.tnas.wa.crud.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api("User API")
@Tag(name = "User API", description = "The API for CRUD operations on a User")
public interface UserControllerApi {

	@Operation(summary = "Retrive all information of a user", tags = "User API")
	@ApiImplicitParam(name = "id", paramType = "path", value = "A user internal ID", required = true,
			dataTypeClass = Long.class, example = "1")
	ResponseEntity<UserDto> detail(Long id);

	@Operation(summary = "Create a new user", tags = "User API")
	@ApiImplicitParam(name = "user", paramType = "body", required = true,
			dataTypeClass = UserParam.class,
			value = "Name and document of the user to be created")
	ResponseEntity<UserDto> create(UserDto user, UriComponentsBuilder uriBuilder);

	@Operation(summary = "Update a user", tags = "User API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", paramType = "path", value = "A user internal ID", required = true,
				dataTypeClass = Long.class, example = "1"),
		@ApiImplicitParam(name = "user", paramType = "body", required = true,
				dataTypeClass = UserParam.class,
				value = "New name and document of the user to be updated")
	})
	ResponseEntity<UserDto> update(Long id, UserDto user);

}