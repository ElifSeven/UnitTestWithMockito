package controller;

import exceptions.UserNotFoundException;
import model.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.internal.verification.Times;

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

	@Test
	public void testAuthenticate() throws Exception {
		User userStub = new User();
		userStub.setUserName("elif");
		userStub.setPassword("1234");

		Mockito.when(userService.authenticate((model.User) userStub)).thenReturn(true);
		final String redirect = loginController.authenticate(userStub);
		Assert.assertEquals("homePage", redirect);
		Mockito.verify(userService, new Times(1)).authenticate(Mockito.any(User.class));

	}

	@Test
	public void testAuhtenticationForUserNotFound() throws Exception {
		User userStub = new User();
		userStub.setUserName("elif");
		userStub.setPassword("1234");

		Mockito.when(userService.authenticate(userStub)).thenThrow(UserNotFoundException.class);
		final String redirect = loginController.authenticate(userStub);
		Assert.assertEquals(redirect, "errorPage?message=userNotFound");
		Mockito.verify(userService, new Times(1)).authenticate(Mockito.any(User.class));

	}

	@Test
	public void testAuhtenticationForWrongPassword() throws Exception {

		User userStub = new User();
		userStub.setUserName("elif");
		userStub.setPassword("1234");

		Mockito.when(userService.authenticate(userStub)).thenReturn(false);
		final String redirect = loginController.authenticate(userStub);

		Assert.assertEquals(redirect, "errorPage?message=wrongPassword");
		Mockito.verify(userService, new Times(1)).authenticate(Mockito.any(User.class));

	}

}
