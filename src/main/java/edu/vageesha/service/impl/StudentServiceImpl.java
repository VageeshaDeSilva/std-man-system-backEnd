package edu.vageesha.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vageesha.dto.Student;
import edu.vageesha.entity.StudentEntity;
import edu.vageesha.exception.ResourceNotFoundException;
import edu.vageesha.repository.StudentRepository;
import edu.vageesha.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Student searchById(Long id) {
        StudentEntity stdById = studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student is NOT found by this id = " + id));
        return objectMapper.convertValue(stdById,Student.class);
    }

    @Override
    public Student updateStudent(Long id,Student student) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student is NOT found by this id = " + id));

        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setSchool(student.getSchool());
        studentEntity.setAddress(student.getAddress());

        studentRepository.save(studentEntity);

        return objectMapper.convertValue(studentEntity,Student.class);
    }

    @Override
    public boolean removeStudent(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
