package com.pack.api.student.serviceimplementation;

import com.pack.api.address.repository.AddressRepository;
import com.pack.api.student.entity.Student;
import com.pack.api.student.repository.StudentRepository;
import com.pack.api.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    List<Student> students = List.of(
            new Student("John Doe", "john@gmail.com", "9879879870"),
            new Student("Jane Smith", "jane@gmail.com", "8768768760"),
            new Student("Alice Johnson", "alice@gmail.com", "7657657650"),
            new Student("Bob Brown", "bob@gmail.com", "6546546540"),
            new Student("Charlie Davis", "charlie@gmail.com", "5435435430"),
            new Student("Diana Evans", "diana@gmail.com", "4324324320"),
            new Student("Frank Green", "frank@gmail.com", "3213213210"),
            new Student("Grace Harris", "grace@gmail.com", "2102102100")
    );

    public void save() {
        studentRepository.saveAll(students);
    }










}
