package com.example.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
@Entity
//@EqualsAndHashCode(callSuper=true)
@ToString(exclude = {"backedScheme"})
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
