package com.main.globalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.exceptions.ResourceNotFoundExceptions;
import com.main.globalExceptions.payload.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<ApiResponce> handlerResourceNotFoundException(ResourceNotFoundExceptions ex)
	{
		String message = ex.getMessage();
		ApiResponce build = ApiResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponce>(build,HttpStatus.NOT_FOUND);
		
		
		
	}
	
	
	
}
