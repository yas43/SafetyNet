package com.ykeshtdar.safetyNet.controller;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.apache.logging.log4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<List<Person>> addPerson(@RequestBody Person person) throws IOException {
        logger.info("request for add a person");
        return new ResponseEntity<>(personService.postPersontolist(person),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<Person>> updateexistingperson(@RequestBody Person person) throws IOException {
        logger.info("request for update a person");
        return new ResponseEntity<>( personService.updatrPerson(person),HttpStatus.OK);
    }

    @DeleteMapping()

    public ResponseEntity<List<Person>> deleteExistingPerson(@RequestBody Person person) throws IOException {
        logger.info("request for delete a person");
        return  new ResponseEntity<>(personService.deletPerson(person),HttpStatus.OK);
    }
}
