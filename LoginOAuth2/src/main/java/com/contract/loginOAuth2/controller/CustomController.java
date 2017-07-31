package com.contract.loginOAuth2.controller;

import static com.contract.loginOAuth2.constans.ContractMethodsConstans.*;
import static com.contract.loginOAuth2.constans.ContractMethodsConstans.URL_CONTRACT;
import static com.contract.loginOAuth2.constans.PrivilegeConstans.CAN_READ_USERS;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.contract.entities.custom.Custom;
import com.contract.exception.DataBaseResultNotFoundException;
import com.contract.loginOAuth2.exception.BadRequestException;
import com.mongodb.DuplicateKeyException;

@RestController
public class CustomController {

	@RequestMapping(value = CUSTOM_FIND_ALL, method = RequestMethod.GET)
	@Secured(CAN_READ_USERS)
	public List<Custom> findAll() throws DataBaseResultNotFoundException {
		try{
			RestTemplate restTemplate = new RestTemplate();
			List<Custom> customsList = restTemplate.getForObject(URL_CONTRACT + CUSTOM_FIND_ALL, List.class);
			return customsList;
		}
		catch(Exception e){
			throw new DataBaseResultNotFoundException();
		}
	}

	@PostMapping(value = CUSTOM_INSERT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Secured(CAN_READ_USERS)
	public ResponseEntity<Custom> insert(@RequestBody Custom custom) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String URL = URL_CONTRACT + CUSTOM_INSERT;

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Custom> request = new HttpEntity<Custom>(custom, headers);
			ResponseEntity<Custom> response = restTemplate.postForEntity(URL, request, Custom.class);

			return response;
		}
		catch (Exception e) {
			throw new BadRequestException();
		}

	}

}
