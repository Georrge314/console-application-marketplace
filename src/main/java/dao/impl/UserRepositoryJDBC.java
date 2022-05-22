package dao.impl;

import dao.UserRepository;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryJDBC implements UserRepository {
    private final Map<String, User> users = new HashMap<>();
    private final Connection connection;

    public UserRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User createUser(User user) throws InvalidEntityException {
        if (users.containsKey(user.getUsername())) {
            throw new InvalidEntityException(
                    String.format("User with USERNAME:'%s' already exists", user.getUsername()));
        }
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws EntityNotFoundException {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new EntityNotFoundException(String.format("User with USERNAME:'%s' and PASSWORD:'%s' does not exists", username, password));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findByUsername(String username) throws EntityNotFoundException {
        User user = users.get(username);
        if (user != null) {
            return user;
        }
        throw new EntityNotFoundException(String.format("User with USERNAME:'%s' does not exists", username));
    }
}
