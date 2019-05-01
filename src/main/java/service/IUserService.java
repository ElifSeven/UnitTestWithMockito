package service;

import entity.User;
import exceptions.UserNotFoundException;

public interface IUserService {

	boolean authenticate(final User user) throws UserNotFoundException;

}
