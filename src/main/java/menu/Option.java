package menu;

public class Option {
    private final String text;
    private final Command command;

    public Option(String text, Command command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public Command getCommand() {
        return command;
    }
}
