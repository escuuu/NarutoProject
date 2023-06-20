package com.joyfe.naruto.des.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Hay campos vacíos que no derberian estarlos") 
public class NullPoint extends Exception{
	
	public NullPoint(String message) {
		super(message);
	}
}