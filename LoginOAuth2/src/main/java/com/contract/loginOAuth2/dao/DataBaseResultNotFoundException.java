package com.contract.loginOAuth2.dao;

import static com.contract.loginOAuth2.constans.ExceptionsConstant.*;

public class DataBaseResultNotFoundException extends RuntimeException {
	
	public DataBaseResultNotFoundException(){
		super(DATABASE_RESULT_NOT_FOUND_EXCEPTION_MESSAGE);
	}

}
