package dialog;

import java.util.Scanner;

import static dialog.UserLoginDialog.*;

public class TypeUsernameDialog {
    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        String username = "";
        while (username.isBlank()) {
            System.out.println("Enter username:");
            String answer = scanner.nextLine();
            if (answer.length() >= MIN_USER_LENGTH && answer.length() <= MAX_USER_LENGTH) {
                username = answer;
            }
        }
        return username;
    }
}
