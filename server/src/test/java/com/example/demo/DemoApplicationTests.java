package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${api_prefix}")
	private String apiPrefix;

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void pingShouldReturnAlive(){
		String url = "http://localhost:" + port + "/api/demo/ping";
		String pingMessage = restTemplate.getForObject(url, String.class);
		String expectedPingMessage = "this is ping";
		assertThat(pingMessage, is(equalTo(expectedPingMessage)));
	}

	@Test
	public void everyControllerShouldIncludePrefixExceptError(){
		for(RequestMappingInfo info : handlerMapping.getHandlerMethods().keySet())
		{
		    if(!(info.getPatternsCondition().toString().equals("[/error]"))){
                assertThat(info.getPatternsCondition().toString(), is(startsWith("[" + apiPrefix)));
            }
		}
	}
}
