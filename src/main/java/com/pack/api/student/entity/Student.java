package com.pack.api.student.entity;

import com.pack.api.address.entity.Address;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {  // one

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String email;
    private String mobile;

    @OneToMany(mappedBy = "student")
    //    @JoinTable(
    //            name = "students_addresses",
    //            joinColumns = @JoinColumn(name = "student_id"),
    //            inverseJoinColumns = @JoinColumn(name = "address_id")
    //    )
    private List<Address> addresses;

    public Student() {
    }

    public Student(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Student(String name, String email, String mobile, List<Address> addresses) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.addresses = addresses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

}
