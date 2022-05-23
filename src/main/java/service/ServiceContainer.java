package service;

import dao.StoreRepository;
import dao.UserRepository;
import service.impl.StoreServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceContainer {
    private static UserService userService;
    private static StoreService storeService;

    public static void createUserService(UserRepository userRepository) {
        userService = new UserServiceImpl(userRepository);
    }

    public static UserService getUserService() {
        return userService;
    }

    public static void createStoreService(StoreRepository storeRepository) {
        storeService = new StoreServiceImpl(storeRepository);
    }

    public static StoreService getStoreService() {
        return storeService;
    }
}
