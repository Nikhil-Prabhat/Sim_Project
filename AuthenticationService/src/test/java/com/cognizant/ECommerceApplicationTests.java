package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.repository.ECommClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ECommerceApplication.class)
class ECommerceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ECommClient admin;

	@Nested
	class BeforeTests {
		@Test
		public void testAdminMenu() {
			String allMenus = admin.getAllMenus().toString();
			String expected = "[Menu(id=1, pic=shoes.pic, name=Nike, price=2300.0, active=true, category=Shoes, freedelivery=true), Menu(id=2, pic=mobile.pic, name=Iphone, price=12300.0, active=true, category=Mobiles, freedelivery=true), Menu(id=3, pic=tv.pic, name=Sony, price=21300.0, active=true, category=TV, freedelivery=false), Menu(id=4, pic=watch.pic, name=Rolex, price=6300.0, active=true, category=Watch, freedelivery=false), Menu(id=5, pic=perfume.pic, name=Van Se Trio, price=3300.0, active=false, category=Perfumes, freedelivery=true)]";

			assertEquals(allMenus, expected);
		}

		@Test
		public void testCustomerMenu() {
			String allMenus = admin.getMenusCustomers().toString();
			String expected = "[Menu(id=1, pic=shoes.pic, name=Nike, price=2300.0, active=true, category=Shoes, freedelivery=true), Menu(id=2, pic=mobile.pic, name=Iphone, price=12300.0, active=true, category=Mobiles, freedelivery=true), Menu(id=3, pic=tv.pic, name=Sony, price=21300.0, active=true, category=TV, freedelivery=false), Menu(id=4, pic=watch.pic, name=Rolex, price=6300.0, active=true, category=Watch, freedelivery=false)]";
			assertEquals(expected, allMenus);
		}

		@Test
		public void testGetAllCartItems() {

			String string = admin.GetAllCartItems("user").toString();
			String expected = "[Cart(pkey=1, userid=user, id=1), Cart(pkey=2, userid=user, id=2)]";
			assertEquals(expected, string);
		}

	}

	@Nested
	class LastTests {
		@Test
		public void testAdminDelete() {
			String deleteItem = admin.deleteItem(2);
			String expected = "Item deleted Successfully";
			assertEquals(deleteItem, expected);
		}

		@Test
		public void testAdminUpdate() {
			String editItem = admin.editMenu(3, "radio.pic", "radio", 4500, true, "Gadget", true);
			String expected = "Item Updated Successfully";
			assertEquals(expected, editItem);
		}

		@Test
		public void testAdminAdd() {
			String addItem = admin.addItem("chocolate.pic", "DairyMilk", 1200, true, "Chocolate.pic", false);
			String expected = "Item added successfully";
			assertEquals(expected, addItem);
		}

		@Test
		public void testAddCart() {
			String addCart = admin.addCart(3);
			String expected = "Added";
			assertEquals(expected, addCart);
		}

		@Test
		public void testDeleteCart() {
			String deleteCartItem = admin.deleteCartItem(1);
			String expected = "Deleted";
			assertEquals(expected, deleteCartItem);
		}
	}

}
