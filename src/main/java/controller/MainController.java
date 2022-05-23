package controller;

import menu.Menu;
import menu.Option;
import service.ServiceContainer;
import system.SystemUser;

import java.util.ArrayList;
import java.util.List;
public class MainController {
    public void init() {
        List<Option> options = new ArrayList<>(List.of(
                new Option("Stores", () -> {
                    new StoreController(ServiceContainer.getStoreService()).init();
                    return "";
                }),
                new Option("Categories", () -> {
                    return "";
                }),
                new Option("Products", () -> {
                    return "";
                }),
                new Option("Users", () -> {
                    return "";
                }),
                new Option("About", () -> {
                    return "System information";
                })
        ));
        if (SystemUser.isLoggedIn()) {
            //TODO add other options
            options.add(
                    new Option("Account", () -> {
                        new AccountController(ServiceContainer.getUserService()).init();
                        return "";
            }));

            if (SystemUser.isAdmin()) {
                options.add(new Option("Admin Menu", () -> {
                    new AdminController(ServiceContainer.getUserService()).init();
                    return "";
                }));
            }
        }

        Menu menu = new Menu("Main Menu", options);
        menu.show();
    }
}
