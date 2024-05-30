package com.ykeshtdar.safetyNet.controller;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

//    private final PostPerson postPerson;
//    private final UpdatrPerson updatrPerson;
//    private final DeletePerson deletePerson;
//
//    public PersonController(PostPerson postPerson, UpdatrPerson updatrPerson, DeletePerson deletePerson) {
//        this.postPerson = postPerson;
//        this.updatrPerson = updatrPerson;
//        this.deletePerson = deletePerson;
//
//    }

    //    @Autowired
//    PostPerson postPerson;
//    @Autowired
//    UpdatrPerson updatrPerson;
//    @Autowired
//    DeletePerson deletePerson;
    @PostMapping
    public ResponseEntity<List<Person>> addPerson(@RequestBody Person person) throws IOException {
//        PostPerson postPerson = new PostPerson();
//        System.out.println("hello i am here yaseram");
        return new ResponseEntity<>(personService.postPersontolist(person),HttpStatus.OK);
    }

    @PutMapping

    public ResponseEntity<List<Person>> updateexistingperson(@RequestBody Person person) throws IOException {
//        UpdatrPerson updatrPerson = new UpdatrPerson();

        return new ResponseEntity<>( personService.updatrPerson(person),HttpStatus.OK);
    }

    @DeleteMapping()

    public ResponseEntity<List<Person>> deleteExistingPerson(@RequestBody Person person) throws IOException {
//        DeletePerson deletePerson = new DeletePerson();
        return  new ResponseEntity<>(personService.deletPerson(person),HttpStatus.OK);
    }
}
