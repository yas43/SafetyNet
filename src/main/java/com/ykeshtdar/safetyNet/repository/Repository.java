package com.ykeshtdar.safetyNet.repository;


import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import org.springframework.beans.factory.annotation.*;

import java.io.*;
import java.util.*;

@org.springframework.stereotype.Repository
public class Repository {
//    @Autowired
//    GetJsonNode getJsonNode;

    private final GetJsonNode getJsonNode;

    public Repository(GetJsonNode getJsonNode) {
        this.getJsonNode = getJsonNode;
    }

    public List<Person> pesonRepo() throws IOException {

        List<Person> personlist = new LinkedList<>();
        JsonNode persons = getJsonNode.getPersonNode();

        for (int i = 0; i < persons.size(); i++) {

            Person person = new Person();

            person.setFirstName(persons.path(i).path("firstName").toString());
            person.setLastName(persons.path(i).path("lastName").toString());
            person.setAddress(persons.path(i).path("address").toString());
            person.setCity(persons.path(i).path("city").toString());
            person.setZip(persons.path(i).path("zip").toString());
            person.setPhone(persons.path(i).path("phone").toString());
            person.setEmail(persons.path(i).path("email").toString());

            personlist.add(person);

        }
        return personlist;
    }


    public List<Firestations> firestationRepo() throws IOException {

        List<Firestations> firestationsList = new LinkedList<>();
        JsonNode firestations = getJsonNode.getFireStationNode();

        for (int i = 0; i < firestations.size(); i++) {

            Firestations firestation = new Firestations();

            firestation.setAddress(firestations.path(i).path("address").toString());
            firestation.setStation(firestations.path(i).path("station").toString());


            firestationsList.add(firestation);

        }
        return firestationsList;
    }


    public List<Medicalrecords> medicalrecordsRepo() throws IOException {

        List<Medicalrecords> medicalrecordsList = new LinkedList<>();
        JsonNode medicalrecords = getJsonNode.getMedicalRecordsNode();

        for (int i = 0; i < medicalrecords.size(); i++) {

            Medicalrecords medicalrecord = new Medicalrecords();


            medicalrecord.setFirstName(medicalrecords.path(i).path("firstName").toString());
            medicalrecord.setLastName(medicalrecords.path(i).path("lastName").toString());
            medicalrecord.setBirthdate(medicalrecords.path(i).path("birthdate").toString());
            medicalrecord.setMedications(medicalrecords.path(i).path("medications").toString());
            medicalrecord.setAllergies(medicalrecords.path(i).path("allergies").toString());

            medicalrecordsList.add(medicalrecord);
        }
        return medicalrecordsList;

    }

}
