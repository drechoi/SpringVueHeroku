package com.example.demo.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Scheme;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SchemeRepositoryTest {
	@Autowired
	SchemeRepository schemeRepository;
	
	@Autowired
	UserRepository UserRepository;
		
	@Test
	public void testRepository_testFindAllByOwner(){
		List<Scheme> schemes1 = schemeRepository.findAllByOwnerId(1L);
		List<Scheme> schemes2 = schemeRepository.findAllByOwnerId(2L);
		
		assertThat(schemes1.size(), is(1));
		assertThat(schemes1.get(0).getId(), is(1L));
		
		assertThat(schemes2.size(), is(1));
		assertThat(schemes2.get(0).getId(), is(2L));
	}
	
	@Test
	public void testRepository_testFindAllByBacker(){
		List<Scheme> schemes1 = schemeRepository.findAllByBackersId(1L);
		assertThat(schemes1.size(), is(1));
		assertThat(schemes1.get(0).getId(), is(1L));

		List<Scheme> schemes2 = schemeRepository.findAllByBackersId(2L);
		assertThat(schemes2.size(), is(1));
		assertThat(schemes2.get(0).getId(), is(2L));
	}	
	
	@Test
	public void testRepository_testFindAllByJoinerId(){
		List<Scheme> schemes1 = schemeRepository.findAllByJoinersId(3L);
		assertThat(schemes1.size(), is(1));
		assertThat(schemes1.get(0).getId(), is(1L));

		List<Scheme> schemes2 = schemeRepository.findAllByJoinersId(4L);
		assertThat(schemes2.size(), is(1));
		assertThat(schemes2.get(0).getId(), is(1L));		
	}
	
}
