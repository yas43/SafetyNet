package com.ykeshtdar.safetyNet.dto;



import com.ykeshtdar.safetyNet.model.*;

import java.util.*;

// this class corresponding to "http://localhost:8080/childAlert?address=<address>"

public class EnfantsHabitantsLesAddress {
    private String name;
    private String familyName;
    private int age;
    private List<Person> personList;

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "EnfantsHabitantsLesAddress{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", personList=" + personList +
                '}';
    }
}
