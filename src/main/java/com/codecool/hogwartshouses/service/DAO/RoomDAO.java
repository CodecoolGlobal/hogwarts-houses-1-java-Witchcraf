package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

public interface RoomDAO {

    void add(Room room);
    Set<Room> getAll();
    Room findById(int roomId);
    void deleteById(int roomId);
}