package com.example.demo.service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.exception.AppException;
import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {
	Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean loginOrRegister(AppUser appUser, String token, Date expiry ) throws AppException {
		logger.info("--- Begin loginOrRegister ---");
		String extId = appUser.getExtId();
		if(StringUtils.isEmpty(extId)) throw new AppException("External ID missing");
		// find user
		Optional<AppUser> foundUser = userRepository.findByExtId(extId);
		
		if (foundUser.isPresent()){
			logger.info("Login existing user");
			// login
			login(foundUser.get().getId(), token, expiry);
		} else {
			logger.info("Register user");
			// register and login
			AppUser registeredUser = register(appUser);
			login(registeredUser.getId(), token, expiry);
		}
		logger.info("--- End loginOrRegister ---");
		return true;
	}
	
	private AppUser register(AppUser user) throws AppException {
		if(verifyUser(user)){
			return userRepository.save(user);	
		}
		
		throw new AppException("invalid user info");
	}
	
	private boolean verifyUser(AppUser user){
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
		if(violations.size() != 0){
			logger.info("Invalid User: " + violations);
		}
		
		return violations.size() == 0;
	}
	
	public void login(long appUserId, String token, Date expiry){
		userRepository.updateLoginToken(appUserId, token, expiry);
	}
	
	public void renewToken(long appUserId, String newToken, Date expiry){
		userRepository.updateLoginToken(appUserId, newToken, expiry);
	}
	
	public void logout(long appUserId){
		userRepository.updateLoginToken(appUserId, null, null);
	}
	
	//public boolean isAuthenticated(long appUserId, String token){
	
	
	public boolean isAuthenticated(String token){
		Optional<AppUser> appUser = userRepository.findByLoginToken(token);
		
		if(appUser.isPresent()){
			return appUser.get().getLoginToken() != null &&
					appUser.get().getLoginTokenExpiry() != null && 
					token.equals(appUser.get().getLoginToken()) &&
					new Date().before(appUser.get().getLoginTokenExpiry());					
		}
		
		return false;
	}

	public boolean isUserLoggedIn(String extId) {
		Optional<AppUser> appUser = userRepository.findByExtId(extId);

		return appUser.isPresent() 
				&& appUser.get().getLoginToken() != null
				&& appUser.get().getLoginTokenExpiry() != null
				&& new Date().before(appUser.get().getLoginTokenExpiry());
	}	

}
