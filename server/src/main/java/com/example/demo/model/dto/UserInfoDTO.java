package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.model.Scheme;

import lombok.Data;

@Data
public class UserInfoDTO {
	private Long id;
    private String extId;

    private String userName;
    private String picture;
    
	private List<Scheme> backedSchemes;
	private List<Scheme> joinedSchemes;
}
