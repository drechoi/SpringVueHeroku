package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
//@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true, exclude = {"backedScheme"})
public class Backer extends AppUser{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private AppUser appUser;
	private boolean isOwner;

	@ManyToOne(fetch = FetchType.LAZY)
	private Scheme backedScheme;
}
