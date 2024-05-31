package com.ykeshtdar.safetyNet.repository;

import com.ykeshtdar.safetyNet.*;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;

import java.io.*;
import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonRepositoryTest {

//    private Person firstperson;
//    private Person secondperson;
//    private Person thirdperson;
//    private  List<Person> personlist;
//
//    @BeforeEach
//    void setup(){
//        firstperson = new Person("John","Boyd","1509 Culver St","Culver","97451","841-874-6512","jaboyd@email.com");
//        secondperson = new Person("Tenley","Boyd","1509 Culver St","Culver","97451","841-874-6512","tenz@email.com");
//        thirdperson = new Person("Jacob","Boyd","1509 Culver St","Culver","97451","841-874-6513","drk@email.com");
//
//    personlist = Arrays.asList(firstperson,secondperson,thirdperson);
//    }
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    Repository repository;
//    @MockBean
//    GetJsonNode getJsonNode;
    @Autowired
    Repository repository;

    @Test
    public void personRepoShouldReturnListOfPerson() throws IOException {
//        Mockito.when(repository.pesonRepo()).thenReturn(personlist);

//        List<Person> expectedList = new LinkedList<>();
//        expectedList = Arrays.asList();

        Assertions.assertEquals(23,repository.pesonRepo().size());
        Assertions.assertNotNull(repository.pesonRepo());

    }
}
