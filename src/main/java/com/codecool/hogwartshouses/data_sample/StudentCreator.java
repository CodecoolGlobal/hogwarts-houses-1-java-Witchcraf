package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreator {

    private final StudentMemory studentMemory;

    public void initialize() {
        Student student = new Student(1, "Alex");
        Student student1 = new Student(2, "Pete");
        Student student2 = new Student(3, "Mark");
        studentMemory.add(student);
        studentMemory.add(student1);
        studentMemory.add(student2);
    }

    @Autowired
    public StudentCreator(StudentMemory studentMemory) {
        this.studentMemory = studentMemory;
        initialize();
    }

}
