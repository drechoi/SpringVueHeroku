package com.example.demo.controller;

import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        User expectedUser = new User(1, extId);

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
}
