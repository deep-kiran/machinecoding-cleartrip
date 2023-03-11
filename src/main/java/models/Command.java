package models;

public interface Command {

    public boolean isValidCommand(String command);
    public void execute(String command);
}
