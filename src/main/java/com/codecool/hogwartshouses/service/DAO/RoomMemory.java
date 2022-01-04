package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {

    private final Set<Room> rooms;

    public RoomMemory(Set<Room> rooms) {
        this.rooms = rooms;
    }


    @Override
    public void add(Room room) {
        rooms.add(room);

    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

    @Override
    public Room findById(int roomId) {
        Room currentRoom = null;
        for (Room room : rooms) {
            if(room.getId() == roomId){
                currentRoom = room;
            }
        }
        return currentRoom;
    }

    @Override
    public void deleteById(int roomId) {
        rooms.removeIf(room -> room.getId() == roomId);
    }
}
