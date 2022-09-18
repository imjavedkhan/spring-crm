package com.primus.springcrm.services;

import com.primus.springcrm.entity.Student;
import com.primus.springcrm.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
       return studentRepo.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> stu =  studentRepo.findById(id);

        if(stu.isPresent()){
            return stu.get();
        }
        else{
            throw new RuntimeException("Student not found with Id: " + id);
        }
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id){
        Optional<Student> stu = studentRepo.findById(id);

        if(stu.isPresent()){
            studentRepo.deleteById(id);
        }
        else{
            throw new RuntimeException("Student not find with Id: " + id);
        }
    }

}
