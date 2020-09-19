package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	List<Cart> findByUserid( String userid);
	
	@Modifying
	@Transactional
	@Query("delete Cart u where u.id = :id")
	void deleteByMenuId(@Param("id")Integer id);

}
