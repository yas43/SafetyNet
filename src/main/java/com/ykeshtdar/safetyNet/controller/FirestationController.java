package com.ykeshtdar.safetyNet.controller;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping(("/firestation"))
public class FirestationController {

    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }



    @PostMapping
    public ResponseEntity<List<Firestations>> addFireStation(@RequestBody Firestations firestations) throws IOException {
        return new ResponseEntity<>( firestationService.addFireStation(firestations),HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<List<Firestations>> updateExistingFireStation(@RequestBody Firestations firestations) throws IOException {
        return new ResponseEntity<>( firestationService.updateFireStations(firestations),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Firestations>> removeFireStation(@RequestBody Firestations firestations) throws IOException {
        return  new ResponseEntity<>(firestationService.deleteFireStations(firestations),HttpStatus.OK);
    }
}
