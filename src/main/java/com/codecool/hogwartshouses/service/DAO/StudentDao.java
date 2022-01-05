package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;

import java.util.Set;

public interface StudentDao {
    void add(Student student);
    Set<Student> getAll();
    Student findByName(String alex);
}
