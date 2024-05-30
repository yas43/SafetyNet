package com.ykeshtdar.safetyNet.controller;


import com.ykeshtdar.safetyNet.*;
import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MedicalrecordService medicalRecordService;

    private List<Medicalrecords> medicalRecordList;

    private Medicalrecords johnsMedicalRecord;
    private Medicalrecords jacobsMedicalRecord;
    private Medicalrecords tenleyMedicalRecord;

    @BeforeEach
    void setup() {
        johnsMedicalRecord = new Medicalrecords(
                "John",
                "Boyd",
                "03/06/1984",
               "[aznol:350mg, hydrapermazol:100mg]",
                "[nillacilan]");
        jacobsMedicalRecord = new Medicalrecords(
                "Jacob",
                "Boyd",
                "03/06/1989",
                "[pharmacol:5000mg, terazine:10mg, noznazol:250mg]",
                "[]");

        tenleyMedicalRecord = new Medicalrecords(
                "Tenley",
                "Boyd",
                "02/18/2012",
                "[]",
                "[peanut]");

        medicalRecordList = Arrays.asList(johnsMedicalRecord, jacobsMedicalRecord, tenleyMedicalRecord);
    }



    @Test
    public void addMedicalRecordShouldReturnMedicalRecord() throws Exception{
        when(medicalRecordService.addMedicalRecords(johnsMedicalRecord)).thenReturn(medicalRecordList);
        mvc.perform(post("/medicalrecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUtils.asJsonString(johnsMedicalRecord)))
                .andDo(print())
                .andExpect(status().isOk());
    }



    @Test
    public void updateMedicalRecordShouldReturnMedicalRecord() throws Exception{
        when(medicalRecordService.updatMedicalRecords(johnsMedicalRecord)).thenReturn(medicalRecordList);
        mvc.perform(put("/medicalrecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(johnsMedicalRecord)))
                .andDo(print())
                .andExpect(status().isOk());
    }



    @Test
    public void deleteMedicalRecordShouldShouldReturnList() throws Exception{
        when(medicalRecordService.deletMedicalRecrd(johnsMedicalRecord)).thenReturn(medicalRecordList);
        mvc.perform(delete("/medicalrecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(johnsMedicalRecord)));


    }


}
