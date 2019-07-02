package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TaskMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private int taskType;
	
	@ManyToOne
	private Scheme scheme;
	
	@ManyToOne
	private Backer createdBy;
	
	private int rewards;
	
	// TODO: expiry later
}
