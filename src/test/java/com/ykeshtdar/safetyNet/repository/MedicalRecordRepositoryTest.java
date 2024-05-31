package com.ykeshtdar.safetyNet.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;

import java.io.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordRepositoryTest {
    @Autowired
    Repository repository;
    @Test
    public void medicalrecordRepoShouldReturnListOfMedicalrecord() throws IOException {
        Assertions.assertEquals(23,repository.medicalrecordsRepo().size());
        Assertions.assertNotNull(repository.medicalrecordsRepo());

    }
}
