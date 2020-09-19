package com.cognizant;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.json.JSONException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.web.util.UriComponentsBuilder;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = EComDatabaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EComDatabaseApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Nested
	class BeforeTests
	{
		
		private String createURLWithPort(String uri) {
			return "http://localhost:" + port + uri;

		}

		@Test
		public void getMenuAdminTest() throws JSONException {
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);

			ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/database/all"), HttpMethod.GET,
					entity, String.class);

			String expected ="[{\"id\":1,\"pic\":\"shoes.pic\",\"name\":\"Nike\",\"price\":2300.0,\"active\":true,\"category\":\"Shoes\",\"freedelivery\":true},{\"id\":2,\"pic\":\"mobile.pic\",\"name\":\"Iphone\",\"price\":12300.0,\"active\":true,\"category\":\"Mobiles\",\"freedelivery\":true},{\"id\":3,\"pic\":\"tv.pic\",\"name\":\"Sony\",\"price\":21300.0,\"active\":true,\"category\":\"TV\",\"freedelivery\":false},{\"id\":4,\"pic\":\"watch.pic\",\"name\":\"Rolex\",\"price\":6300.0,\"active\":true,\"category\":\"Watch\",\"freedelivery\":false},{\"id\":5,\"pic\":\"perfume.pic\",\"name\":\"Van Se Trio\",\"price\":3300.0,\"active\":false,\"category\":\"Perfumes\",\"freedelivery\":true}]";
			JSONAssert.assertEquals(expected.toString(), response.getBody().toString(), false);

		}
		
		@Test
		public void getMenuCustomerTest() throws Exception
		{
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);

			ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/database/allitems"), HttpMethod.GET,
					entity, String.class);

			String expected ="[{\"id\":1,\"pic\":\"shoes.pic\",\"name\":\"Nike\",\"price\":2300.0,\"active\":true,\"category\":\"Shoes\",\"freedelivery\":true},{\"id\":2,\"pic\":\"mobile.pic\",\"name\":\"Iphone\",\"price\":12300.0,\"active\":true,\"category\":\"Mobiles\",\"freedelivery\":true},{\"id\":3,\"pic\":\"tv.pic\",\"name\":\"Sony\",\"price\":21300.0,\"active\":true,\"category\":\"TV\",\"freedelivery\":false},{\"id\":4,\"pic\":\"watch.pic\",\"name\":\"Rolex\",\"price\":6300.0,\"active\":true,\"category\":\"Watch\",\"freedelivery\":false}]";
			JSONAssert.assertEquals(expected.toString(), response.getBody().toString(), false);
		}
		
		@Test
		public void getAllCartItemsItems() throws Exception
		{
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("cart/all").queryParam("userid", "user").build().toUri();
			ResponseEntity<String> actual = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			
			String expected = "[{\"pkey\":1,\"userid\":\"user\",\"id\":1},{\"pkey\":2,\"userid\":\"user\",\"id\":2}]";

			JSONAssert.assertEquals(expected, actual.getBody(), false);

		}
	}
	
	@Nested
	class LastTests
	{
		@Test
		public void getMenuDeleteTest() throws Exception {
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("database/delete").queryParam("id", 3).build().toUri();

			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			assertEquals(exchange.getStatusCodeValue(), 200);

		}
		
		@Test
		public void getAdminAddMenuTest() throws Exception
		{
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("database/add").queryParam("pic", "bag.pic").queryParam("name","WildCraft").queryParam("price", 4000).queryParam("active", true).queryParam("category", "bag").queryParam("freedelivery", true).build().toUri();

			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			assertEquals(exchange.getStatusCodeValue(), 200);

		}
		
		
		@Test
		public void getAdminEditMenuTest() throws Exception
		{
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("database/edit").queryParam("id", "1").queryParam("pic", "flipkart.pic").queryParam("name","WildCraft").queryParam("price", 4000).queryParam("active", true).queryParam("category", "bag").queryParam("freedelivery", true).build().toUri();

			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			assertEquals(exchange.getStatusCodeValue(), 200);

		}
		
		@Test
		public void getAddCartTest() throws Exception
		{
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("cart/add").queryParam("id", 4).build().toUri();

			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			assertEquals(exchange.getStatusCodeValue(), 200);

		}
		
		
		
		
		@Test
		public void getCartDeleteTest() throws Exception {
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			String url = "http://localhost:" + port;
			URI uri = UriComponentsBuilder.fromHttpUrl(url).path("cart/delete").queryParam("id", 2).build().toUri();

			ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			assertEquals(exchange.getStatusCodeValue(), 200);

		}
	}




	
}
