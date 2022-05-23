package dialog;

import dialog.dto.UserRegisterDto;
import util.ConsoleReader;

import java.util.Scanner;

import static dialog.UserLoginDialog.*;
import static dialog.UserLoginDialog.INVALID_PASSWORD;
import static dialog.UserRegisterDialog.*;
import static util.StringValidator.*;

public class UserEditDialog {
    public UserRegisterDto input() {
        UserRegisterDto dto = new UserRegisterDto();

        while (dto.getFirstName() == null) {
            System.out.println("Enter fist name(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() < MIN_NAME_LENGTH || answer.length() > MAX_NAME_LENGTH) {
                System.out.println(INVALID_NAME_LENGTH);
            } else {
                dto.setFirstName(answer);
            }
        }
        while (dto.getLastName() == null) {
            System.out.println("Enter last name(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() < MIN_NAME_LENGTH || answer.length() > MAX_NAME_LENGTH) {
                System.out.println(INVALID_NAME_LENGTH);
            } else {
                dto.setLastName(answer);
            }
        }
        while (dto.getUsername() == null) {
            System.out.println("Enter username(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() < MIN_USER_LENGTH || answer.length() > MAX_USER_LENGTH) {
                System.out.println(INVALID_LENGTH);
            } else {
                dto.setUsername(answer);
            }
        }
        while (dto.getEmail() == null) {
            System.out.println("Enter email(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (!isValidEmail(answer)) {
                System.out.printf(INVALID_EMAIL, answer);
            } else {
                dto.setEmail(answer);
            }
        }
        while (dto.getPassword() == null) {
            System.out.println("Enter password(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (!isValidPassword(answer)) {
                System.out.println(INVALID_PASSWORD);
            } else {
                dto.setPassword(answer);
            }
        }
        while (dto.getPictureUrl() == null) {
            System.out.println("Enter picture url(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
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
