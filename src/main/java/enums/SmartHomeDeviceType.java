package enums;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import models.SmartFan;
import models.SmartHomeDevice;
import models.SmartLight;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum SmartHomeDeviceType {
    LIGHT(SmartLight::new),
    FAN(SmartFan::new);

    private SmartHomeDeviceType(Supplier<SmartHomeDevice> smartHome){
        this.constructor = smartHome;
    }

    public Supplier<SmartHomeDevice> getConstructor() {
        return constructor;
    }

    public Supplier<SmartHomeDevice> constructor;
}
