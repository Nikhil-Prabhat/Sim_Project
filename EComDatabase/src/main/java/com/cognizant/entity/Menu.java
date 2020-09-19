package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Menu {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String pic;
	private String name;
	private float price;
	private boolean active;
	private String category;
	private boolean freedelivery;

	public Menu(String pic, String name, float price, boolean active,String category, boolean freedelivery) {
		super();
		this.pic = pic;
		this.name = name;
		this.price = price;
		this.active = active;
		this.setCategory(category);
		this.freedelivery = freedelivery;
	}

}
