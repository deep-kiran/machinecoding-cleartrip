package factory;

import models.InterfaceDevice;
import enums.InterfaceTypes;

public class InterfaceFactory {
    public static InterfaceDevice getInterfaceDevice(String interfaceName){
        return InterfaceTypes.getConstructor(interfaceName).get();
    }
}
