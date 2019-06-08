package com.example.demo.controller;

import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

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
        assertThat(user, is(equalTo(expectedUser)));
    }

    @Test
    public void testFindOneByInvalidExtId(){
        String extId  = "any non exists id";
//        User expectedUser = null;
        User user = userController.findUserByExternalId(extId);
        assertThat(user, is(equalTo(null)));
    }

    @Test
	public void testCreateNewUser(){
    	String extId = "new-ext-id";

	    User nonExistsUser = userController.findUserByExternalId(extId);
	    assertThat(nonExistsUser, is(equalTo(null)));

	    // create a new user
    	User newUser = User.builder().extId("new-ext-id").build();
	    userController.createUser(newUser);

	    User createResult  = userController.findUserByExternalId(extId);
	    System.out.println(createResult);
	    System.out.println(newUser);
	    assertThat(createResult, is(equalTo(newUser)));
    }


}
