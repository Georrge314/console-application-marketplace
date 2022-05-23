package dao.impl;

import dao.UserRepository;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;

import java.sql.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public User updateByUsername(String username, User user) throws EntityNotFoundException {
        User existingUser = findByUsername(username);
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String userName = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        String pictureUrl = user.getPictureUrl();
        if (firstName != null) {
            existingUser.setFirstName(firstName);
        }
        if (lastName != null) {
            existingUser.setLastName(lastName);
        }
        if (userName != null) {
            existingUser.setUsername(userName);
        }
        if (email != null) {
            existingUser.setEmail(email);
        }
        if (password != null) {
            existingUser.setPassword(password);
        }
        if (pictureUrl != null) {
            existingUser.setPictureUrl(pictureUrl);
        }
        existingUser.setModified(new Timestamp(System.currentTimeMillis()));
        return existingUser;
    }

    @Override
    public User deleteByUsername(String username) throws EntityNotFoundException {
        findByUsername(username);
        return users.remove(username);
    }
}
