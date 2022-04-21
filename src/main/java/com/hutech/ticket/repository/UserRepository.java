package com.hutech.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hutech.ticket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user u WHERE u.email = ?1", nativeQuery = true)
	public User findByEmail(String email);
	
	@Query(value = "SELECT * FROM user u WHERE u.username = ?1", nativeQuery = true)
	public User findByUsername(String username);
}
