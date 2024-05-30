package com.ykeshtdar.safetyNet.service;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.repository.Repository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.io.*;
import java.util.*;

@Service
public class PersonService {

    @Autowired
    Repository repository;

    public List<Person> postPersontolist(Person person) throws IOException {

        List<Person>  personList = repository.pesonRepo();
        personList.add(person);

        return personList;


    }


    public List<Person> updatrPerson(Person person) throws IOException {
        List<Person> personList = repository.pesonRepo();

        for (Person value : personList) {

            if (value.getFirstName().replace("\"", "").equalsIgnoreCase(person.getFirstName())
                    && value.getLastName().replace("\"", "").equalsIgnoreCase(person.getLastName())) {
                if (person.getAddress() != null && !(person.getAddress().isEmpty())) {
                    value.setAddress(person.getAddress());
                }
                if (person.getAddress().isEmpty()) {
                    value.setAddress(value.getAddress());
                }

                if (person.getCity() != null && !(person.getCity().isEmpty())) {
                    value.setCity(person.getCity());
                }
                if (person.getCity().isEmpty()) {
                    value.setCity(value.getCity());
                }

                if (person.getZip() != null && !(person.getZip().isEmpty())) {
                    value.setZip(person.getZip());
                }
                if (person.getZip().isEmpty()) {
                    value.setZip(value.getZip());
                }

                if (person.getPhone() != null && !(person.getPhone().isEmpty())) {
                    value.setPhone(person.getPhone());
                }
                if (person.getPhone().isEmpty()) {
                    value.setPhone(value.getPhone());
                }

                if (person.getEmail() != null && !(person.getEmail().isEmpty())) {
                    value.setEmail(person.getEmail());
                }
                if (person.getEmail().isEmpty()) {
                    value.setEmail(value.getEmail());
                }
            }
        }
        return personList;
    }


    public List<Person> deletPerson(Person person) throws IOException {
        List<Person> personList = repository.pesonRepo();
        for (int i = 0; i < personList.size(); i++) {

            if (personList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(person.getFirstName())
                    && personList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(person.getLastName())) {
                personList.remove(personList.get(i));


            }
        }
        return personList;
    }
}
