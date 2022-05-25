package controller;

import dialog.EditStoreDialog;
import dialog.dto.StoreCreateDto;
import exception.EntityNotFoundException;
import menu.Menu;
import menu.Option;
import model.Product;
import model.Store;
import model.service.StoreServiceModel;
import service.ProductService;
import service.StoreService;
import system.SystemUser;

import java.util.ArrayList;
import java.util.List;

import static util.ObjectMapper.*;

public class BrowseStoreController {
    private Store store;
    private final StoreService storeService;
    private final ProductService productService;

    public BrowseStoreController(Store store,
                                 StoreService storeService,
                                 ProductService productService) {
        this.store = store;
        this.storeService = storeService;
        this.productService = productService;
    }

    public void input() {
        List<Option> options = new ArrayList<>(List.of(
                new Option("Show Store Information", () -> {
                    return store.toString();
                }),
                new Option("Show Store Products", () -> {
                    List<Product> products = productService.getAllByStoreName(store.getName());
                    products.forEach(System.out::println);
                    return "";
                })
        ));
        if (SystemUser.isLoggedIn()) {
            options.add(new Option("Add Store To Favorites", () -> {
                //TODO implement adding store to favorites
                return "";
            }));
        }
        String authorUsername = store.getAuthor().getUsername();
        String username = SystemUser.getUser().getUsername();
        if (username.equals(authorUsername)) {
            options.add(new Option("Update Store", () -> {
                StoreCreateDto dto = new EditStoreDialog().input();
                if (!dto.isEmpty()) {
                    StoreServiceModel model = MODEL_MAPPER.map(dto, StoreServiceModel.class);
                    try {
                        store = storeService.update(store.getName(), model);
                        System.out.printf("Store with NAME:'%s' updated successfully", store.getName());
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                return "";
            }));
            options.add(new Option("Delete Store", () -> {
                try {
                    Store deleted = storeService.deleteByName(store.getName());
                    System.out.printf("Store with NAME:'%s' deleted successfully%n", deleted.getName());
                    return "exit";
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return "";
            }));
        }

        Menu menu = new Menu(store.getName() + " Menu", options);
        menu.show();
    }
}
