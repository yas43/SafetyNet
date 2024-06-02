package com.ykeshtdar.safetyNet.controller;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.apache.logging.log4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("medicalrecord")
public class MedicalrecordController {

    private static final Logger logger = LogManager.getLogger(MedicalrecordController.class);
    private final MedicalrecordService medicalrecordService;

    public MedicalrecordController(MedicalrecordService medicalrecordService) {
        this.medicalrecordService = medicalrecordService;
    }


    @PostMapping
    public ResponseEntity<List<Medicalrecords>> addMedicalRecord(@RequestBody Medicalrecords medicalrecords) throws IOException {
        logger.info("request for add a medicalRecord");
        return new ResponseEntity<>( medicalrecordService.addMedicalRecords(medicalrecords),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<Medicalrecords>> updateExistingFireStation(@RequestBody Medicalrecords medicalrecords) throws IOException {
        logger.info("request for update a medicalRecord");
        return new ResponseEntity<>(medicalrecordService.updatMedicalRecords(medicalrecords),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Medicalrecords>> removeExistingMedicalRecord(@RequestBody Medicalrecords medicalrecords) throws IOException {
        logger.info("request for delete a medicalRecord");
        return new ResponseEntity<>( medicalrecordService.deletMedicalRecrd(medicalrecords),HttpStatus.OK);
    }
}
