package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.RoomService;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;
    private final RoomService roomServices;

    @Autowired
    public StudentController(StudentService studentService, RoomService roomService) {
        this.studentService = studentService;
        this.roomServices = roomService;
    }

    @GetMapping(value = "students")
    public String getStudents(Model model){
        Set<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student";
    }

    @PostMapping(value = "students/{name}")
    public String addStudentToList(@PathVariable String name){
        studentService.addStudentToList(name);
        return "redirect:";
    }

    @PutMapping(value = "students/{studentName}")
    public String updateRoomWithStudent(Model model, @PathVariable String studentName){
        Student currentStudent = studentService.getStudentByName(studentName);
        roomServices.addStudentToEmptyRoom(currentStudent);
        //model.addAttribute("rooms", roomServices.getAllRoom());
        return "redirect:";
    }
}
