package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Backer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;
import com.example.demo.model.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long>{
	List<Scheme> findAllByOwnerId(Long ownerId);

	List<Scheme> findAllByBackers(AppUser user);

	List<Scheme> findAllByParticipants(AppUser user);
}
