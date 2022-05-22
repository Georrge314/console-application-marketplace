package dao;

import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user) throws InvalidEntityException;
    User findUserByUsernameAndPassword(String username, String password) throws EntityNotFoundException;

    List<User> findAll();
    User findByUsername(String username) throws EntityNotFoundException;
}
