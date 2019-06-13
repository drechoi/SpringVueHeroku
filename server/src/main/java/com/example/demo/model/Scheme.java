package com.example.demo.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"backers", "participants"})
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@ManyToOne
	private AppUser owner;

	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="backedScheme")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="backedScheme")
	private Set<Backer> backers;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="participatedScheme")
	private Set<Participant> participants;
}
