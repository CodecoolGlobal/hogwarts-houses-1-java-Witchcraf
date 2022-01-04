package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    public Set<Room> getAllRoom(){
        return roomDAO.getAll();
    }

    public void addNewRoom() {
        Room newRoom = new Room(UUID.randomUUID(), HouseType.GRYFFINDOR);
        roomDAO.add(newRoom);
    }
}
