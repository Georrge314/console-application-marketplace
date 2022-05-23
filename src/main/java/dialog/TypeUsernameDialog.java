package dialog;

import util.ConsoleReader;

import java.util.Scanner;

import static dialog.UserLoginDialog.*;

public class TypeUsernameDialog {
    public String input() {
        String username = "";
        while (username.isBlank()) {
            System.out.println("Enter username:");
            String answer = ConsoleReader.readLine();
            if (answer.length() >= MIN_USER_LENGTH && answer.length() <= MAX_USER_LENGTH) {
                username = answer;
            } else {
                System.out.printf("Username must be between %s and %s symbols long%s", MIN_USER_LENGTH, MAX_USER_LENGTH);
            }
        }
        return username;
    }
}
