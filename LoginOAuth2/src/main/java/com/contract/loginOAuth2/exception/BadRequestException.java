package com.contract.loginOAuth2.exception;


import static com.contract.loginOAuth2.constans.ExceptionsConstant.*;


public class BadRequestException extends RuntimeException{

	public BadRequestException(){
		super(BAD_REQUEST_EXCEPTION);
	}
	
}
