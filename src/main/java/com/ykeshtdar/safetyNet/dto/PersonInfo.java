package com.ykeshtdar.safetyNet.dto;

import org.springframework.stereotype.*;

import java.util.*;

@Component
public class PersonInfo {
    private String firstName;
    private String address;
    private int age;
    private String email;
    private List<String> medicationhistory;

    public PersonInfo(String firstName, String address, int age, String email, List<String> medicationhistory) {
        this.firstName = firstName;
        this.address = address;
        this.age = age;
        this.email = email;
        this.medicationhistory = medicationhistory;
    }

    public PersonInfo() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInfo that = (PersonInfo) o;
        return age == that.age && Objects.equals(firstName, that.firstName) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(medicationhistory, that.medicationhistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, address, age, email, medicationhistory);
    }
}
