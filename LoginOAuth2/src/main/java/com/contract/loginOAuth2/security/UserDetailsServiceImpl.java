package com.contract.loginOAuth2.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.contract.loginOAuth2.dao.UserDAO;
import com.contrat.loginOAuth2.entities.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	    private UserDAO userDAO;

	    @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	        if(userName == null){
	            throw new UsernameNotFoundException("This file is empty");
	        }

	        User user = userDAO.findByUser(userName);
	        if (user == null) {
	            throw new UsernameNotFoundException("Username was not found: " + userName);
	        }
	        final String[] privilegeStringsArray = user.getPrivileges();
	        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(privilegeStringsArray);

	        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), auths);
	    }

}
