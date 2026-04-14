package com.example.studentexceptionproject.controller;

import org.springframework.web.bind.annotation.*;

import com.example.studentexceptionproject.model.Student;
import com.example.studentexceptionproject.exception.StudentNotFoundException;
import com.example.studentexceptionproject.exception.InvalidInputException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){

        int studentId;

        try{
            studentId=Integer.parseInt(id);
        }
        catch(NumberFormatException e){
            throw new InvalidInputException("Student ID must be number");
        }

        if(studentId!=1){
            throw new StudentNotFoundException("Student not found with id "+studentId);
        }

        return new Student(1,"Sunny","CSE");
    }
}