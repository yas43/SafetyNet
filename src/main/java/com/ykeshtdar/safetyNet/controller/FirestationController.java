package com.ykeshtdar.safetyNet.controller;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.apache.logging.log4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping(("/firestation"))
public class FirestationController {

    private static final Logger logger= LogManager.getLogger(FirestationController.class);


    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }



    @PostMapping
    public ResponseEntity<List<Firestations>> addFireStation(@RequestBody Firestations firestations) throws IOException {
        logger.info("request for add a fireStation ");
        return new ResponseEntity<>( firestationService.addFireStation(firestations),HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<List<Firestations>> updateExistingFireStation(@RequestBody Firestations firestations) throws IOException {
        logger.info("request for update a fireStation");
        return new ResponseEntity<>( firestationService.updateFireStations(firestations),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Firestations>> removeFireStation(@RequestBody Firestations firestations) throws IOException {
        logger.info("request for delete a fireStation");
        return  new ResponseEntity<>(firestationService.deleteFireStations(firestations),HttpStatus.OK);
    }
}
