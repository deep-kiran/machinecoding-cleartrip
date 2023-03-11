package services;

import dao.Storage;
import enums.SmartHomeDeviceType;
import factory.InterfaceFactory;
import factory.SmartHomeFactory;
import lombok.val;
import models.*;

import java.util.*;

public class InterfaceService {

    public static HashMap<String, RoomLocation> roomLocationHashMap = Storage.getRoomLocations();
    public static HashMap<String, InterfaceDevice> interfaceHashMap = Storage.getInterfaceDeviceHashMap();

    public static HashMap<String, SmartHomeDevice> smartDeviceHashMap = Storage.getSmartHomeDeviceHashMap();

    public static Map<String, Map<String, List<SmartHomeDevice>>> interfaceToDevice=   Storage.getInterfaceToDevice();

    public CommandService commandService = new CommandService();
    public InterfaceDevice addInterfaceDevice(String name, String commandTrigger, String roomLocation){
        if(!roomLocationHashMap.containsKey(roomLocation)){
            roomLocationHashMap.put(roomLocation, new RoomLocation(roomLocation));
        }
        InterfaceDevice interfacedevice = commandTrigger.equals(Constants.GOOGLE_COMMAND) ? new GoogleInterface() : new AlexaInterface();
        interfaceHashMap.putIfAbsent(name, interfacedevice);
        return interfaceHashMap.get(name);
    }


    public SmartHomeDevice addSmartHomeDevice(String interfaceName, SmartHomeDevice device, String roomLocation){
        device.setRoomLocation(roomLocation);
        InterfaceDevice interfaceDevice =  interfaceHashMap.containsKey(interfaceName)? interfaceHashMap.get(interfaceName) :
                InterfaceFactory.getInterfaceDevice(interfaceName);
        interfaceHashMap.putIfAbsent(interfaceName, interfaceDevice);
        interfaceToDevice.putIfAbsent(interfaceName, new HashMap<>());
        interfaceToDevice.get(interfaceName).computeIfAbsent(roomLocation, k-> new ArrayList<>()).add(device);
        interfaceDevice.addSmartHomeDevice(device);
        interfaceHashMap.put(interfaceName, interfaceDevice);
        return device;
    }



    public void connectSmartDevice(String interfaceName, SmartHomeDevice device, String location) {
        InterfaceDevice deviceInterface = interfaceHashMap.get(interfaceName);
        deviceInterface.addSmartHomeDevice(device);
        ArrayList<SmartHomeDevice> smartHomeDeviceList = deviceInterface.getDevicesConnected();
        interfaceHashMap.put(interfaceName, deviceInterface);
        interfaceToDevice.get(interfaceName).putIfAbsent(location, new ArrayList<>()).add(device);
    }
}
