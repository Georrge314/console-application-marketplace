package menu;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private class ExitCommand implements Command {
        @Override
        public String execute() {
            return String.format("Exiting menu '%s'.", Menu.this.title);
        }
    }

    private final String title;
    private final List<Option> options;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(String title, List<Option> options) {
        this.title = title;
        this.options = options;
        this.options.add(new Option("Exit", new ExitCommand()));
    }

    public void show() {
        while (true) {
            System.out.printf("\nMenu: %s%n", title);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%2d. %s%n", i + 1, options.get(i).getText());
            }
            int choice = -1;
            do {
                System.out.printf("Enter your choice (1 - %s):", options.size());
                var choiceStr = scanner.nextLine();
                try {
                    choice = Integer.parseInt(choiceStr);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Invalid choice. Please enter a valid number between 1 and " + options.size());
                }
            } while (choice < 1 || choice > options.size());
            String result;
            try {
                result = options.get(choice - 1).getCommand().execute();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if (!result.isBlank()) {
                System.out.println(result);
            }
            if (choice == options.size() || result.equals("You are logged out.")) { // Exit command chosen
                break;
            }
        }
    }
}
