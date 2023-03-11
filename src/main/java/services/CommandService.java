package services;

import dao.Storage;
import exceptions.InvalidCommandException;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandService {
    public Map<String, Map<String,List<SmartHomeDevice>>> interfaceToDevice = Storage.getInterfaceToDevice();
    public CommandService(){
    }
    public void executeCommand(String interfaceName, String deviceId, String location, String command) throws InvalidCommandException {
        List<SmartHomeDevice> commands = interfaceToDevice.get(interfaceName).get(location).stream().filter(device -> device.getUuid().equals(deviceId)).collect(Collectors.toList());
        for(Command command1 : commands){
                if(command1.isValidCommand(command)){
                    command1.execute(command);
                }else{
                    throw new InvalidCommandException("Command provided is invalid");
                }
        }
    }
    public void executeCommand(String interfaceName, String location, String command) {
        List<SmartHomeDevice> commands = interfaceToDevice.get(interfaceName).get(location);
        for(Command command1 : commands){
            if(command1.isValidCommand(command)){
                command1.execute(command);
            }
        }
    }
}
