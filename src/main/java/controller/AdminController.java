package controller;

import dialog.TypeUsernameDialog;
import exception.EntityNotFoundException;
import menu.Menu;
import menu.Option;
import model.User;
import service.UserService;

import java.util.List;

public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    public void init() {
        Menu menu = new Menu("Admin Menu", List.of(
                new Option("Get All Users", () -> {
                    userService.getAll().forEach(System.out::println);
                    return "";
                }),
                new Option("Manage User", () -> {
                    System.out.println("Enter username");
                    String username = new TypeUsernameDialog().input();
                    try {
                        User user = userService.getByUsername(username);
                        new ManageUserController(user, userService).init();
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    return "";
                })
        ));
        menu.show();
    }
}
