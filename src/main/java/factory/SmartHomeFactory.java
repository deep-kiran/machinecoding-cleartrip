package factory;

import enums.SmartHomeDeviceType;
import models.SmartHomeDevice;

public class SmartHomeFactory {

    public static SmartHomeDevice getSmartHomeDevice(SmartHomeDeviceType deviceType){
        return deviceType.constructor.get();
    }
}
