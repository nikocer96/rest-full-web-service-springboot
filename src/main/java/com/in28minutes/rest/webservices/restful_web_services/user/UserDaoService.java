package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Pippo", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Luca", LocalDate.now().minusYears(20)));
		users.add(new User(3, "Maria", LocalDate.now().minusYears(10)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
}
