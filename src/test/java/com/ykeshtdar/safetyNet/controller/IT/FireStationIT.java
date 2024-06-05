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

@SpringBootTest
@AutoConfigureMockMvc
public class FireStationIT {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void addFireStationShouldAFireStationToListOfFireStation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"address\":\"new address\", \"station\":\"new number\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"29 15th St\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"834 Binoc Ave\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"644 Gershwin Cir\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"489 Manchester St\\\"\",\n" +
                        "        \"station\": \"\\\"4\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"892 Downing Ct\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"908 73rd St\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"station\": \"\\\"4\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"947 E. Rose Dr\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"951 LoneTree Rd\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"new address\",\n" +
                        "        \"station\": \"new number\"\n" +
                        "    }\n" +
                        "]"));

    }

    @Test
    public void updateFireStationShouldReturnNewUpdatedFireStationList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"address\":\"1509 Culver St\", \"station\":\"new number\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"station\": \"new number\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"29 15th St\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"834 Binoc Ave\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"644 Gershwin Cir\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"489 Manchester St\\\"\",\n" +
                        "        \"station\": \"\\\"4\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"892 Downing Ct\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"908 73rd St\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"station\": \"\\\"4\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"947 E. Rose Dr\\\"\",\n" +
                        "        \"station\": \"\\\"1\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"station\": \"\\\"3\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"address\": \"\\\"951 LoneTree Rd\\\"\",\n" +
                        "        \"station\": \"\\\"2\\\"\"\n" +
                        "    }\n" +
                        "]"));


    }
    @Test
    public void deleteFirestationShouldReturnNewUpdatedListOfFireStation() throws Exception {
        int totalnumberofirestations = 13;
        mockMvc.perform(MockMvcRequestBuilders.delete("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"address\":\"1509 Culver St\", \"station\":\"number\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(totalnumberofirestations-1)));

    }
}

