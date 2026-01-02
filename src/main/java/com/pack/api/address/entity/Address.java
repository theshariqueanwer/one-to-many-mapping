package com.pack.api.address.entity;

import com.pack.api.student.entity.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {  // many

    @Id
    @SequenceGenerator(name = "address_start_from_1000", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_start_from_1000")
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String pinCode;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {
    }

    public Address(String street, String city, String state, String pinCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public Address(String street, String city, String state, String pinCode, Student student) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.student = student;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

}
