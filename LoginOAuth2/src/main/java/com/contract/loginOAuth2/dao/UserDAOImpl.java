package com.contract.loginOAuth2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.contrat.loginOAuth2.entities.User;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public User findByUser(String userName) {
		Query query = new Query(Criteria.where("user").is(userName));
		User user = mongoTemplate.findOne(query, User.class);
		if (user == null) {
			throw new IllegalArgumentException("User not found");
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> listUsers = mongoTemplate.findAll(User.class);
		return listUsers;
	}

}
