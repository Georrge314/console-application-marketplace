package controller;

import dialog.UserLoginDialog;
import dialog.UserRegisterDialog;
import dialog.dto.UserLoginDto;
import dialog.dto.UserRegisterDto;
import menu.Menu;
import menu.Option;

import java.util.ArrayList;
import java.util.List;

public class InitialController {

    public void init() {
        Menu menu = new Menu("Welcome to Marketplace", new ArrayList<>(List.of(
                new Option("Register", () -> {
                    UserRegisterDto userRegisterDto = new UserRegisterDialog().input();
                    System.out.println(userRegisterDto);
                    return "";
                }),
                new Option("Login", () -> {
                    UserLoginDto userLoginDto = new UserLoginDialog().input();
                    System.out.println(userLoginDto);
                    return "";
                }),
                new Option("Skip Login/Register", () -> {
                    return "";
                })
        )));
        menu.show();
    }
}
