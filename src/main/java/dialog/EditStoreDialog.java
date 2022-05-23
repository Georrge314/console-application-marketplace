package dialog;

import dialog.dto.StoreCreateDto;
import util.ConsoleReader;

import static dialog.CreateStoreDialog.*;
import static util.StringValidator.isValidPictureUrl;

public class EditStoreDialog {

    public StoreCreateDto input() {
        StoreCreateDto dto = new StoreCreateDto();
        while (dto.getName() == null) {
            System.out.println("Enter store name(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() >= MIN_STORE_NAME_LENGTH && answer.length() <= MIN_STORE_NAME_LENGTH) {
                dto.setName(answer);
            } else {
                System.out.printf("Store name must be between %s and %s symbols long%n",
                        MIN_STORE_NAME_LENGTH, MAX_STORE_NAME_LENGTH);
            }
        }
        while (dto.getDescription() == null) {
            System.out.println("Enter description(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() >= MIN_STORE_DESC_LENGTH && answer.length() <= MAX_STORE_DESC_LENGTH) {
                dto.setDescription(answer);
            } else {
                System.out.printf("Store description must be between %s and %s symbols long%n",
                        MIN_STORE_DESC_LENGTH, MAX_STORE_DESC_LENGTH);
            }
        }
        while (dto.getAddress() == null) {
            System.out.println("Enter store address(press enter to skip):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (answer.length() >= MIN_STORE_ADDRESS_LENGTH && answer.length() <= MAX_STORE_ADDRESS_LENGTH) {
                dto.setAddress(answer);
            } else {
                System.out.printf("Store address must be between %s and %s symbols long",
                        MIN_STORE_ADDRESS_LENGTH, MAX_STORE_ADDRESS_LENGTH);
            }
        }
        while (dto.getPicture() == null) {
            System.out.println("Enter store picture url(press enter to skipp):");
            String answer = ConsoleReader.readLine();
            if (answer.isBlank()) {
                break;
            }
            if (isValidPictureUrl(answer)) {
                dto.setPicture(answer);
            } else {
                System.out.println("Invalid picture url");
            }
        }
        return dto;
    }
}
