package com.cognizant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Menu {

	private int id;
	private String pic;
	private String name;
	private float price;
	private boolean active;
	private String category;
	private boolean freedelivery;

	public Menu(String pic, String name, float price, boolean active, String category, boolean freedelivery) {
		super();
		this.pic = pic;
		this.name = name;
		this.price = price;
		this.active = active;
		this.setCategory(category);
		this.freedelivery = freedelivery;
	}


}
