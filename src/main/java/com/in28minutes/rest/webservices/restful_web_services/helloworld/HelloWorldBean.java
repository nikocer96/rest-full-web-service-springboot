package com.in28minutes.rest.webservices.restful_web_services.helloworld;

public class HelloWorldBean {
	
	private String message;
	private String content;

	public HelloWorldBean(String message, String content) {
		this.message = message;
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", content=" + content + "]";
	}
	
	

}
