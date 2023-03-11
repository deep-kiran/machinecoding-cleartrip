package models;

import static models.Constants.*;

public class SmartFan extends SmartHomeDevice{
    public boolean isFanOn = false;

    public SmartFan(){
        super.name ="fan";
    }
    public int fanSpeed;
    @Override
    public boolean connectToInterface() {
        return false;
    }

    @Override
    public SmartHomeDevice getStatus() {
        return null;
    }

    @Override
    public void toggleDevice() {
        isFanOn = !isFanOn;
    }

    @Override
    public boolean isValidCommand(String command) {
        if(command.equals(Constants.TOGGLE_FAN)){
            return true;
        }else if(command.equals("Increase fan speed")){
            return isFanOn == true && fanSpeed <8 && fanSpeed>0;
        }
        return false;
    }

    @Override
    public void execute(String command) {
        if(command.equals(TOGGLE_FAN)){
            toggleDevice();
        }else if(command.equals(INCREASE_FAN_SPEED)){
            fanSpeed++;
        }else if(command.equals(DECREASE_FAN_SPEED)){
            fanSpeed--;
        }
    }
}
