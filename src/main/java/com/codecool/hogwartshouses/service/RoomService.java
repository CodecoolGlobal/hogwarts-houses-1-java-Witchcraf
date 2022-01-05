package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

import static java.lang.Integer.parseInt;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    public Set<Room> getAllRoom(){
        return roomDAO.getAll();
    }

    public void addNewRoom() {
        Random r = new Random();
        int number =  r.nextInt(100-100) + 10;
        Room newRoom = new Room(number, HouseType.GRYFFINDOR);
        roomDAO.add(newRoom);
    }

    public Room findRoomById(String roomId) {
        return roomDAO.findById(parseInt(roomId));
    }

    public void cancelRoomById(int roomId) {
        roomDAO.deleteById(roomId);
    }

    public void updateRoomById(int roomID) {
        Room updatedRoom = roomDAO.findById(roomID);
        updatedRoom.setHouseType(HouseType.SLYTHERIN);
    }
}
