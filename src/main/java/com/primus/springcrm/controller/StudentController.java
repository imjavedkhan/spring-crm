package com.primus.springcrm.controller;

import com.primus.springcrm.entity.Student;
import com.primus.springcrm.services.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String getAllStudents(Model model){

       List<Student> thestudents =  studentService.getAllStudents();

        model.addAttribute("students", thestudents);

        return  "index";
    }

    @PostMapping("/showFormForUpdate")
    public String getStudent(@RequestParam("studentId") Long theId,
                              Model theModel){
        Student theStudent =  studentService.getStudent(theId);

        theModel.addAttribute("new_student",theStudent);

        return "add_student";
    }

    @PostMapping("student/delete")
    public String deleteStudent(@RequestParam("studentId") Long id){
         studentService.deleteStudent(id);
        return "redirect:/";
    }

    @PostMapping("save/student")
    public String saveStudent(@ModelAttribute("new_student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String showFormForStudent(Model themodel){
        Student student = new Student();
        themodel.addAttribute("new_student",student);
        return "add_student";
    }

}
