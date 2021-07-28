package com.example.demo.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UsersDAO;
import com.example.demo.entity.Users;

@Component
public class Processor implements ItemProcessor<Users, Users> {
	
	@Autowired
	private UsersDAO userRepo;

	@Override
	public Users process(Users user) throws Exception {
		Optional<Users> userFromDb = userRepo.findById(user.getUserId());
		if(userFromDb.isPresent()) {
			user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
		}
		return user;
	}
}
