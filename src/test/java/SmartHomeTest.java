import dao.Storage;
import enums.SmartHomeDeviceType;
import exceptions.InvalidCommandException;
import factory.SmartHomeFactory;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.CommandService;
import services.InterfaceSearchService;
import services.InterfaceService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartHomeTest {
    public InterfaceSearchService interfaceSearchService;
    public InterfaceService interfaceService;
    public CommandService commandService;
    @BeforeEach
    public void setup(){
         interfaceSearchService= new InterfaceSearchService();
         interfaceService = new InterfaceService();
         commandService = new CommandService();
    }

    @Test
    public void test() throws InvalidCommandException {
        House house = new House("House1");
        RoomLocation location = house.addRoomLocation(new RoomLocation("living room"));
        InterfaceDevice interfaceDevice = interfaceService.addInterfaceDevice("Alexa",Constants.ALEXA_COMMAND, location.getLocation());
        SmartHomeDevice fan = SmartHomeFactory.getSmartHomeDevice(SmartHomeDeviceType.FAN);
        SmartHomeDevice fan2 = SmartHomeFactory.getSmartHomeDevice(SmartHomeDeviceType.FAN);
        SmartHomeDevice light = SmartHomeFactory.getSmartHomeDevice(SmartHomeDeviceType.LIGHT);

        SmartHomeDevice device = interfaceService.addSmartHomeDevice("Alexa", fan,"living room");
        SmartHomeDevice device2 = interfaceService.addSmartHomeDevice("Alexa", fan2,"Kitchen");
        SmartHomeDevice device3 = interfaceService.addSmartHomeDevice("Alexa", light,"living room");
        SmartHomeDevice device4 = interfaceService.addSmartHomeDevice(null, light,null);

        System.out.println(interfaceDevice.getDevicesConnected());

        Throwable exception = assertThrows(InvalidCommandException.class, () -> commandService.executeCommand("Alexa",device.getUuid(), location.getLocation(), Constants.TOGGLE_LIGHTS));
        System.out.println(device);
        commandService.executeCommand("Alexa",device3.getUuid(), location.getLocation(), Constants.TOGGLE_LIGHTS);
        Assertions.assertEquals(device3.isToggled,true);
        interfaceService.connectSmartDevice("Alexa",device4, location.getLocation());
        Assertions.assertEquals(Storage.getInterfaceToDevice().get("Alexa").get(location.getLocation()).contains(device4),true);
//        List<SmartHomeDevice> devicesConnected = interfaceSearchService.getDevicesConnectedToInterface("Alexa");

        List<SmartHomeDevice> devicesConnectedLivingRoom = interfaceSearchService.getDevicesConnectedToInterface("Alexa","living room");
        Assertions.assertEquals(devicesConnectedLivingRoom.size(),3);
    }

}
