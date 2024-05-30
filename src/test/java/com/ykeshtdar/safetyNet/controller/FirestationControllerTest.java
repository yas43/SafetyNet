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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    FirestationService firestationService;

    private List<Firestations> firestationList;

    private Firestations firstFirestation;
    private Firestations secondFirestation;
    private Firestations thirdFirestation;

    @BeforeEach
     void setup() {
        firstFirestation = new Firestations(
                "3",
                "1509 Culver St");
        secondFirestation = new Firestations(
                "2",
                "29 15th St");

        thirdFirestation = new Firestations(
                "3",
                "834 Binoc Ave"
        );

        firestationList = Arrays.asList(firstFirestation, secondFirestation, thirdFirestation);
    }

    @Test
    public void getAllFirestationShouldReturnListOfFirestations() throws Exception{
        when(firestationService.addFireStation(firstFirestation)).thenReturn(firestationList);
        mvc.perform(post("http://localhost:8080/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUtils.asJsonString(firstFirestation)))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void updateFirestationShouldReturnFirestation() throws Exception{
        when(firestationService.updateFireStations(firstFirestation)).thenReturn(firestationList);
        mvc.perform(put("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(firstFirestation)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFirestationShouldReturnNoContent() throws Exception{
        when(firestationService.deleteFireStations(firstFirestation)).thenReturn(firestationList);
        mvc.perform(delete("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(firstFirestation)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
