package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.exception.AppException;
import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;
    
//    @Test
//    public void testFindOneByValidExtId(){
//        String extId  = "test-ext-id-02";
//        // AppUser expectedUser = AppUser.builder().extId(extId).build();
//
//        AppUser user = userRepository.findByExtId(extId).orElse(null);
//        assertThat(user.getExtId(), is(extId));
//    }
//
//    @Test
//    public void testFindOneByInvalidExtId(){
//        String extId  = "any non exists id";
////        User expectedUser = null;
//        AppUser user = userRepository.findByExtId(extId).orElse(null);
//        assertThat(user, is(nullValue()));
//    }

    @Test
	public void testLoginNewUser() throws AppException{
    	String extId = "new-ext-id";

    	// check user is not exists
	    AppUser nonExistsUser = userRepository.findByExtId(extId).orElse(null);
	    assertThat(nonExistsUser, is(nullValue()));

	    // create a new user
    	AppUser newUser = AppUser.builder().extId("new-ext-id").build();
	    // UserInfoDTO userInfo = userController.login(newUser);
    	boolean loginResult = userController.login(newUser);

	    // user can now be found in repository
	    AppUser createResult  = userRepository.findByExtId(extId).orElse(null);
	    System.out.println(createResult);
	    System.out.println(newUser);
	    assertThat(createResult, is(newUser));
	    
	    // System.out.println(userInfo);
//	    assertThat(userInfo, is(newUser));
    }


    @Test
	public void testLoginExistingUser() throws AppException{
    	String extId = "test-ext-id-02";

	    // create a new user
    	AppUser newUser = AppUser.builder().extId(extId).build();
	    // UserInfoDTO userInfo = userController.login(newUser);
    	boolean loginResult = userController.login(newUser);

	    
	    System.out.println("output user info");
//	    System.out.println(userInfo);
//	    assertThat(userInfo, is(newUser));
    }
}
