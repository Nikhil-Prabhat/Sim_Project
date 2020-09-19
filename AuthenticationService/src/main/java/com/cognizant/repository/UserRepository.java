package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.LoginUser;


@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

	 LoginUser findByUsername(String username);

}
