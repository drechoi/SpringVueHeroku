package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class WishItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	@ManyToOne
	private Joiner createdBy;
	private Date createdDate;
	
	private int suggestedPrice;
	private int assignedPrice;
	
	@ManyToOne
	private Backer priceAssignedBy;
}
