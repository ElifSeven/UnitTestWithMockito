package controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.User;
import exceptions.UserNotFoundException;
import service.IUserService;

public class LoginController implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private IUserService userService;

	public LoginController(IUserService userService) {
		this.userService = userService;
	}

	public String authenticate(final User user) {

		try {
			if (userService.authenticate(user)) {
				return "homePage";
			} else { 
				return "errorPage?message=wrongPassword";
			}

		} catch (UserNotFoundException e) {
			logger.error("User not found for username: {}", user.getUserName(),e);
			return "errorPage?message=userNotFound";

		}

	}

}
