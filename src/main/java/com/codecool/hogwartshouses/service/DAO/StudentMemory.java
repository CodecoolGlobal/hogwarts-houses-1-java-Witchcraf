package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class StudentMemory  implements StudentDao{
    private final Set<Student> students;

    public StudentMemory(Set<Student> students) {
        this.students = students;
    }

    @Override
    public void add(Student student) {
        students.add(student);

    }

    @Override
    public Set<Student> getAll() {
        return students;
    }

    @Override
    public Student findByName(String name) {
        Student currentStudent = null;
        for (Student student : students) {
            if(student.getName().equals(name)){
                currentStudent = student;
            }

        }
        return currentStudent;
    }
}
