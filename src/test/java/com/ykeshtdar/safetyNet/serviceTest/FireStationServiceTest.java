package com.ykeshtdar.safetyNet.serviceTest;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import com.ykeshtdar.safetyNet.repository.*;
import com.ykeshtdar.safetyNet.service.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FireStationServiceTest {

    GetJsonNode getJsonNode =new GetJsonNode();
    Repository repository = new Repository(getJsonNode);
    FirestationService firestationService = new FirestationService(repository);
    @Test
    public void addFireStationShouldAddAFireStationToListOfFireStation(){
        Firestations addedFireStation = new Firestations("new address", "new number");
        List<Firestations> result = firestationService.addFireStation(addedFireStation);
        int totalInitialNumberOfFireStation = 13;

        Assertions.assertNotNull(result);
        Assertions.assertEquals(totalInitialNumberOfFireStation+1,result.size());
    }

    @Test
    public void deleteFireStationsShouldReturnUpdatedFireStationList(){
        Firestations firstDeletedFireStations = new Firestations("1509 Culver St", "any number");
        Firestations secondDdeletedFireStations = new Firestations("any address", "3");

        List<Firestations> firstResult = firestationService.deleteFireStations(firstDeletedFireStations);
        List<Firestations> secondResult = firestationService.deleteFireStations(secondDdeletedFireStations);

        int totalInitialNumberOfFireStation = 13;

        int firstDeletedFireStationsAddressRepetition = 1;
        int secondDeletedFireStationNumberRepetition = 5;

        Assertions.assertNotNull(firstResult);
        Assertions.assertNotNull(secondResult);
        Assertions.assertEquals(totalInitialNumberOfFireStation-firstDeletedFireStationsAddressRepetition,firstResult.size());
        Assertions.assertEquals(totalInitialNumberOfFireStation-secondDeletedFireStationNumberRepetition,secondResult.size());

    }

    @Test
    public void updateFireStationsShouldReturnUpdatedList(){
        Firestations updatedFireStations = new Firestations("1509 Culver St", "new number");
        List<Firestations> result = firestationService.updateFireStations(updatedFireStations);
        int totalInitialNumberOfFireStation = 13;

        Assertions.assertNotNull(result);
        Assertions.assertEquals(totalInitialNumberOfFireStation,result.size());


    }
}
