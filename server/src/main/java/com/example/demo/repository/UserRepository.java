package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByLoginToken(String loginToken);
    Optional<AppUser> findByExtId(String extId);
 
    List<AppUser> findByUserNameContaining(String userName);
    
    @Modifying
    @Transactional
    @Query("UPDATE AppUser u SET u.loginToken = :loginToken, u.loginTokenExpiry = :tokenExpiry where u.id = :userId")
    int updateLoginToken(@Param("userId") long userId, @Param("loginToken") String loginToken, @Param("tokenExpiry") Date tokenExpiry );
}
