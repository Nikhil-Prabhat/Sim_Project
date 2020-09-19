package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Cart;
import com.cognizant.repository.CartRepository;
import com.sun.media.jfxmedia.logging.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CartController {

	@Autowired
	CartRepository cartRepository;

	@GetMapping("/cart/add")
	public ResponseEntity<?> addCart(@RequestParam("id") Integer id) {
		log.debug("Adding item in the cart", "START");
		Cart cart = new Cart();
		cart.setUserid("user");
		cart.setId(id);
		cartRepository.save(cart);

		log.debug("Adding item in the cart", "END");
		return new ResponseEntity<>("Added", HttpStatus.OK);

	}

	@GetMapping("/cart/all")
	public ResponseEntity<?> GetAllCartItems(@RequestParam("userid") String userid) {
		log.debug("Get all cart items", "START");
		List<Cart> findAll = cartRepository.findByUserid(userid);
		
		log.debug("Get all cart items", "END");
		return new ResponseEntity<>(findAll, HttpStatus.OK);

	}

	@GetMapping("cart/delete")
	public ResponseEntity<?> deleteItem(@RequestParam("id") Integer id) {
		log.debug("Delete Cart Items", "START");
		cartRepository.deleteByMenuId(id);
		log.debug("Delete Cart Items", "END");
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
