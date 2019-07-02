package com.example.demo.acceptance;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceTestBase {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getBaseUrl(){
		return "http://localhost:" + port + "/api";
	} 
		
	protected <T> T getApi(String apiUrl, Class<T> clazz){
		return restTemplate.getForObject(getBaseUrl() + apiUrl, clazz);	
	}
	
	protected <T> ResponseEntity<T> postApi(String apiUrl, Object request, Class<T> clazz, Object...urlVariables) throws Exception{
		try{
		    //and do I need this JSON media type for my use case?
//		    HttpHeaders headers = new HttpHeaders();
//		    headers.setContentType(MediaType.APPLICATION_JSON);
		    
		    //set my entity
		    HttpEntity<Object> entity = new HttpEntity<Object>(request);

		    
			String url = getBaseUrl() + apiUrl;
			return restTemplate.exchange(url, HttpMethod.POST, entity, clazz);	
		} catch(Exception e){
			throw e;
		}
			
	}
	
}
