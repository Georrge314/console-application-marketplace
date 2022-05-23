package dialog;

import util.ConsoleReader;

public class TypeStoreNameDialog {
    public String input() {
        String storeName = "";
        while (storeName.isBlank()) {
            System.out.println("Enter store name:");
            String answer = ConsoleReader.readLine();
            if (answer.length() >= 2 && answer.length() <= 120) {
                storeName = answer;
            } else {
                System.out.printf("Store name must be between %s and %s symbols long%n", 2, 120);
            }
        }
        return storeName;
    }
}
