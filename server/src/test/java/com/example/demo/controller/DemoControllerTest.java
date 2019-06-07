package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest{
    @Autowired
    DemoController demoController;

    @MockBean
    DemoRepository demoRepository;

    @Before
    public void setup(){
        when(demoRepository.findAll()).thenReturn(createDemoList());
    }

    private List<Demo> createDemoList(){
        List<Demo> expectedResult = new ArrayList<>();
        expectedResult.add(new Demo(1L, "item 1"));
        expectedResult.add(new Demo(2L, "item 2"));
        return expectedResult;
    }

    @Test
    public void testGetAll(){
        List<Demo> expectedResult = createDemoList();
        List<Demo> demos =  demoController.getAll();
        assertThat(demos, is(equalTo(expectedResult)));
    }
}