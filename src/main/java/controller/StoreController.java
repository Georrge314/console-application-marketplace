package controller;

import dialog.CreateStoreDialog;
import dialog.TypeStoreNameDialog;
import dialog.dto.StoreCreateDto;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import menu.Menu;
import menu.Option;
import model.Store;
import model.service.StoreServiceModel;
import service.StoreService;
import system.SystemUser;
import util.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.ObjectMapper.*;

public class StoreController {
    private final StoreService storeService;
    private final Scanner scanner = new Scanner(System.in);

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    public void init() {
        List<Option> options = new ArrayList<>(List.of(
                new Option("Get All Stores", () -> {
                    storeService.getAll().forEach(System.out::println);
                    return "";
                }),
                new Option("Browse Store", () -> {
                    String storeName = new TypeStoreNameDialog().input();
                    try {
                        Store store = storeService.getByName(storeName);
                        new BrowseStoreController(store, storeService).input();
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    return "";
                })
        ));

        if (SystemUser.isLoggedIn()) {
            options.add(new Option("Create Store", () -> {
                StoreCreateDto dto = new CreateStoreDialog().input();
                StoreServiceModel model = MODEL_MAPPER.map(dto, StoreServiceModel.class);
                model.setAuthor(SystemUser.getUser());
                try {
                    Store created = storeService.create(model);
                    return String.format("Store with NAME:'%s' created successfully%n", created.getName());
                } catch (InvalidEntityException e) {
                    System.out.println(e.getMessage());
                }
                return "";
            }));
        }

        Menu menu = new Menu("Store Menu", options);
        menu.show();
    }
}
