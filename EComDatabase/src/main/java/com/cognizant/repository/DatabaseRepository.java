package com.cognizant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Menu;

public interface DatabaseRepository extends JpaRepository<Menu, Integer> {

	// Customer
	Optional<Menu> findById(Integer id);

	// showing all items for admin
	List<Menu> findAll();

	// showing all items for user
	@Query("select u from Menu u where u.active = true")
	List<Menu> findAllCustomer();
	
	//Updation
	@Modifying
	@Transactional
	@Query("update Menu u set u.pic = :pic,u.name = :name,u.price = :price,u.active = :active, u.category = :category,u.freedelivery = :freedelivery  where u.id = :id")
	void updateMenu(@Param("id") Integer id,@Param("pic") String pic,@Param("name") String name,@Param("price") float price,@Param("active") boolean active,@Param("category") String category,@Param("freedelivery") boolean freedelivery);

	//Deletion
	@Modifying
	@Transactional
	@Query("delete Menu u where u.id = :id")
	int deleteItem(@Param("id") Integer id);

}
