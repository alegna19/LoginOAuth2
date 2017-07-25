package com.contract.loginOAuth2.dao;

import java.util.List;

import com.contrat.loginOAuth2.entities.User;

public interface UserDAO {
	
public User findByUser(String userName);
    
    public List<User> findAll();

}
