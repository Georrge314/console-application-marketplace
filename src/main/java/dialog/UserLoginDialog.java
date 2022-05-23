package dialog;

import dialog.dto.UserLoginDto;
import util.ConsoleReader;
import util.StringValidator;

import java.util.Scanner;

public class UserLoginDialog {
    public static final int MIN_USER_LENGTH = 3;
    public static final int MAX_USER_LENGTH = 15;
    public static final String INVALID_LENGTH = "Username length must be between 3 and 15 symbols long.";
    public static final String INVALID_PASSWORD =
            "Password is invalid. " +
            "Password must be between 8 and 15 symbols long, " +
            "at least one digit, one capital letter, " +
            "and one sign different than letter or digit.";
    public UserLoginDto input() {
        UserLoginDto dto = new UserLoginDto();
        while (dto.getUsername() == null) {
            System.out.println("Enter username:");
            String answer = ConsoleReader.readLine();
            if (answer.length() < MIN_USER_LENGTH || answer.length() > MAX_USER_LENGTH) {
                System.out.println(INVALID_LENGTH);
            } else {
                dto.setUsername(answer);
            }
        }
        while (dto.getPassword() == null) {
            System.out.println("Enter password:");
            String answer = ConsoleReader.readLine();
            if (!StringValidator.isValidPassword(answer)) {
                System.out.println(INVALID_PASSWORD);
            } else {
                dto.setPassword(answer);
            }
        }
        return dto;
    }
}
