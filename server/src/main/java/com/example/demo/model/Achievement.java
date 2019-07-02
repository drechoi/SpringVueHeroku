package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Achievement {
	@Id
	private long id;
	
	private Date timestamp;
	private int type;
	private int rewardPoint;
	
	@ManyToOne
	private Backer backedBy;
	
}
