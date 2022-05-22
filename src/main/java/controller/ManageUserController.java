package controller;

import menu.Menu;
import menu.Option;
import model.User;
import service.UserService;

import java.util.List;

public class ManageUserController {
    private final User user;
    private final UserService userService;

    public ManageUserController(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    public void init() {
        Menu menu = new Menu("Manage" + user.getUsername(), List.of(
                new Option("Edit User", () -> {
                   return "";
                }),
                new Option("Delete User", () -> {
                    return "";
                })
        ));
        menu.show();
    }
}
