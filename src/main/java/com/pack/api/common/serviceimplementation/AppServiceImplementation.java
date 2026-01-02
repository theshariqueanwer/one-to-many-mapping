package com.pack.api.common.serviceimplementation;

import com.pack.api.address.entity.Address;
import com.pack.api.address.repository.AddressRepository;
import com.pack.api.common.service.AppService;
import com.pack.api.student.entity.Student;
import com.pack.api.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
public class AppServiceImplementation implements AppService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public void saveDataForOneToMany01() {

        Student student = new Student("Michael Brown", "michael@gmail.com", "9876543210");

        Address address1 = new Address("456 Oak St", "Greenville", "NC", "27834");
        Address address2 = new Address("789 Pine St", "Fairview", "CA", "94541");
        Address address3 = new Address("321 Maple St", "Riverside", "TX", "77367");

        // List<Address> addresses = Arrays.asList(address1, address2, address3);
        // student.setAddresses(addresses);

        student.setAddresses(List.of(address1, address2, address3));

        // first we need to save addresses
        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        // then we can save a student
        studentRepository.save(student);

        System.out.println("data save successfully saveDataForOneToMany01");

    }

    @Override
    public void saveDataForOneToMany02() {

        Student student = new Student("Emily Clark", "emily@gmail.com", "1231231234");

        Address address = new Address("123 Main St", "Springfield", "IL", "62701");

        studentRepository.save(student);
        addressRepository.save(address);

        System.out.println("data save successfully saveDataForOneToMany02");

    }

    @Override
    public void saveDataForManyToOneV01() {
        // here we're setting a student through setter method

        //        Address address1 = new Address("456 Oak St", "Greenville", "NC", "27834");
        //        Address address2 = new Address("789 Pine St", "Fairview", "CA", "94541");
        //        Address address3 = new Address("321 Maple St", "Riverside", "TX", "77367");
        //
        //        Student student = new Student("Michael Brown", "michael@gmail.com", "9876543210");
        //
        //        address1.setStudent(student);
        //        address2.setStudent(student);
        //        address3.setStudent(student);
        //
        //        // first we need to save a student
        //        studentRepository.save(student);
        //
        //        // then we can save addresses
        //        addressRepository.save(address1);
        //        addressRepository.save(address2);
        //        addressRepository.save(address3);

        System.out.println("data save successfully saveDataForManyToOneV01");

    }

    @Override
    public void saveDataForManyToOneV02() {
        // here we're setting a student through constructor

        //        Student student = new Student("Michael Brown", "michael@gmail.com", "9876543210");
        //
        //        Address address1 = new Address("456 Oak St", "Greenville", "NC", "27834", student);
        //        Address address2 = new Address("789 Pine St", "Fairview", "CA", "94541", student);
        //        Address address3 = new Address("321 Maple St", "Riverside", "TX", "77367", student);
        //
        //        // first we need to save a student
        //        studentRepository.save(student);
        //
        //        // then we can save addresses
        //        addressRepository.save(address1);
        //        addressRepository.save(address2);
        //        addressRepository.save(address3);

        System.out.println("data save successfully from saveDataForManyToOneV02");

    }

    @Override
    @Transactional
    public void saveDataForViceVersaV01() {

        Student student = new Student("Michael Brown", "michael@gmail.com", "9876543210");

        Address address1 = new Address("456 Oak St", "Greenville", "NC", "27834");
        Address address2 = new Address("789 Pine St", "Fairview", "CA", "94541");
        Address address3 = new Address("321 Maple St", "Riverside", "TX", "77367");

        student.setAddresses(List.of(address1, address2, address3));
        address1.setStudent(student);
        address2.setStudent(student);
        address3.setStudent(student);

        studentRepository.save(student);

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        System.out.println("data save successfully saveDataForViceVersaV01");
    }

    @Override
    @Transactional
    public void saveDataForViceVersaV02() {
        // here make use of constructor to set a student in address
        // and cascade save student entity while saving address

        Student student = new Student("Michael Brown", "michael@gmail.com", "9876543210");

        Address address1 = new Address("456 Oak St", "Greenville", "NC", "27834", student);
        Address address2 = new Address("789 Pine St", "Fairview", "CA", "94541", student);
        Address address3 = new Address("321 Maple St", "Riverside", "TX", "77367", student);

        student.setAddresses(List.of(address1, address2, address3));

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        System.out.println("data save successfully saveDataForViceVersaV02");
    }

    @Override
    @Transactional
    public void getAddressDataAssociatedStudent() {
        Address address = addressRepository.findById(1000L).get();
        System.out.println("Address Details: " + address);
        Student student = address.getStudent();
        System.out.println("Associated Student Details: " + student);
        System.out.println("-----------------------------------");
    }

    @Override
    @Transactional
    public void getStudentDataAssociatedAddress() {
        Student student = studentRepository.findById(1L).get();
        System.out.println("Student Details: " + student);

        student.setName("Michael B. Brown");
        // because of transactional annotation, no need to explicitly call save method
        // studentRepository.save(student);
        System.out.println("Updated Student Details: " + student);

        List<Address> addresses = student.getAddresses();
        System.out.println("Associated Address Details: " + addresses);

    }
}
