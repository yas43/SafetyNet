package com.ykeshtdar.safetyNet.service;
import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.model.*;
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
        return couvertesParCasernes;
    }

    public boolean isAnAdultPerson(JsonNode person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(person.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age >= 18;

    }









    List<EnfantsHabitantsLesAddress> enfantsHabitantsLesAddressList = new LinkedList<>();
    List<Person> personList = new LinkedList<>();



    public List<EnfantsHabitantsLesAddress> childForEachAddress(String address) throws IOException {
        for (int i = 0; i < getJsonNode.getPersonNode().size(); i++) {
            if (getJsonNode.getPersonNode().path(i).path("address").asText().equals(address)) {
                for (int j = 0; j < getJsonNode.getMedicalRecordsNode().size(); j++) {
                    EnfantsHabitantsLesAddress enfantsHabitantsLesAddress = new EnfantsHabitantsLesAddress();
                    if (getJsonNode.getMedicalRecordsNode().path(j).path("firstName").equals(getJsonNode.getPersonNode().path(i).path("firstName"))
                            && getJsonNode.getMedicalRecordsNode().path(j).path("lastName").equals(getJsonNode.getPersonNode().path(i).path("lastName"))
                            && isKid(getJsonNode.getMedicalRecordsNode().path(j))) {
                        enfantsHabitantsLesAddress.setName(getJsonNode.getPersonNode().path(i).path("firstName").toString());
                        enfantsHabitantsLesAddress.setFamilyName(getJsonNode.getPersonNode().path(i).path("lastName").toString());
                        enfantsHabitantsLesAddress.setAge(age(getJsonNode.getMedicalRecordsNode().path(j)));
                        enfantsHabitantsLesAddress.setPersonList(householdMembers(address));

                        enfantsHabitantsLesAddressList.add(enfantsHabitantsLesAddress);
                    }
                }
            }
        }
        return enfantsHabitantsLesAddressList;
    }

    private boolean isKid(JsonNode jsonNode) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age <= 18;


    }

    public boolean isAdult(JsonNode jsonNode) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age > 18;


    }

    private int age(JsonNode jsonNode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age;

    }

    public List<Person> householdMembers(String address) throws IOException {

        for (int i = 0; i < getJsonNode.getPersonNode().size(); i++) {
            if (getJsonNode.getPersonNode().path(i).path("address").asText().equals(address)) {
                for (int j = 0; j < getJsonNode.getMedicalRecordsNode().size(); j++) {
                    Person person = new Person();
                    if (getJsonNode.getPersonNode().path(i).path("firstName").equals(getJsonNode.getMedicalRecordsNode().path(j).path("firstName"))
                            && isAdult(getJsonNode.getMedicalRecordsNode().path(j))) {
                        person.setFirstName(getJsonNode.getPersonNode().path(i).path("firstName").toString());
                        person.setLastName(getJsonNode.getPersonNode().path(i).path("lastName").toString());
                        person.setAddress(getJsonNode.getPersonNode().path(i).path("address").toString());
                        person.setCity(getJsonNode.getPersonNode().path(i).path("city").toString());
                        person.setZip(getJsonNode.getPersonNode().path(i).path("zip").toString());
                        person.setPhone(getJsonNode.getPersonNode().path(i).path("phone").toString());
                        person.setEmail(getJsonNode.getPersonNode().path(i).path("email").toString());

                        personList.add(person);

                    }

                }
            }
        }
        return personList;
    }







//    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    Set<NumerosTelephoneParCaserne> numerosTelephoneParCaserneList = new HashSet<>();

    public Set<NumerosTelephoneParCaserne> phoneNumbers(int firesationnumber) throws IOException {
        String firestationstring = String.valueOf(firesationnumber);
        for (int i = 0; i < getJsonNode.getFireStationNode().size(); i++) {
            if (getJsonNode.getFireStationNode().path(i).path("station").asText().equals(firestationstring)) {
                for (int j = 0; j < getJsonNode.getPersonNode().size(); j++) {
                    NumerosTelephoneParCaserne numerosTelephoneParCaserne = new NumerosTelephoneParCaserne();
                    if (getJsonNode.getPersonNode().path(j).path("address").equals(getJsonNode.getFireStationNode().path(i).path("address"))) {
                        numerosTelephoneParCaserne.setPhoneNumber(getJsonNode.getPersonNode().path(j).path("phone").asText());
                        numerosTelephoneParCaserneList.add(numerosTelephoneParCaserne);
                    }
                }
            }
        }
        return numerosTelephoneParCaserneList;
    }

}
