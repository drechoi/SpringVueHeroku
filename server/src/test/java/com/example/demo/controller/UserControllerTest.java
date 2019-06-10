package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void testFindOneByValidExtId(){
        String extId  = "test-ext-id-01";
        User expectedUser = User.builder().id(1).extId(extId).build();

        User user = userController.findUserByExternalId(extId);
        assertThat(user, is(expectedUser));
    }

    @Test
    public void testFindOneByInvalidExtId(){
        String extId  = "any non exists id";
//        User expectedUser = null;
        User user = userController.findUserByExternalId(extId);
        assertThat(user, is(nullValue()));
    }

    @Test
	public void testCreateNewUser(){
    	String extId = "new-ext-id";

	    User nonExistsUser = userController.findUserByExternalId(extId);
	    assertThat(nonExistsUser, is(nullValue()));

	    // create a new user
    	User newUser = User.builder().extId("new-ext-id").build();
	    userController.createUser(newUser);

	    User createResult  = userController.findUserByExternalId(extId);
	    System.out.println(createResult);
	    System.out.println(newUser);
	    assertThat(createResult, is(newUser));
    }


}
