package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	// INT USERDAOSERVICE HO MESSO @COMPONENT E GENERATO IL COSTRUTTORE IN QUESTA CLASSE DI SERVICE IN MODO DA EVITARE (SE NON CI FOSSE
	//  STATO IL @COMPONENT) DI CREARE UNA NUOVA ISTANZA: PRIVATE USERDAOSERVICE SERVICE = NEW USERDAOSERVICE()
	
	private UserDaoService service;
	
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}


	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/find-user/{id}")
	public User findById(@PathVariable int id) {
		return service.findById(id);
	}
}
