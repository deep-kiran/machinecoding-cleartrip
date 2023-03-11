package models;

import services.InterfaceService;

public class AlexaInterface extends InterfaceDevice {

    @Override
    public boolean isValidCommand(String command) {
        return command.equals(Constants.ALEXA_COMMAND);
    }

    @Override
    public void execute(String command) {

    }
}
