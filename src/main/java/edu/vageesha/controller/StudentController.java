package edu.vageesha.controller;

import edu.vageesha.dto.Student;
import edu.vageesha.entity.StudentEntity;
import edu.vageesha.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<StudentEntity> getAll(){
        return studentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removeStudent(@PathVariable Long id){
        return studentService.removeStudent(id)?
                ResponseEntity.ok("Deleted"):
                ResponseEntity.notFound().build();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student searchStudentById(@PathVariable Long id){
        return studentService.searchById(id);
    }
}
