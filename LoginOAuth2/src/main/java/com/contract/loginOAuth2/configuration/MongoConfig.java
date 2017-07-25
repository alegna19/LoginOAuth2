package com.contract.loginOAuth2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	 @Override
	    protected String getDatabaseName() {
	        return "login";
	    }
	  
	    @Override
	    public Mongo mongo() throws Exception {
	        return new MongoClient("127.0.0.1", 27017);
	    }
	  
	    @Override
	    protected String getMappingBasePackage() {
	        return "com.contract.loginOAuth2";
	    }

}
