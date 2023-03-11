package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class House {
    String name;
    List<RoomLocation> roomLocationList;

    public House(String house) {
        this.name = house;
    }

    public RoomLocation addRoomLocation(RoomLocation location){
        if(Objects.isNull(roomLocationList)){
            roomLocationList = new ArrayList<>();
        }
        roomLocationList.add(location);
        return location;
    }
}
