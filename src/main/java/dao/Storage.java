package dao;

import models.House;
import models.InterfaceDevice;
import models.RoomLocation;
import models.SmartHomeDevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Storage {
    public static HashMap<String, InterfaceDevice> interfaceDeviceHashMap;

    public static Map<String, Map<String, List<SmartHomeDevice>>> interfaceToDevice;

    public static HashMap<String, RoomLocation> roomLocationHashMap;

    public static HashMap<String, SmartHomeDevice> smartHomeDeviceHashMap;


    public static HashMap<String, House> houseHashMap;
    public static HashMap<String, InterfaceDevice> getInterfaceDeviceHashMap() {
        if(Objects.isNull(interfaceDeviceHashMap)){
            interfaceDeviceHashMap = new HashMap<>();
        }
        return interfaceDeviceHashMap;
    }
    public static HashMap<String,RoomLocation> getRoomLocations(){
        if(Objects.isNull(roomLocationHashMap)){
            roomLocationHashMap = new HashMap<>();
        }
        return roomLocationHashMap;
    }

    public static HashMap<String,House> getHouse(){
        if(Objects.isNull(houseHashMap)){
            houseHashMap = new HashMap<>();
        }
        return houseHashMap;
    }
    public static HashMap<String, SmartHomeDevice> getSmartHomeDeviceHashMap(){
        if(Objects.isNull(smartHomeDeviceHashMap)){
            smartHomeDeviceHashMap = new HashMap<>();
        }
        return smartHomeDeviceHashMap;
    }


    public static Map<String, Map<String, List<SmartHomeDevice>>> getInterfaceToDevice() {
        if(Objects.isNull(interfaceToDevice)){
            interfaceToDevice = new HashMap<>();
        }
        return interfaceToDevice;
    }

    public void addHouse(String house){
        if(!getHouse().containsKey(house)){
            getHouse().put(house, new House(house));
        }
    }
}
