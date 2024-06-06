package com.ykeshtdar.safetyNet.serviceTest;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.reader.*;
import com.ykeshtdar.safetyNet.repository.*;
import com.ykeshtdar.safetyNet.service.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@AutoConfigureMockMvc
@SpringBootTest
public class MedicalRecordServiceTest {
    GetJsonNode getJsonNode =new GetJsonNode();
    Repository repository = new Repository(getJsonNode);
    MedicalrecordService medicalrecordService = new MedicalrecordService(repository);

    @Test
    public void addMedicalRecordsShouldAddNewMedicalRecordToList(){
        Medicalrecords addedMedicalRecord = new Medicalrecords("new name", "new family name", "new birthdate", "[aznol:60mg, hydrapermazol:900mg, pharmacol:5000mg, terazine:500mg]", "[peanut, shellfish, aznol]" );
        List<Medicalrecords> result = medicalrecordService.addMedicalRecords(addedMedicalRecord);
        int initialNumberOfMedicalRecord = 23;


        Assertions.assertNotNull(result);
        Assertions.assertEquals(initialNumberOfMedicalRecord+1,result.size());

    }
    @Test
    public void updatMedicalRecordsShouldReturnUpdatedList(){
                Medicalrecords updatedMedicalRecord = new Medicalrecords("Sophia", "Zemicks", "03/06/1988", "[new medication list]", "[new allergies list]" );
                List<Medicalrecords> result = medicalrecordService.updatMedicalRecords(updatedMedicalRecord);
                int initialNumberOfMedicalRecord = 23;

                Assertions.assertNotNull(result);
                Assertions.assertEquals(initialNumberOfMedicalRecord,result.size());

    }

    @Test
    public void deletMedicalRecrdShouldRemoveAMedicalRecord(){
                Medicalrecords deletedMedicalRecord = new Medicalrecords("Sophia", "Zemicks", "03/06/1988", "[aznol:60mg, hydrapermazol:900mg, pharmacol:5000mg, terazine:500mg]", "[peanut, shellfish, aznol]" );
                List<Medicalrecords> result = medicalrecordService.deletMedicalRecrd(deletedMedicalRecord);
                 int initialNumberOfMedicalRecord = 23;

                 Assertions.assertNotNull(result);
                 Assertions.assertEquals(initialNumberOfMedicalRecord-1,result.size());


    }
}
