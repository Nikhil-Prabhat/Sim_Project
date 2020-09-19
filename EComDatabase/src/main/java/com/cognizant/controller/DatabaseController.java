package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Menu;
import com.cognizant.repository.DatabaseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DatabaseController {

	@Autowired
	DatabaseRepository databaseRepository;

	@GetMapping("/database/all")
	public ResponseEntity<?> getMenus() {
		log.debug("Get all menus for admin", "START");
		List<Menu> findAll = databaseRepository.findAll();
		

		log.debug("Get all menus for admin", "END");

		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@GetMapping("/database/allitems")
	public ResponseEntity<?> getMenusCustomers() {
		log.debug("Get all menus for customer", "START");
		List<Menu> findAll = databaseRepository.findAllCustomer();
	

		log.debug("Get all menus for customer", "END");
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@GetMapping("/database/edit")
	public ResponseEntity<?> editMenu(@RequestParam("id") Integer id, @RequestParam("pic") String pic,

			@RequestParam("name") String name, @RequestParam("price") float price,

			@RequestParam("active") boolean active, @RequestParam("category") String category,

			@RequestParam("freedelivery") boolean freedelivery) {

		log.debug("Edit Menu", "START");
		databaseRepository.updateMenu(id, pic, name, price, active, category, freedelivery);
		log.debug("Edit Menu", "END");
		return new ResponseEntity<>("Item Updated Successfully", HttpStatus.OK);
	}

	@GetMapping("database/delete")
	public ResponseEntity<?> deleteItem(@RequestParam("id") Integer id) {
		log.debug("Delete Menu", "START");
		databaseRepository.deleteItem(id);
		log.debug("Delete Menu", "END");
		return new ResponseEntity<>("Item deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("database/add")
	public ResponseEntity<?> addItem(@RequestParam("pic") String pic, @RequestParam("name") String name,
			@RequestParam("price") float price, @RequestParam("active") boolean active,
			@RequestParam("category") String category, @RequestParam("freedelivery") boolean freedelivery) {
		log.debug("Add Menu", "START");
		Menu m = new Menu();
		m.setPic(pic);
		m.setPrice(price);
		m.setName(name);
		m.setActive(active);
		m.setFreedelivery(freedelivery);
		m.setCategory(category);

		databaseRepository.save(m);
		log.debug("Add Menu", "END");
		return new ResponseEntity<>("Item added successfully", HttpStatus.OK);
	}

}
