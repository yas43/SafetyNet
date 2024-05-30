package com.ykeshtdar.safetyNet.controller;

import com.ykeshtdar.safetyNet.dto.*;
import com.ykeshtdar.safetyNet.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("firestation")
public class SafteyNetController {

    private final SafetynetService safetynetService;

    public SafteyNetController(SafetynetService safetynetService) {
        this.safetynetService = safetynetService;
    }

    @GetMapping("/{station_number}")
    public ResponseEntity<List<PersonnesCouvertesParCaserne>> personCovered(@PathVariable("station_number") int station_number) throws IOException {
        return new ResponseEntity<>(safetynetService.coveredPersonsRepo(station_number),HttpStatus.OK);
    }
}
