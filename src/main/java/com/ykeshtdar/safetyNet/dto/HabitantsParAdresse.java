package com.ykeshtdar.safetyNet.dto;

import java.util.*;


// this class corresponding to "http://localhost:8080/fire?address=<address>"
public class HabitantsParAdresse {
    private String firsName;
    private String phone;
    private int age;
    private List<String> medication;

    public String getFirsName() {
        return firsName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public List<String> getMedication() {
        return medication;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMedication(List<String> medication) {
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "HabitantsParAdresse{" +
                "firsName='" + firsName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medication=" + medication +
                '}';
    }
}
