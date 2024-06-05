package com.ykeshtdar.safetyNet.controller.IT;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static org.hamcrest.Matchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PersonIT {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void addPersonShouldAddNewPersonToListOfPerson() throws Exception {
        int totalNumberOfPersonInGivenJson = 23;
        mockMvc.perform(MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\":\"yaser\", \"lastName\":\"keshtdar\", \"address\":\"1 rue de condat\", \"city\":\"rennes\", \"zip\":\"35760\", \"phone\":\"555555550\", \"email\":\"yhgf@yahoo.com\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(totalNumberOfPersonInGivenJson+1)));
    }


    @Test
    public void updatePersonShouldReturnUpdatedList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1 rue de condat\", \"city\":\"rennes\", \"zip\":\"35760\", \"phone\":\"555555550\", \"email\":\"yhgf@yahoo.com\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(23)));
    }

    @Test
    public void deletePersonShouldReturnNewList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1 rue de condat\", \"city\":\"rennes\", \"zip\":\"35760\", \"phone\":\"555555550\", \"email\":\"yhgf@yahoo.com\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(22)));



    }
}
