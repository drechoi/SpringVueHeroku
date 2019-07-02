package com.example.demo.acceptance;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.model.AppUser;
import com.example.demo.service.LoginService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserLoginTest extends AcceptanceTestBase {
	@Autowired
	LoginService loginService;

	
	private static final String API_LOGIN = "/user/login";
	private static final String API_LOGOUT = "/user/logout";
	
	@Test
	public void pingShouldReturnAlive(){
		String apiUrl = "/demo/ping";
		String pingMessage = getApi(apiUrl, String.class);
		String expectedPingMessage = "this is ping";
		assertThat(pingMessage, is(expectedPingMessage));
	}
	
	@Test
	public void userAbleToRegister() throws Exception{
		String token = "dummy-token-000001";
		String extId = "test-new-ext-id";
		Date expiry = new Date();
		expiry.setTime(expiry.getTime() + 5000);
		AppUser user = AppUser.builder()
				.extId(extId)
				.userName("testing-user-01")
				.loginToken(token)
				.loginTokenExpiry(expiry)
				.build();
		
		
		ResponseEntity<Boolean> loginResult = postApi(API_LOGIN, user, Boolean.class);
		assertThat(loginResult.getStatusCode(), is(HttpStatus.OK));
		boolean expectedResult = true;
		assertThat(loginResult.getBody(), is(expectedResult));
		
		boolean isLoggedIn = loginService.isUserLoggedIn(extId);
		assertThat(isLoggedIn, is(true));
		
		boolean authResult = loginService.isAuthenticated(token);
		assertThat(authResult, is(true));
	}
	
	@Test
	public void userAbleToLogin() throws Exception{
		String token = "dummy-token-000002";
		Date expiry = new Date();
		expiry.setTime(expiry.getTime() + 5000);
		String extId = ("test-ext-id-01");
		
		AppUser user = AppUser.builder()
				.extId(extId)
				.userName("testing-user-02")
				.loginToken(token)
				.loginTokenExpiry(expiry)
				.build();
		ResponseEntity<Boolean> loginResult = postApi(API_LOGIN, user, Boolean.class);
		assertThat(loginResult.getStatusCode(), is(HttpStatus.OK));
		boolean expectedResult = true;
		assertThat(loginResult.getBody(), is(expectedResult));
		
		boolean isLoggedIn = loginService.isUserLoggedIn(extId);
		assertThat(isLoggedIn, is(true));

		boolean authResult = loginService.isAuthenticated(token);
		assertThat(authResult, is(true));
	}
	
	@Test
	public void userAbleToRenewToken(){
		assert(false);
	}
	
	@Test
	public void userAbleToLogout() throws Exception{
		String extId = "test-ext-id-01";
		AppUser user = AppUser.builder()
				.extId(extId)
				.userName("testing-user-02")
				.build();
		ResponseEntity<Boolean> loginResult = postApi(API_LOGOUT, user, Boolean.class);
		assertThat(loginResult.getStatusCode(), is(HttpStatus.OK));
		
		boolean isLoggedIn = loginService.isUserLoggedIn(extId);
		assertThat(isLoggedIn, is(false));
	}
}
