package com.contract.loginOAuth2.controller;

import static com.contract.loginOAuth2.constans.ContractMethodsConstans.CUSTOM_FIND_ALL;
import static com.contract.loginOAuth2.constans.ContractMethodsConstans.URL_CONTRACT;
import static com.contract.loginOAuth2.constans.PrivilegeConstans.CAN_READ_USERS;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.contract.entities.custom.Custom;

@RestController
public class CustomController {
	
	@RequestMapping(value = CUSTOM_FIND_ALL, method = RequestMethod.GET)
	@Secured(CAN_READ_USERS)
	public List<Custom> findAll(){
		RestTemplate restTemplate = new RestTemplate();
        List<Custom> customsList = restTemplate.getForObject(URL_CONTRACT + CUSTOM_FIND_ALL, List.class);
       return customsList; 
	}

}
