package com.cognizant.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Cart;
import com.cognizant.model.Menu;

@FeignClient(name = "ecomdatabase-service", url = "localhost:8200")
public interface ECommClient {
	@GetMapping("/database/id/{i}")
	public Menu retrieveExchangeValue(@PathVariable("i") Integer id);

	@GetMapping("/database/all")
	public List<Menu> getAllMenus();

	@GetMapping("/database/edit")
	public String editMenu(@RequestParam("id") Integer id, @RequestParam("pic") String pic,

			@RequestParam("name") String name, @RequestParam("price") float price,

			@RequestParam("active") boolean active, @RequestParam("category") String category,

			@RequestParam("freedelivery") boolean freedelivery);

	@GetMapping("database/delete")
	public String deleteItem(@RequestParam("id") Integer id);

	@GetMapping("database/add")
	public String addItem(@RequestParam("pic") String pic, @RequestParam("name") String name,
			@RequestParam("price") float price, @RequestParam("active") boolean active,
			@RequestParam("category") String category, @RequestParam("freedelivery") boolean freedelivery);
	
	@GetMapping("/database/allitems")
	public List<Menu> getMenusCustomers();
	
	@GetMapping("/cart/add")
	public String addCart(@RequestParam("id") Integer id);

	@GetMapping("/cart/all")
	public List<Cart> GetAllCartItems(@RequestParam("userid") String userid);

	@GetMapping("cart/delete")
	public String deleteCartItem(@RequestParam("id") Integer id);

}
