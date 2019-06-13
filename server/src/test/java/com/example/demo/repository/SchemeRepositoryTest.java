package com.example.demo.repository;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.model.Backer;
import com.example.demo.model.Participant;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.AppUser;
import com.example.demo.model.Scheme;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SchemeRepositoryTest {
	@Autowired
	SchemeRepository schemeRepository;
	
	@Autowired
	UserRepository UserRepository;
	
	private long savedSchemeId; 

	@Before
	public void setupDB() throws Exception{
//		ObjectMapper objectMapper = new ObjectMapper();
//		File f = ResourceUtils.getFile("classpath:mockData/mock_scheme_01.json");
//		Scheme scheme = objectMapper.readValue(f, Scheme.class);
//
//		Scheme result = schemeRepository.save(scheme);
//		savedSchemeId = result.getId();
	}
	
	@Test
	public void testRepository_ableToSave() throws Exception{		
		Optional<Scheme> optionalScheme = schemeRepository.findById(savedSchemeId);
		assertThat(optionalScheme.isPresent(), is(true));
		Scheme scheme = optionalScheme.get();
		assertThat(scheme, is(not(nullValue())));
		
		AppUser owner = scheme.getOwner();
		System.out.println(scheme);
		//System.out.println(owner.getId() + ": " + owner);
		System.out.println(owner);
				
		for(Backer backer: scheme.getBackers()){
			System.out.println(backer.getId() + ": " + backer);	
		}
		
		for(Participant participant : scheme.getParticipants()){
			System.out.println(participant.getId() + ": " + participant);
		}
	}
	
	@Test
	public void testRepository_testFindAllByOwner(){
		AppUser u1 = UserRepository.findById(1L).get();
		
		List<Scheme> schemes = schemeRepository.findAllByOwnerId(u1.getId());
		
		assertThat(schemes.size(), is(1));

		System.out.println(schemes);
		Scheme scheme = schemes.get(0);
	}
	
	@Test
	public void testRepository_testFindAllByBacker(){

		
	}	
	
	@Test
	public void testRepository_testFindAllByParticipants(){
		
	}
	
}
