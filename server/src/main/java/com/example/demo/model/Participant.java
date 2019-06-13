package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Participant extends AppUser{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	private AppUser appUser;

	@ManyToOne
	private Scheme participatedScheme;
}
