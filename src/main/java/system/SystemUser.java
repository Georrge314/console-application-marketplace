package system;

import model.User;

public class SystemUser {
    private static User user;

    public static boolean isLoggedIn() {
        return user != null;
    }

    public static void loggIn(User user) {
        SystemUser.user = user;
    }

    public static void loggOut() {
        user = null;
    }

    public static boolean isAdmin() {
        if (user != null) {
            return user.isAdmin();
        }
        return false;
    }

    public static User getUser() {
        return user;
    }
}
