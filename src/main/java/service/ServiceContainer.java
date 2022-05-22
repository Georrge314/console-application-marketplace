package service;

import dao.UserRepository;
import service.impl.UserServiceImpl;

public class ServiceContainer {
    private static UserService userService;

    public static void createUserService(UserRepository userRepository) {
        userService = new UserServiceImpl(userRepository);
    }

    public static UserService getUserService() {
        return userService;
    }
}
