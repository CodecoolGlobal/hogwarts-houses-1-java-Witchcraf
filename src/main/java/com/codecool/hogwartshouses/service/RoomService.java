package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.DAO.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.Integer.parseInt;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;
    private StudentDao studentDao;

    public Set<Room> getAllRoom(){
        return roomDAO.getAll();
    }

    public void addNewRoom() {
        Random r = new Random();
        int number =  r.nextInt(100-10) + 10;
        Room newRoom = new Room(number, HouseType.GRYFFINDOR, null);
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


    public void addStudentToEmptyRoom(Student currentStudent) {
        Set<Room> allRoom = getAllRoom();
        Set<Room> emptyRooms = new HashSet<>();
        for (Room room : allRoom) {
            if(room.getStudent() == null){
                emptyRooms.add(room);
            }

        }
        Room firstEmptyRoom = emptyRooms.stream().findFirst().orElse(null);
        System.out.println(firstEmptyRoom);
        roomDAO.updateEmptyRoomWithStudent(firstEmptyRoom, currentStudent);
    }

}
