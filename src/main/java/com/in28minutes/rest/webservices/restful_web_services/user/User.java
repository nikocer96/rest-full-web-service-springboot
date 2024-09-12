package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	
	private Integer id;
	
	@Size(min=2, message = "Il nome deve contenere minimo 2 caratteri")
	private String name;
	
	@Past(message = "Non puo' essere nel futuro la data")
	private LocalDate date;
	
	
	public User(Integer id, String name, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
