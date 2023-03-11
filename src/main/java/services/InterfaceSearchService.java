package services;

import dao.Storage;
import lombok.val;
import models.InterfaceDevice;
import models.RoomLocation;
import models.SmartFan;
import models.SmartHomeDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterfaceSearchService {

    public static HashMap<String, InterfaceDevice> interfaceSearchServiceHashMap = Storage.getInterfaceDeviceHashMap();
    public static Map<String, Map<String, List<SmartHomeDevice>>> interfaceToDevice = Storage.getInterfaceToDevice();



    public List<SmartHomeDevice> getDevicesConnectedToInterface(String interfaceName){
         return interfaceToDevice.get(interfaceName).entrySet()
                 .stream()
                 .map(e -> e.getValue())
                 .flatMap(e-> e.stream())
                 .collect(Collectors.toList());
    }


    public List<SmartHomeDevice> getDevicesConnectedToInterface(String interfaceName, String location){
        return interfaceToDevice.get(interfaceName).get(location).stream()
                .collect(Collectors.toList());
    }

}
