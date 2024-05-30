package com.ykeshtdar.safetyNet.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SafetyNetControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void phoneAlertShouldReturnListOfPhoneNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/phoneAlert/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json( "[\n" +
                        "    {\n" +
                        "        \"phoneNumber\": \"841-874-7458\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"phoneNumber\": \"841-874-7512\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"phoneNumber\": \"841-874-6513\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"phoneNumber\": \"841-874-7878\"\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void fireStationShouldReturnListOfPersonCouvertesParCaserne() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation/3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"John\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Jacob\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Tenley\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": true,\n" +
                        "        \"adults\": false\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Roger\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": true,\n" +
                        "        \"adults\": false\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Felicia\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Tessa\\\"\",\n" +
                        "        \"lastName\": \"\\\"Carman\\\"\",\n" +
                        "        \"adresse\": \"\\\"834 Binoc Ave\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": true,\n" +
                        "        \"adults\": false\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Foster\\\"\",\n" +
                        "        \"lastName\": \"\\\"Shepard\\\"\",\n" +
                        "        \"adresse\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Clive\\\"\",\n" +
                        "        \"lastName\": \"\\\"Ferguson\\\"\",\n" +
                        "        \"adresse\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6741\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Tony\\\"\",\n" +
                        "        \"lastName\": \"\\\"Cooper\\\"\",\n" +
                        "        \"adresse\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6874\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Ron\\\"\",\n" +
                        "        \"lastName\": \"\\\"Peters\\\"\",\n" +
                        "        \"adresse\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-8888\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Allison\\\"\",\n" +
                        "        \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"adresse\": \"\\\"112 Steppes Pl\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-9888\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Foster\\\"\",\n" +
                        "        \"lastName\": \"\\\"Shepard\\\"\",\n" +
                        "        \"adresse\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"Clive\\\"\",\n" +
                        "        \"lastName\": \"\\\"Ferguson\\\"\",\n" +
                        "        \"adresse\": \"\\\"748 Townings Dr\\\"\",\n" +
                        "        \"phone\": \"\\\"841-874-6741\\\"\",\n" +
                        "        \"totalNumberOfAdults\": 10,\n" +
                        "        \"totalNumberOfKids\": 3,\n" +
                        "        \"kids\": false,\n" +
                        "        \"adults\": true\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void childAlertShouldReturnListOfEnfantsHabitantsLesAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/childAlert/1509 Culver St"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"name\": \"\\\"Tenley\\\"\",\n" +
                        "        \"familyName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"age\": 12,\n" +
                        "        \"personList\": [\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"John\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jacob\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "                \"email\": \"\\\"drk@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Felicia\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"John\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jacob\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "                \"email\": \"\\\"drk@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Felicia\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"name\": \"\\\"Roger\\\"\",\n" +
                        "        \"familyName\": \"\\\"Boyd\\\"\",\n" +
                        "        \"age\": 6,\n" +
                        "        \"personList\": [\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"John\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jacob\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "                \"email\": \"\\\"drk@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Felicia\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"John\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jacob\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "                \"email\": \"\\\"drk@email.com\\\"\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Felicia\\\"\",\n" +
                        "                \"lastName\": \"\\\"Boyd\\\"\",\n" +
                        "                \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "                \"city\": \"\\\"Culver\\\"\",\n" +
                        "                \"zip\": \"\\\"97451\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6544\\\"\",\n" +
                        "                \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void fireShouldReturnListOfHabitantsParAdresse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fire/112 Steppes Pl"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "    \"\\\"4\\\"\": [\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Tony\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-6874\\\"\",\n" +
                        "            \"age\": 30,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"hydrapermazol:300mg\\\",\\\"dodoxadin:30mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Ron\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-8888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Allison\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-9888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"aznol:200mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Tony\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-6874\\\"\",\n" +
                        "            \"age\": 30,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"hydrapermazol:300mg\\\",\\\"dodoxadin:30mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Ron\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-8888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Allison\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-9888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"aznol:200mg\\\"]\"\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"\\\"3\\\"\": [\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Tony\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-6874\\\"\",\n" +
                        "            \"age\": 30,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"hydrapermazol:300mg\\\",\\\"dodoxadin:30mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Ron\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-8888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Allison\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-9888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"aznol:200mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Tony\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-6874\\\"\",\n" +
                        "            \"age\": 30,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"hydrapermazol:300mg\\\",\\\"dodoxadin:30mg\\\"]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Ron\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-8888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[]\"\n" +
                        "            ]\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"firsName\": \"\\\"Allison\\\"\",\n" +
                        "            \"phone\": \"\\\"841-874-9888\\\"\",\n" +
                        "            \"age\": 59,\n" +
                        "            \"medication\": [\n" +
                        "                \"[\\\"aznol:200mg\\\"]\"\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void floodShouldReturnListOfAdresseParCaserne() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/flood/1,2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"\\\"1\\\"\": [\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Peter\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6512\\\"\",\n" +
                        "                \"age\": 23,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[\\\"shellfish\\\"]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Reginold\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-8547\\\"\",\n" +
                        "                \"age\": 44,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[\\\"illisoxian\\\"]\",\n" +
                        "                    \"[\\\"thradox:700mg\\\"]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jamie\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7462\\\"\",\n" +
                        "                \"age\": 42,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Brian\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7784\\\"\",\n" +
                        "                \"age\": 48,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[\\\"nillacilan\\\"]\",\n" +
                        "                    \"[\\\"ibupurin:200mg\\\",\\\"hydrapermazol:400mg\\\"]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Shawna\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7784\\\"\",\n" +
                        "                \"age\": 43,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Kendrik\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7784\\\"\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[\\\"noxidian:100mg\\\",\\\"pharmacol:2500mg\\\"]\"\n" +
                        "                ]\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"\\\"2\\\"\": [\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Jonanathan\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-6513\\\"\",\n" +
                        "                \"age\": 35,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Sophia\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7878\\\"\",\n" +
                        "                \"age\": 36,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[\\\"peanut\\\",\\\"shellfish\\\",\\\"aznol\\\"]\",\n" +
                        "                    \"[\\\"aznol:60mg\\\",\\\"hydrapermazol:900mg\\\",\\\"pharmacol:5000mg\\\",\\\"terazine:500mg\\\"]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Warren\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7512\\\"\",\n" +
                        "                \"age\": 39,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Zach\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7512\\\"\",\n" +
                        "                \"age\": 7,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[]\"\n" +
                        "                ]\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"firstName\": \"\\\"Eric\\\"\",\n" +
                        "                \"phone\": \"\\\"841-874-7458\\\"\",\n" +
                        "                \"age\": 78,\n" +
                        "                \"medicalbackgroundlist\": [\n" +
                        "                    \"[]\",\n" +
                        "                    \"[\\\"tradoxidine:400mg\\\"]\"\n" +
                        "                ]\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void personInfoShouldReturnListOfPersonInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/personInfo?firstName=John&lastName=Boyd"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"firstName\": \"\\\"John\\\"\",\n" +
                        "        \"address\": \"\\\"1509 Culver St\\\"\",\n" +
                        "        \"age\": 40,\n" +
                        "        \"email\": \"\\\"jaboyd@email.com\\\"\",\n" +
                        "        \"medicationhistory\": [\n" +
                        "            \"[\\\"aznol:350mg\\\",\\\"hydrapermazol:100mg\\\"]\",\n" +
                        "            \"[\\\"nillacilan\\\"]\"\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

@Test
    public void communityEmailShouldReturnListOfCommunityEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail/Culver"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"tcoop@ymail.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"jaboyd@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"ward@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"zarc@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"bstel@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"lily@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"ssanw@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"soph@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"drk@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"gramps@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"tenz@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"jpeter@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"clivfd@ymail.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"reg@email.com\\\"\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"email\": \"\\\"aly@imail.com\\\"\"\n" +
                        "    }\n" +
                        "]"));
}
}
