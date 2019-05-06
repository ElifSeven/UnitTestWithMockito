package service;

import exceptions.UserNotFoundException;
import model.User;

public interface IUserService {
	
	boolean authenticate(User user) throws UserNotFoundException;

}
