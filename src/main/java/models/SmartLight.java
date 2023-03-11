package models;


import static models.Constants.CHANGE_COLOUR;
import static models.Constants.INCREASE_BRIGHTNESS;

public class SmartLight extends SmartHomeDevice{
    public int brightness =0;
    public LightColor color;
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
        this.color = LightColor.GREEN;
        this.isToggled = !this.isToggled;
    }
    @Override
    public boolean isValidCommand(String command) {
        if(command.equals(Constants.TOGGLE_LIGHTS)){
            return true;
        } else if(!this.isToggled){
            return false;
        }
        return false;
    }

    @Override
    public void execute(String command) {
        if(command.equals(Constants.TOGGLE_LIGHTS)){
            toggleDevice();
        }
        else if(command.equals(INCREASE_BRIGHTNESS)){
            brightness++;
        }else if(command.equals(CHANGE_COLOUR)){
            color = Math.random()%2==0 ? LightColor.RED : LightColor.BLUE;
        }
    }



    public enum LightColor {
        BLUE,RED,GREEN;
    }

}
