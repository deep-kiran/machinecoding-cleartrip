package models;

public class DefaultDeviceInterface extends InterfaceDevice {
    @Override
    public boolean isValidCommand(String command) {
        return true;
    }

    @Override
    public void execute(String command) {

    }
}
