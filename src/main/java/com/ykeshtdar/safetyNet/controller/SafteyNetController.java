package com.ykeshtdar.safetyNet.controller;

import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping
public class SafteyNetController {

    private final SafetynetService safetynetService;


    public SafteyNetController(SafetynetService safetynetService) {
        this.safetynetService = safetynetService;
    }

    @GetMapping("firestation/{station_number}")
    public ResponseEntity<List<PersonnesCouvertesParCaserne>> personCovered(@PathVariable("station_number") int station_number) throws IOException {
        return new ResponseEntity<>(safetynetService.coveredPersonsRepo(station_number),HttpStatus.OK);
    }



    @GetMapping("childAlert/{address}")
    @ResponseBody
    public ResponseEntity<List<EnfantsHabitantsLesAddress>> childAlert(@PathVariable("address") String address) throws IOException {
        return new ResponseEntity<>( safetynetService.childForEachAddress(address),HttpStatus.OK);

    }


    @GetMapping("phoneAlert/{firestation_number}")

    public ResponseEntity<Set<NumerosTelephoneParCaserne>> phoneAlert(@PathVariable("firestation_number") int firestation_number) throws IOException {
        return new ResponseEntity<>( safetynetService.phoneNumbers(firestation_number),HttpStatus.OK);

    }



    @GetMapping("fire/{address}")
    @ResponseBody
    public ResponseEntity<Map<String,List<HabitantsParAdresse>>> fire(@PathVariable("address") String address) throws IOException {
        return new ResponseEntity<>(safetynetService.personaddress(address),HttpStatus.OK);

    }



    @GetMapping("flood/{listOfStation}")
    public ResponseEntity<List< Map<String,List<AdresseParCaserne>>>> flood(@PathVariable("listOfStation") List<Integer> list) throws IOException {
        return new ResponseEntity<>( safetynetService.addresseesForFireStation(list),HttpStatus.OK);

    }



    @GetMapping("/personInfo")
    public ResponseEntity<List<PersonInfo>> personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws IOException {
        return new ResponseEntity<>( safetynetService.personInfo(firstName,lastName),HttpStatus.OK);

    }
}
