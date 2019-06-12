package com.example.demo.model;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper=true)
public class Backer extends AppUser{
}
