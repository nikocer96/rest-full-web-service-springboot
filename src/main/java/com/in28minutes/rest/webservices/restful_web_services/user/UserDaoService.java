package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(userCount++, "Pippo", LocalDate.now().minusYears(30)));
		users.add(new User(userCount++, "Luca", LocalDate.now().minusYears(20)));
		users.add(new User(userCount++, "Maria", LocalDate.now().minusYears(10)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(userCount++);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}






