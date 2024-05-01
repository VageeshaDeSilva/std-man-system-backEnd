package edu.vageesha.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vageesha.dto.Student;
import edu.vageesha.entity.StudentEntity;
import edu.vageesha.repository.StudentRepository;
import edu.vageesha.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;
    final ObjectMapper objectMapper;
    @Override
    public void addStudent(Student student) {
        StudentEntity map = objectMapper.convertValue(student, StudentEntity.class);
        studentRepository.save(map);
    }

    @Override
    public List<StudentEntity> getAll() {
        return (List<StudentEntity>) studentRepository.findAll();
    }
}
