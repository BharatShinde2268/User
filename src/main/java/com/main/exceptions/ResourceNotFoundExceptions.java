package com.main.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {

	private String msg;

	public ResourceNotFoundExceptions() {
		super("Resource Not found on Server !!");
		
		
	}
	public ResourceNotFoundExceptions(String msg)
	{
		super(msg);
		
		
	}
	
	

}
