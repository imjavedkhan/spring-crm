package com.primus.springcrm.controller;

import com.primus.springcrm.entity.Student;
import com.primus.springcrm.services.StudentService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
         studentService.deleteStudent(id);
        return "Student deleted";
    }

    @PostMapping("save/student")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved";
    }


}
