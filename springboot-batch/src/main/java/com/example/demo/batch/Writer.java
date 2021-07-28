package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UsersDAO;
import com.example.demo.entity.Users;

@Component
public class Writer implements ItemWriter<Users> {

	@Autowired
	private UsersDAO repo;

	@Override
	@Transactional
	public void write(List<? extends Users> users) throws Exception {
		repo.saveAll(users);
	}
}
