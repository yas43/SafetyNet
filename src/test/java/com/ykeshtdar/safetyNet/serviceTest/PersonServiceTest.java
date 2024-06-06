package com.ykeshtdar.safetyNet.serviceTest;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import com.ykeshtdar.safetyNet.repository.*;
import com.ykeshtdar.safetyNet.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;

import java.io.*;
import java.util.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PersonServiceTest {
    private List<Person> personList;
    private Person john;
    private Person jacob;
    private Person tenley;
//    Repository repository;
GetJsonNode getJsonNode =new GetJsonNode();
    Repository repository = new Repository(getJsonNode);
    PersonService personService = new PersonService(repository);





//    @Mock
//    Repository repository ;

    @BeforeEach
    void setup() {
        john = new Person(
                "John",
                "Boyd",
                "1509 Culver St",
                "Culver",
                "97451",
                "841-874-6512",
                "jaboyd@email.com");
        jacob = new Person(
                "Jacob",
                "Boyd",
                "1509 Culver St",
                "Culver",
                "97451",
                "841-874-6513",
                "drk@email.com");

        tenley = new Person(
                "Tenley",
                "Boyd",
                "1509 Culver St",
                "Culver",
                "97451",
                "841-874-6512",
                "tenz@email.com");

        personList = Arrays.asList(john, jacob);

    }

    @Test
    public void postPersonToListShouldReturnListOfPerson() throws IOException {
//        Mockito.when(repository.pesonRepo()).thenReturn(personList);
        int totalNumberOfInitialExistingPerson = 23;
List<Person> result = personService.postPersontolist(tenley);


//        personService.postPersontolist(tenley);
//         Mockito.verify( personService.postPersontolist(tenley));
         Assertions.assertNotNull(result);
         Assertions.assertEquals(totalNumberOfInitialExistingPerson+1,result.size());

    }


    @Test
    public void updatrPersonShouldReturnUpdatedList(){
        Person updatedPerson = new Person("John", "Boyd", "new address", "new city", "new zip", "new phone number", "new address email" );
        List<Person> result = personService.updatrPerson(updatedPerson);
        int totalNumberOfInitialExistingPerson = 23;

        Assertions.assertNotNull(result);
        Assertions.assertEquals(totalNumberOfInitialExistingPerson,result.size());

    }

    @Test
    public void deletPersonShouldReturnUpdatedList(){
        Person deletedperson = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com" );
        List<Person> result = personService.deletPerson(deletedperson);
        int totalNumberOfInitialExistingPerson = 23;

        Assertions.assertNotNull(result);
        Assertions.assertEquals(totalNumberOfInitialExistingPerson-1,result.size());
    }
}


