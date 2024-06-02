package com.ykeshtdar.safetyNet.controller;

import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.service.*;
import org.apache.logging.log4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping
public class SafteyNetController {

    private static final Logger logger = LogManager.getLogger(SafteyNetController.class);

    private final SafetynetService safetynetService;


    public SafteyNetController(SafetynetService safetynetService) {
        this.safetynetService = safetynetService;
    }

    @GetMapping("firestation/{station_number}")
    public ResponseEntity<List<PersonnesCouvertesParCaserne>> personCovered(@PathVariable("station_number") int station_number) throws IOException {
        logger.info("request for have a list of covered person by a fireStation's number");
        return new ResponseEntity<>(safetynetService.coveredPersonsRepo(station_number),HttpStatus.OK);
    }



    @GetMapping("childAlert/{address}")
    @ResponseBody
    public ResponseEntity<List<EnfantsHabitantsLesAddress>> childAlert(@PathVariable("address") String address) throws IOException {
        logger.info("request for have a list of  child in a address ");
        return new ResponseEntity<>( safetynetService.childForEachAddress(address),HttpStatus.OK);

    }


    @GetMapping("phoneAlert/{firestation_number}")

    public ResponseEntity<Set<NumerosTelephoneParCaserne>> phoneAlert(@PathVariable("firestation_number") int firestation_number) throws IOException {
        logger.info("request for have a list of phone numbers by a fireStation's number");
        return new ResponseEntity<>( safetynetService.phoneNumbers(firestation_number),HttpStatus.OK);

    }



    @GetMapping("fire/{address}")
    @ResponseBody
    public ResponseEntity<Map<String,List<HabitantsParAdresse>>> fire(@PathVariable("address") String address) throws IOException {
        logger.info("request for have a list of living person in a address and corresponding fireStation");
        return new ResponseEntity<>(safetynetService.personaddress(address),HttpStatus.OK);

    }



    @GetMapping("flood/{listOfStation}")
    public ResponseEntity<List< Map<String,List<AdresseParCaserne>>>> flood(@PathVariable("listOfStation") List<Integer> list) throws IOException {
        logger.info("request for have a list of covered person in a list of fireStation's number");
        return new ResponseEntity<>( safetynetService.addresseesForFireStation(list),HttpStatus.OK);

    }



    @GetMapping("/personInfo")
    public ResponseEntity<List<PersonInfo>> personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws IOException {
        logger.info("request for have info for a person ");
        return new ResponseEntity<>( safetynetService.personInfo(firstName,lastName),HttpStatus.OK);

    }


    @GetMapping("communityEmail/{city}")
    @ResponseBody
    public ResponseEntity<Set<CommunityEmail>> communityEmail(@PathVariable("city") String city) throws IOException {
        logger.info("request for have a list of email address for all person in city");
        return new ResponseEntity<>(safetynetService.communityEmail(city),HttpStatus.OK);

    }
}
