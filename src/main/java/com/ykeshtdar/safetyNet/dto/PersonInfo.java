package com.ykeshtdar.safetyNet.dto;

import java.util.*;


//this url corresponding to "http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>"
public class PersonInfo {
    private String firstName;
    private String address;
    private int age;
    private String email;
    private List<String> medicationhistory;

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getMedicationhistory() {
        return medicationhistory;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMedicationhistory(List<String> medicationhistory) {
        this.medicationhistory = medicationhistory;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", medicationhistory=" + medicationhistory +
                '}';
    }
}
