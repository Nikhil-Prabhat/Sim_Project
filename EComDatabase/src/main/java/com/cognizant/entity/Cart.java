package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Cart {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int pkey;
	private String userid;
	private int id;

}
