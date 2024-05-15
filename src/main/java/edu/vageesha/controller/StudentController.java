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
    public StudentEntity addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<StudentEntity> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> searchStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.searchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(id,student));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removeStudent(@PathVariable Long id){
        return studentService.removeStudent(id)?
                ResponseEntity.ok("Deleted"):
                ResponseEntity.notFound().build();

    }
}
