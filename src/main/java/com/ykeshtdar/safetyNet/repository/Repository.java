package com.ykeshtdar.safetyNet.repository;


import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import org.springframework.beans.factory.annotation.*;

import java.io.*;
import java.util.*;

@org.springframework.stereotype.Repository
public class Repository {
    //    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    @Autowired
    GetJsonNode getJsonNode;

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

//    public List<PersonnesCouvertesParCaserne> coveredpersonsRepo(int stationnumber) throws IOException {
//
//        List<PersonnesCouvertesParCaserne> couvertesParCasernes = new LinkedList<>();
//        JsonNode fireStations = jsonReaderFile.JsonReaderFileFireStation();
//        //        JsonNode medicalrecords = jsonReaderFile.JsonReaderFileMedicalRecords();
//        JsonNode persons = jsonReaderFile.JsonReaderFilePerson();
//
//
//
//        Person person1 = new Person();
//        String firestationnumberstring = String.valueOf(stationnumber);
//        for (int i = 0; i < fireStations.size(); i++) {
//            if (fireStations.path(i).path("station").asText().equals(firestationnumberstring)) {
//                for (int j = 0; j < persons.size(); j++) {
//                    PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();
//                    if (persons.path(j).path("address").equals(fireStations.path(i).path("address"))) {
//
//                        personnesCouvertesParCaserne.setFirstName(persons.path(j).path("firstName").toString());
//                        personnesCouvertesParCaserne.setLastName(persons.path(j).path("lastName").toString());
//                        personnesCouvertesParCaserne.setAdresse(persons.path(j).path("address").toString());
//                        personnesCouvertesParCaserne.setPhone(persons.path(j).path("phone").toString());
//
//                        couvertesParCasernes.add(personnesCouvertesParCaserne);
//                    }
////                                        System.out.println(persons.path(j).path("firstName"));
//
//                }
//            }
//        }
//        return couvertesParCasernes;
//    }


}
