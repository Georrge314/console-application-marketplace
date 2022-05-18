package dialog;

import dialog.dto.UserRegisterDto;

import java.util.Scanner;

import static dialog.UserLoginDialog.*;
import static util.StringValidator.*;

public class UserRegisterDialog {
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 20;
    public static final String INVALID_NAME_LENGTH = "Name length must be between 2 and 20 symbols long.";
    public static final String INVALID_EMAIL = "Email '%s' is invalid.%n";
    public static final String INVALID_PICTURE_URL = "Picture with URL='%s' is invalid.%n";
    private final Scanner scanner = new Scanner(System.in);

    public UserRegisterDto input() {
        var dto = new UserRegisterDto();
        while (dto.getFirstName() == null) {
            System.out.println("Enter fist name:");
            String answer = scanner.nextLine();
            if (answer.length() < MIN_NAME_LENGTH || answer.length() > MAX_NAME_LENGTH) {
                System.out.println(INVALID_NAME_LENGTH);
            } else {
                dto.setFirstName(answer);
            }
        }
        while (dto.getLastName() == null) {
            System.out.println("Enter last name:");
            String answer = scanner.nextLine();
            if (answer.length() < MIN_NAME_LENGTH || answer.length() > MAX_NAME_LENGTH) {
                System.out.println(INVALID_NAME_LENGTH);
            } else {
                dto.setLastName(answer);
            }
        }
        while (dto.getUsername() == null) {
            System.out.println("Enter username:");
            String answer = scanner.nextLine();
            if (answer.length() < MIN_USER_LENGTH || answer.length() > MAX_USER_LENGTH) {
                System.out.println(INVALID_LENGTH);
            } else {
                dto.setUsername(answer);
            }
        }
        while (dto.getEmail() == null) {
            System.out.println("Enter email:");
            String answer = scanner.nextLine();
            if (!isValidEmail(answer)) {
                System.out.printf(INVALID_EMAIL, answer);
            } else {
                dto.setEmail(answer);
            }
        }
        while (dto.getPassword() == null) {
            System.out.println("Enter password:");
            String answer = scanner.nextLine();
            if (!isValidPassword(answer)) {
                System.out.println(INVALID_PASSWORD);
            } else {
                dto.setPassword(answer);
            }
        }
        while (dto.getPictureUrl() == null) {
            System.out.println("Enter picture url(press enter to skip):");
            String answer = scanner.nextLine();
            if (answer.isBlank() || answer.isEmpty()) {
                break;
            }
            if (!isValidPictureUrl(answer)) {
                System.out.printf(INVALID_PICTURE_URL, answer);
            } else {
                dto.setPictureUrl(answer);
            }
        }
        return dto;
    }
}
