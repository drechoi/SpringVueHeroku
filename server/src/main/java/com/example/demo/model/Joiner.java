package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	private Integer currentScore;
	
	@OneToMany
	private List<WishItem> wishList;
	
	@OneToMany
	private List<TaskItem> taskList;
	
	@OneToMany
	private List<Achievement> achievementList;
}
