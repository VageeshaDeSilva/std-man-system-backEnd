package edu.vageesha.service;

import edu.vageesha.dto.Student;
import edu.vageesha.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<StudentEntity> getAll();
    boolean removeStudent(Long id);
    Student searchById(Long id);
}
