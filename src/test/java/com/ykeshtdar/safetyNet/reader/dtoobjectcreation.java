package com.ykeshtdar.safetyNet.reader;

import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;

import java.io.*;
import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
public class dtoobjectcreation {
    @Autowired
    SafetynetService safetynetService;

    @Autowired
    GetJsonNode getJsonNode;

//    private final EnfantsHabitantsLesAddress enfantsHabitantsLesAddress = ();
//    private final EnfantsHabitantsLesAddress secondenfantsHabitantsLesAddress;


    String address = "1509 Culver St";
    private final int numberOfPersonInFirstStationZone = 6;
    private final int numberOfPersonInSecondStationZone = 5;
    private final int numberOfPersonInThirdStationZone = 13;
    private final int numberOfPersonInForthStationZone =4;
//List<String> medication = Arrays.asList("aznol:350mg", "hydrapermazol:100mg");
    List<String> medication = new LinkedList<>();



    @Test
    public void coveredPersonsRepoShouldReturnListOfPersonnesCouvertesParCaserne() throws IOException {

        Assertions.assertEquals(numberOfPersonInFirstStationZone,safetynetService.coveredPersonsRepo(1).size());
        Assertions.assertEquals(numberOfPersonInSecondStationZone,safetynetService.coveredPersonsRepo(2).size());
        Assertions.assertEquals(numberOfPersonInThirdStationZone,safetynetService.coveredPersonsRepo(3).size());
        Assertions.assertEquals(numberOfPersonInForthStationZone,safetynetService.coveredPersonsRepo(4).size());

    }

    @Test
    public void isAnAdultPersonShouldReturnTrueFor19AndOlderPerson() throws IOException {
        JsonNode adultNode = getJsonNode.getMedicalRecordsNode().path(1);
        JsonNode childNode = getJsonNode.getMedicalRecordsNode().path(3);
        Assertions.assertTrue(safetynetService.isAnAdultPerson(adultNode));
        Assertions.assertFalse(safetynetService.isAnAdultPerson(childNode));

    }

    @Test
    public void childForEachAddressShouldReturnListOfEnfantsHabitantsLesAddress() throws IOException {
        int numberOfChildInAddress = 2;
        Assertions.assertEquals(numberOfChildInAddress,safetynetService.childForEachAddress(address).size());
    }


    @Test
    public void isKidShouldReturnTrueForLessThan19OldPerson() throws IOException {
        JsonNode adultNode = getJsonNode.getMedicalRecordsNode().path(1);
        JsonNode childNode = getJsonNode.getMedicalRecordsNode().path(3);

        Assertions.assertTrue(safetynetService.isKid(childNode));
        Assertions.assertFalse(safetynetService.isKid(adultNode));
    }

    @Test
    public void isAdultShouldReturnFalseForLessThan19OldPerson() throws IOException {
        JsonNode adultNode = getJsonNode.getMedicalRecordsNode().path(1);
        JsonNode childNode = getJsonNode.getMedicalRecordsNode().path(3);

        Assertions.assertTrue(safetynetService.isAdult(adultNode));
        Assertions.assertFalse(safetynetService.isAdult(childNode));
    }


    @Test
    public void ageShouldAgePerson() throws IOException {
        JsonNode adultNode = getJsonNode.getMedicalRecordsNode().path(1);
        JsonNode childNode = getJsonNode.getMedicalRecordsNode().path(3);

        int adultNodeAge = 35;
        int childNodeAge = 6;

        Assertions.assertEquals(adultNodeAge,safetynetService.age(adultNode));
        Assertions.assertEquals(childNodeAge,safetynetService.age (childNode));
    }


    @Test
    public void numerosTelephoneParCaserneListShouldReturnListOfNumerosTelephoneParCaserne() throws IOException {
        int numberOfPhoneNumberInStation2 = 4;
        Assertions.assertEquals(numberOfPhoneNumberInStation2,safetynetService.phoneNumbers(2).size());

    }

    @Test
    public void personaddressShouldReturnListOfHabitantsParAdresse() throws IOException {

        Assertions.assertNotNull(safetynetService.personaddress(address));
    }


    @Test
    public void addresseesForFireStationShouldReturnListOfAdresseParCaserne() throws IOException {
        List<Integer> listOfCasern ;
        listOfCasern = Arrays.asList(1,2);
        Assertions.assertNotNull(safetynetService.addresseesForFireStation(listOfCasern));
    }


    @Test
    public void personInfoShouldReturnListOfPersinInfo() throws IOException {
//        medication.add("[\"aznol:350mg\",\"hydrapermazol:100mg\"]");
//        medication.add("[\"nillacilan\"]");
//        medication.add("nillacilan");
//         final PersonInfo personInfo = new PersonInfo("\"John\" ","\"1509 Culver St\"",40,"\"jaboyd@email.com\"",medication);

//         Assertions.assertEquals(personInfo,safetynetService.personInfo("John","Boyd"));
        Assertions.assertNotNull(safetynetService.personInfo("John","Boyd"));

    }

    @Test
    public void communityEmailShouldReturnListOfCommunityEmail() throws IOException {
        String cityName = "Culver";
        Assertions.assertNotNull(safetynetService.communityEmail(cityName));
    }

}
