package controller;

import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import service.IUserService;

public class TestLoginController {
	@Mock
	private IUserService userService;
	
	@InjectMocks
	private LoginController loginController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
//	@Test
//	public void testAuthenticate() throws Exception {
//		final User userStub = new User();
//		userStub.setUsername("elif");
//		userStub.setPassword("password");
//		
//		Mockito.when(userService.authenticate(userStub)).
//		
//		
//	}

}
