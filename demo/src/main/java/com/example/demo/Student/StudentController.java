package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
private final  StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
    return studentService.getStudents();
}
@PostMapping
public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
}
@DeleteMapping(path = "{studentId}")
public void deleteStudentById(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
}
@PutMapping(path = "{studentId}")
    public  void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String nom ,
            @RequestParam(required = false) String email) {
    studentService.updateStudent(studentId , nom , email);
    }

}
