package models;

import lombok.Data;

import java.util.UUID;

public abstract class SmartHomeDevice implements Command{
    public String name;
    public String uuid = UUID.randomUUID().toString();
    public String roomLocation;

    public boolean isToggled;
    public abstract boolean connectToInterface();


    public abstract SmartHomeDevice getStatus();

    public abstract void toggleDevice();


    @Override
    public String toString() {
        return "SmartHomeDevice{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", roomLocation='" + roomLocation + '\'' +
                ", isToggled=" + isToggled +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }
}
