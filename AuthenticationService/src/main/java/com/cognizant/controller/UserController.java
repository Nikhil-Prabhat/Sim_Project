package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Cart;
import com.cognizant.model.Menu;
import com.cognizant.repository.ECommClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	ECommClient admin;

	
	

	@GetMapping("/admin/all")
	public ResponseEntity<?> getAllAdminItems() {
		log.debug("Get Admin menu items", "START");
		List<Menu> allMenus = admin.getAllMenus();
		log.debug("Get Admin menu items", "END");
		return new ResponseEntity<>(allMenus, HttpStatus.OK);
	}


	@GetMapping("admin/add")
	public ResponseEntity<?> addItem(@RequestParam("pic") String pic, @RequestParam("name") String name,
			@RequestParam("price") float price, @RequestParam("active") boolean active,
			@RequestParam("category") String category, @RequestParam("freedelivery") boolean freedelivery) {
		log.debug("Get Admin add menu item", "START");
		String addItem = admin.addItem(pic, name, price, active, category, freedelivery);
		log.debug("Get Admin add menu item", "END");
		return new ResponseEntity<>(addItem, HttpStatus.OK);
	}


	@GetMapping("/admin/edit")
	public ResponseEntity<?> editMenu(@RequestParam("id") Integer id, @RequestParam("pic") String pic,

			@RequestParam("name") String name, @RequestParam("price") float price,

			@RequestParam("active") boolean active, @RequestParam("category") String category,

			@RequestParam("freedelivery") boolean freedelivery) {

		log.debug("Get Admin edit menu items", "START");
		String editMenu = admin.editMenu(id, pic, name, price, active, category, freedelivery);
		log.debug("Get Admin edit menu items", "END");
		return new ResponseEntity<>(editMenu, HttpStatus.OK);
	}

	

	@GetMapping("admin/delete")
	public ResponseEntity<?> deleteItem(@RequestParam("id") Integer id) {
		log.debug("Get Admin delete menu items", "START");
		String deleteItem = admin.deleteItem(id);
		log.debug("Get Admin delte menu items", "END");
		return new ResponseEntity<>(deleteItem, HttpStatus.OK);
	}

	@RequestMapping("/user/menu")
	public List<Menu> customermenu() {
		List<Menu> menusCustomers = admin.getMenusCustomers();
		return menusCustomers;
	}

	

	
	@GetMapping("/user/all")
	public ResponseEntity<?> getAllCustomerItems(@RequestParam("userid") String userid) {
		log.debug("Get user cart items", "START");
		List<Cart> getAllCartItems = admin.GetAllCartItems(userid);
		log.debug("Get user cart items", "END");
		return new ResponseEntity<>(getAllCartItems, HttpStatus.OK);
	}

	@GetMapping("/usercart/add")
	public ResponseEntity<?> addCart(@RequestParam("id") Integer id) {
		log.debug("Get user add cart item", "START");
		String addCart = admin.addCart(id);
		log.debug("Get user add cart item", "END");
		return new ResponseEntity<>(addCart, HttpStatus.OK);
	}

	@GetMapping("usercart/delete")
	public ResponseEntity<?> deleteCartItem(@RequestParam("id") Integer id) {
		log.debug("Get user delete cart item", "START");
		String deleteCartItem = admin.deleteCartItem(id);
		log.debug("Get user delete cart item", "end");
		return new ResponseEntity<>(deleteCartItem, HttpStatus.OK);
	}

}
