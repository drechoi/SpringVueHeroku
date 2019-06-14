package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Scheme;
import com.example.demo.model.dto.UserInfoDTO;
import com.example.demo.repository.SchemeRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public AppUser getOrCreateAppUser(AppUser appuser){
		Optional<AppUser> serverRecord = userRepository.findByExtId(appuser.getExtId());
		if(serverRecord.isPresent()){
			return serverRecord.get();
		} else {
			return userRepository.save(appuser);
		}
	}
	
	
	
	
	public UserInfoDTO getUserInfoDTOFromUser(AppUser user){
		UserInfoDTO userDto = modelMapper.map(user, UserInfoDTO.class);
		
		List<Scheme> backedSchemes = schemeRepository.findAllByBackersId(user.getId());
		List<Scheme> joinedSchemes = schemeRepository.findAllByJoinersId(user.getId());
		
		userDto.setBackedSchemes(backedSchemes);
		userDto.setJoinedSchemes(joinedSchemes);
		
		
		System.out.println("Convert user to DTO");
		System.out.println(user);		
		System.out.println(userDto);
		return userDto;
	}
}
