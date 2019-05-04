package service;

import entity.User;
import exceptions.UserNotFoundException;

public interface IUserService {
	
	boolean authenticate(User user) throws UserNotFoundException;

}
