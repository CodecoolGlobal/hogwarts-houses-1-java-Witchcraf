package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class RoomCreator {

   private final RoomMemory roomMemory;

    public void initialize() {
        Room room = new Room(1, HouseType.GRYFFINDOR);
        Room room1 = new Room(2, HouseType.HUFFLEPUFF);
        Room room2 = new Room(3, HouseType.RAVENCLAW);
        Room room3 = new Room(4, HouseType.SLYTHERIN);
        for (Room room4 : Arrays.asList(room, room1, room2, room3)) {
            roomMemory.add(room4);
        }
    }

    @Autowired
    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }
}
