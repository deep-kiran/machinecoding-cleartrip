package models;

public class GoogleInterface extends InterfaceDevice{

    @Override
    public boolean isValidCommand(String command) {
        return command.equals(Constants.GOOGLE_COMMAND);
    }

    @Override
    public void execute(String command) {

    }
}
