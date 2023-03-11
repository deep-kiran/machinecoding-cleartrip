package enums;

import lombok.RequiredArgsConstructor;
import models.AlexaInterface;
import models.DefaultDeviceInterface;
import models.GoogleInterface;
import models.InterfaceDevice;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum InterfaceTypes {
    ALEXA(AlexaInterface::new ,"ALEXA"),
    GOOGLE(GoogleInterface:: new, "OK GOOGLE");


    private InterfaceTypes(Supplier<InterfaceDevice> smartHome, String triggerWord){
        this.constructor = smartHome;
        this.triggerWord = triggerWord;
    }
    public Supplier<InterfaceDevice> constructor;
    public String triggerWord;

    public String getTriggerWord() {
        return triggerWord;
    }

    public static Supplier<InterfaceDevice> getConstructor(String triggerWord){
        for(InterfaceTypes interfaceTypes : InterfaceTypes.values()){
            if(interfaceTypes.getTriggerWord().equalsIgnoreCase(triggerWord)){
                return interfaceTypes.constructor;
            }
        }
        return DefaultDeviceInterface::new;
    }

}
