package com.in28minutes.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restful_web_services.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
 
	//QUESTO SERVE PER VISUALIZZARE NEL BODY DELLE REST LA DATA, MESSAGGIO E DETTAGLIO
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
 
	//QUESTO SERVE PER FORNIRE LA RISPOSTA CON 404 QUANDO NON SI TROVA UN UTENTE
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		//ex.getFieldError().getDefaultMessage() SERVE PER STAMPARE IL MESSAGGIO
		//DI ERRORE SCRITTO DA ME IN User
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				"Totale errori: " +  ex.getErrorCount() + " " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
			
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
 
	
}
