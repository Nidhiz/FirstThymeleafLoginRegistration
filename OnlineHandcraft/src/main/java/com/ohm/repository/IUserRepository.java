package com.ohm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohm.pojos.User;

@Repository									
public interface IUserRepository extends JpaRepository<User, Long> {
		User findByEmail(String email);
}
