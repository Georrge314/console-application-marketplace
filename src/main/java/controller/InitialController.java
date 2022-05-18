package controller;

import dialog.UserLoginDialog;
import dialog.dto.UserLoginDto;
import menu.Menu;
import menu.Option;

import java.util.ArrayList;
import java.util.List;

public class InitialController {

    public void init() {
        Menu menu = new Menu("Welcome to Marketplace", new ArrayList<>(List.of(
                new Option("Register", () -> {
                   return "";
                }),
                new Option("Login", () -> {
                    UserLoginDto userLoginDto = new UserLoginDialog().input();
                    System.out.println(userLoginDto.getUsername());
                    System.out.println(userLoginDto.getPassword());
                    return "";
                }),
                new Option("Skip Login/Register", () -> {
                    return "";
                })
        )));
        menu.show();
    }
}
