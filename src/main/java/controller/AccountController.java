package controller;

import menu.Menu;
import menu.Option;
import model.User;
import service.UserService;
import system.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    public void init() {
        Menu menu = new Menu("Account Menu", new ArrayList<>(List.of(
                new Option("Show Account Information", () -> {
                    User user = SystemUser.getUser();
                    return user.toString();
                }),
                new Option("Edit Account", () -> {
                    return "";
                }),
                new Option("Delete Account", () -> {
                    return "";
                })
        )));
        menu.show();
    }
}
