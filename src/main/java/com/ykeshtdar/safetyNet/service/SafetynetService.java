package com.ykeshtdar.safetyNet.service;
import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.reader.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;


@Service
public class SafetynetService {
@Autowired
    GetJsonNode getJsonNode;
    public List<PersonnesCouvertesParCaserne> coveredPersonsRepo(int stationnumber) throws IOException {
        int totalNumberOfAdults = 0;
        int totalNumberOfKids = 0;
        List<PersonnesCouvertesParCaserne> couvertesParCasernes = new LinkedList<>();
        JsonNode fireStations = getJsonNode.getFireStationNode();
        JsonNode medicalrecords = getJsonNode.getMedicalRecordsNode();
        JsonNode persons = getJsonNode.getPersonNode();


        String firestationnumberstring = String.valueOf(stationnumber);
        for (int i = 0; i < fireStations.size(); i++) {
            if (fireStations.path(i).path("station").asText().equals(firestationnumberstring)) {
                for (int j = 0; j < persons.size(); j++) {
                    if (persons.path(j).path("address").equals(fireStations.path(i).path("address"))) {
                        for (int k=0;k<medicalrecords.size();k++) {
                            PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();

                            if (medicalrecords.path(k).path("firstName").equals(persons.path(j).path("firstName"))) {

                                personnesCouvertesParCaserne.setFirstName(persons.path(j).path("firstName").toString());
                                personnesCouvertesParCaserne.setLastName(persons.path(j).path("lastName").toString());
                                personnesCouvertesParCaserne.setAdresse(persons.path(j).path("address").toString());
                                personnesCouvertesParCaserne.setPhone(persons.path(j).path("phone").toString());
                                if (isAnAdultPerson(medicalrecords.path(k))) {
                                    totalNumberOfAdults+=1;
                                    personnesCouvertesParCaserne.setAdults(true);

                                } else {
                                    totalNumberOfKids+=1;
                                    personnesCouvertesParCaserne.setKids(true);

                                }
                                couvertesParCasernes.add(personnesCouvertesParCaserne);

                            }


                        }

                    }

                }
            }
        }
        for (PersonnesCouvertesParCaserne personnesCouvertesParCaserne:couvertesParCasernes){

            personnesCouvertesParCaserne.setTotalNumberOfAdults(totalNumberOfAdults);
            personnesCouvertesParCaserne.setTotalNumberOfKids(totalNumberOfKids);

        }
//        System.out.println(couvertesParCasernes);
        return couvertesParCasernes;
    }

    public boolean isAnAdultPerson(JsonNode person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(person.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age >= 18;

    }


}
