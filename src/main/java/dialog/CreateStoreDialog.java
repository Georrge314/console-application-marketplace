package dialog;

import dialog.dto.StoreCreateDto;
import util.ConsoleReader;
import util.StringValidator;

import static util.StringValidator.*;

public class CreateStoreDialog {
    public static final int MIN_STORE_NAME_LENGTH = 2;
    public static final int MAX_STORE_NAME_LENGTH = 120;
    public static final int MIN_STORE_DESC_LENGTH = 10;
    public static final int MAX_STORE_DESC_LENGTH = 500;
    public static final int MIN_STORE_ADDRESS_LENGTH = 3;
    public static final int MAX_STORE_ADDRESS_LENGTH = 50;

    public StoreCreateDto input() {
        StoreCreateDto dto = new StoreCreateDto();
        while (dto.getName() == null) {
            System.out.println("Enter store name:");
            String answer = ConsoleReader.readLine();
            if (answer.length() >= MIN_STORE_NAME_LENGTH && answer.length() <= MAX_STORE_NAME_LENGTH) {
                dto.setName(answer);
            } else {
                System.out.printf("Store name must be between %s and %s symbols long%n",
                        MIN_STORE_NAME_LENGTH, MAX_STORE_NAME_LENGTH);
            }
        }
        while (dto.getDescription() == null) {
            System.out.println("Enter description:");
            String answer = ConsoleReader.readLine();
            if (answer.length() >= MIN_STORE_DESC_LENGTH && answer.length() <= MAX_STORE_DESC_LENGTH) {
                dto.setDescription(answer);
            } else {
                System.out.printf("Store description must be between %s and %s symbols long%n",
                        MIN_STORE_DESC_LENGTH, MAX_STORE_DESC_LENGTH);
            }
        }
        while (dto.getAddress() == null) {
            System.out.println("Enter store address:");
            String answer = ConsoleReader.readLine();
            if (answer.length() >= MIN_STORE_ADDRESS_LENGTH && answer.length() <= MAX_STORE_ADDRESS_LENGTH) {
                dto.setAddress(answer);
            } else {
                System.out.printf("Store address must be between %s and %s symbols long",
                        MIN_STORE_ADDRESS_LENGTH, MAX_STORE_ADDRESS_LENGTH);
            }
        }
        while (dto.getPicture() == null) {
            System.out.println("Enter store picture url:");
            String answer = ConsoleReader.readLine();
            if (isValidPictureUrl(answer)) {
                dto.setPicture(answer);
            } else {
                System.out.println("Invalid picture url");
            }
        }
        return dto;
    }
}
