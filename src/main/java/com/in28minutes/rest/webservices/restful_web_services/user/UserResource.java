package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		User user = service.findById(id);
		if (user == null) {
			//CLASSE DELL'ECCEZIONE CREATA MANUALMENTE
			throw new UserNotFoundException("id " + id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = service.save(user);
		//SERVE PER RITORNARE L'ID DELL'UTENTE CREATO
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		//SERVE PER FAR RITORNARE IL 201 DI RISPOSTA CREATED
		return ResponseEntity.created(location).build();
	}
}














