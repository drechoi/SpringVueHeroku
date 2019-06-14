package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Joiner extends AppUser{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	private AppUser appUser;

	@ManyToOne
	private Scheme joinedScheme;
}
