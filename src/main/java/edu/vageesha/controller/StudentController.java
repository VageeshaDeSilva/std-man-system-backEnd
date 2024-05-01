package edu.vageesha.controller;

import edu.vageesha.dto.Student;
import edu.vageesha.entity.StudentEntity;
import edu.vageesha.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    final StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<StudentEntity> getAll(){
        return studentService.getAll();
    }
}
