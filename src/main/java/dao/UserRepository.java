package dao;

import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;

public interface UserRepository {
    User createUser(User user) throws InvalidEntityException;
    User findUserByUsernameAndPassword(String username, String password) throws EntityNotFoundException;
}
