package service.impl;

import dao.UserRepository;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;
import model.service.UserServiceModel;
import service.UserService;

import java.util.List;

import static util.ObjectMapper.*;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(UserServiceModel serviceModel) throws InvalidEntityException {
        var user = MODEL_MAPPER.map(serviceModel, User.class);
        return userRepo.createUser(user);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws EntityNotFoundException {
        return userRepo.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getByUsername(String username) throws EntityNotFoundException {
        return userRepo.findByUsername(username);
    }
}
