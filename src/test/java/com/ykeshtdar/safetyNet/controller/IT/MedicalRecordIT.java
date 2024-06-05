package com.ykeshtdar.safetyNet.controller.IT;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static org.hamcrest.Matchers.hasSize;

@AutoConfigureMockMvc
@SpringBootTest
public class MedicalRecordIT {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void addMedicalRecordShouldAddNewMedicalRecordToList() throws Exception {
        int totalNumberOfMedicalRecord = 23;
        mockMvc.perform(MockMvcRequestBuilders.post("/medicalrecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\":\"new name\", \"lastName\":\"new family\", \"birthdate\":\"03/06/1985\", \"medications\":\"[]\", \"allergies\":\"[]\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(totalNumberOfMedicalRecord+1)));

    }
    @Test
    public void deleteMedicalRecordShouldReturnNewUpdateMedicalRecord() throws Exception {
        int totalNumberOfMedicalRecord = 23;
        mockMvc.perform(MockMvcRequestBuilders.delete("/medicalrecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"birthdate\":\"03/06/1985\", \"medications\":\"[]\", \"allergies\":\"[]\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(totalNumberOfMedicalRecord-1)));
    }
}
