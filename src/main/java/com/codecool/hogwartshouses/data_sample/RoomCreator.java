package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RoomCreator {

   private final RoomMemory roomMemory;
   private final StudentMemory studentMemory;

    public void initialize() {
        Student st1 = new Student(123, "A");
        Student st2 = new Student(124, "b");
        Room room = new Room(1, HouseType.GRYFFINDOR, st1, PetType.NONE);
        Room room1 = new Room(2, HouseType.HUFFLEPUFF, st2, PetType.OWL);
        Room room2 = new Room(3, HouseType.RAVENCLAW, null, PetType.CAT);
        Room room3 = new Room(4, HouseType.SLYTHERIN, null, PetType.RAT);
        studentMemory.add(st1);
        studentMemory.add(st2);
        roomMemory.add(room);
        roomMemory.add(room1);
        roomMemory.add(room2);
        roomMemory.add(room3);
    }

    @Autowired
    public RoomCreator(RoomMemory roomMemory, StudentMemory studentMemory) {
        this.roomMemory = roomMemory;
        this.studentMemory = studentMemory;
        initialize();
    }
}
