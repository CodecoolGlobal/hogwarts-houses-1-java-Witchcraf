package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void addStudentToList(String name){
        studentDao.add(new Student(name));
    }

    public Set<Student> getAllStudents(){
        return studentDao.getAll();
    }

}
