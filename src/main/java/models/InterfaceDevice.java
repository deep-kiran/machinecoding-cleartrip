package models;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public abstract class InterfaceDevice implements Command{
    private String interfaceName;
    private String command;
    private ArrayList<SmartHomeDevice> devicesConnected =new ArrayList<>();
    public abstract boolean isValidCommand(String command);

    public void addSmartHomeDevice(SmartHomeDevice interfaceDevice){
        this.devicesConnected.add(interfaceDevice);
    }
    public ArrayList<SmartHomeDevice> getDevicesConnected(){
        return devicesConnected;
    }
}
