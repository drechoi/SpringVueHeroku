package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private Backer owner;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Backer> backers;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Participant> participants;
}
