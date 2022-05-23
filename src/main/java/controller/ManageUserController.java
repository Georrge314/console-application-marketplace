package controller;

import dialog.TypeUsernameDialog;
import dialog.UserEditDialog;
import dialog.dto.UserRegisterDto;
import exception.EntityNotFoundException;
import menu.Menu;
import menu.Option;
import model.User;
import model.service.UserServiceModel;
import service.UserService;

import java.util.List;

import static util.ObjectMapper.*;

public class ManageUserController {
    private User user;
    private final UserService userService;

    public ManageUserController(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    public void init() {
        Menu menu = new Menu("Manage " + user.getUsername(), List.of(
                new Option("Edit User", () -> {
                    UserRegisterDto dto = new UserEditDialog().input();
                    if (!dto.isEmpty()) {
                        UserServiceModel model = MODEL_MAPPER.map(dto, UserServiceModel.class);
                        try {
                            user = userService.updateByUsername(user.getUsername(), model);
                            System.out.printf("User with USERNAME:'%s' updated successfully", user.getUsername());
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    return "";
                }),
                new Option("Delete User", () -> {
                    //TODO should exit from this controller after delete user
                    String username = new TypeUsernameDialog().input();
                    try {
                        User deleted = userService.deleteByUsername(username);
                        System.out.printf("User with USERNAME:'%s' deleted successfully", deleted.getUsername());
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    return "";
                })
        ));
        menu.show();
    }
}
