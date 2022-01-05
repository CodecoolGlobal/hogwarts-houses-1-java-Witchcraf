package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;


@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void addStudentToList(String name){
        Random r = new Random();
        int number =  r.nextInt(100-10) + 10;
        studentDao.add(new Student(number, name));
    }

    public Set<Student> getAllStudents(){
        return studentDao.getAll();
    }

    public Student getStudentByName(String name) {
        if(studentDao.findByName(name) == null){
            addStudentToList(name);
            return studentDao.findByName(name);
        }
        return studentDao.findByName(name);
    }

}
