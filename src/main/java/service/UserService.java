package service;


import dialog.dto.UserRegisterDto;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.User;
import model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    User createUser(UserServiceModel model) throws InvalidEntityException;
    User getUserByUsernameAndPassword(String username, String password) throws EntityNotFoundException;
    List<User> getAll();
    User getByUsername(String username) throws EntityNotFoundException;
}
