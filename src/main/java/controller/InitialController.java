package controller;

import dialog.UserLoginDialog;
import dialog.UserRegisterDialog;
import dialog.dto.UserLoginDto;
import dialog.dto.UserRegisterDto;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import menu.Menu;
import menu.Option;
import model.User;
import model.service.UserServiceModel;
import service.UserService;
import system.SystemUser;

import java.util.ArrayList;
import java.util.List;

import static util.ObjectMapper.*;

public class InitialController {
    private final UserService userService;

    public InitialController(UserService userService) {
        this.userService = userService;
    }

    public void init() {
        Menu menu = new Menu("Welcome to Marketplace", new ArrayList<>(List.of(
                new Option("Register", () -> {
                    UserRegisterDto userRegisterDto = new UserRegisterDialog().input();
                    UserServiceModel model = MODEL_MAPPER.map(userRegisterDto, UserServiceModel.class);
                    try {
                        User createdUser = userService.createUser(model);
                        SystemUser.loggIn(createdUser);
                        System.out.println("Register successfully");
                        new MainController().init();
                    } catch (InvalidEntityException e) {
                        System.out.println("Register failed");
                        System.out.println(e.getMessage());
                    }
                    return "";
                }),
                new Option("Login", () -> {
                    UserLoginDto userLoginDto = new UserLoginDialog().input();
                    try {
                        User existingUser = userService.getUserByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
                        SystemUser.loggIn(existingUser);
                        System.out.println("Login successfully");
                        new MainController().init();
                    } catch (EntityNotFoundException e) {
                        System.out.println("Login failed");
                        System.out.println(e.getMessage());
                    }
                    return "";
                }),
                new Option("Skip Login/Register", () -> {
                    SystemUser.loggOut();
                    new MainController().init();
                    return "";
                })
        )));
        menu.show();
    }
}
