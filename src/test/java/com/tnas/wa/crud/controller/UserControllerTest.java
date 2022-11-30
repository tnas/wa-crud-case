package com.tnas.wa.crud.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.tnas.wa.crud.model.User;
import com.tnas.wa.crud.util.JsonUserFactory;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {
	
	private static final String USERS_API = "http://localhost:8080/users";

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Order(1)
	@Test
	void whenAddingFirstUser_ThenHttpCreated() throws JSONException {
		
		var httpHeaders = new HttpHeaders();
    	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
    	var jsonUser = JsonUserFactory.getUser(1);
		var request = new HttpEntity<String>(jsonUser.toString(), httpHeaders);
    	var response = this.restTemplate.postForEntity(USERS_API, request, User.class);
    	
    	assertEquals(HttpStatus.CREATED, response.getStatusCode());
    	assertEquals(jsonUser.get("name"), response.getBody().getName());
    	assertEquals(jsonUser.get("document"), response.getBody().getDocument());
	}
	
	@Order(2)
	@Test
	void whenGettingFirstdUser_ThenHttpOk() throws JSONException {
		
		var response = this.restTemplate.getForEntity(USERS_API.concat("/1"), User.class);
		
		var jsonUser = JsonUserFactory.getUser(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonUser.get("name"), response.getBody().getName());
    	assertEquals(jsonUser.get("document"), response.getBody().getDocument());
	}
	
	@Order(3)
	@Test
	void whenAddingSecondUserAndUpdateIt_ThenHttpOk() throws JSONException {
		
		var httpHeaders = new HttpHeaders();
    	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
    	var jsonUser = JsonUserFactory.getUser(2);
		var postRequest = new HttpEntity<String>(jsonUser.toString(), httpHeaders);
    	var postResponse = this.restTemplate.postForEntity(USERS_API, postRequest, User.class);
    	assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
    	assertEquals(jsonUser.get("name"), postResponse.getBody().getName());
    	assertEquals(jsonUser.get("document"), postResponse.getBody().getDocument());
    	
    	jsonUser.put("name", ((String) jsonUser.get("name")).concat(" Alterado"));
    	var putRequest = new HttpEntity<String>(jsonUser.toString(), httpHeaders);
    	this.restTemplate.put(USERS_API.concat("/2"), putRequest);
    	
    	var getResponse = this.restTemplate.getForEntity(USERS_API.concat("/2"), User.class);
    	assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(jsonUser.get("name"), getResponse.getBody().getName());
    	assertEquals(jsonUser.get("document"), getResponse.getBody().getDocument());
	}
}
