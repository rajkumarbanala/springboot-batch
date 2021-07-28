package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

/**
 * @author Rajkumar Banala 22-Feb-2021
 *
 */

public interface UsersDAO extends JpaRepository<Users, Long> {

}
