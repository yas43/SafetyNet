package com.ykeshtdar.safetyNet.service;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.repository.Repository;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Service
public class MedicalrecordService {

    private static final Logger logger = LogManager.getLogger(MedicalrecordService.class);

//    @Autowired
//    Repository repository;
    private final Repository repository;

    public MedicalrecordService(Repository repository) {
        this.repository = repository;
    }


    public List<Medicalrecords> addMedicalRecords(Medicalrecords medicalrecords)  {
        List<Medicalrecords> medicalrecordsList = null;
        try {
            medicalrecordsList = repository.medicalrecordsRepo();
        } catch (IOException e) {
            logger.error("can not add given medical record to the list of medical record");
            throw new RuntimeException(e);
        }

        medicalrecordsList.add(medicalrecords);

        return medicalrecordsList;
    }


    public List<Medicalrecords> updatMedicalRecords(Medicalrecords medicalrecords)  {
        List<Medicalrecords> medicalrecordsList = null;
        try {
            medicalrecordsList = repository.medicalrecordsRepo();
        } catch (IOException e) {
            logger.error("can not update given medical record to the list of medical record");
            throw new RuntimeException(e);
        }
        for (int i=0;i<medicalrecordsList.size();i++){
            if (medicalrecordsList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(medicalrecords.getFirstName())
                    && medicalrecordsList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(medicalrecords.getLastName())){

                if (medicalrecords.getMedications() != null && !(medicalrecords.getMedications().isEmpty())){
                    medicalrecordsList.get(i).setMedications(medicalrecords.getMedications());
                }
                else {
                    medicalrecordsList.get(i).setMedications(medicalrecordsList.get(i).getMedications());
                }


                if (medicalrecords.getBirthdate() != null &&  !(medicalrecords.getBirthdate().isEmpty())){
                    medicalrecordsList.get(i).setBirthdate(medicalrecords.getBirthdate());
                }
                else {
                    medicalrecordsList.get(i).setBirthdate(medicalrecordsList.get(i).getBirthdate());
                }


                if (medicalrecords.getAllergies() != null && !(medicalrecords.getAllergies().isEmpty())){
                    medicalrecordsList.get(i).setAllergies(medicalrecords.getAllergies());
                }
                else {
                    medicalrecordsList.get(i).setAllergies(medicalrecordsList.get(i).getAllergies());
                }
            }
        }
        return medicalrecordsList;
    }


    public List<Medicalrecords> deletMedicalRecrd(Medicalrecords medicalrecords)  {
        List<Medicalrecords> medicalrecordsList = null;
        try {
            medicalrecordsList = repository.medicalrecordsRepo();
        } catch (IOException e) {
            logger.error("can not delete given medical record to the list of medical record");
            throw new RuntimeException(e);
        }
        for (int i=0;i<medicalrecordsList.size();i++){
            if (medicalrecordsList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(medicalrecords.getFirstName())
                    && medicalrecordsList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(medicalrecords.getLastName())){
                medicalrecordsList.remove(medicalrecordsList.get(i));
            }
        }
        return medicalrecordsList;
    }
}
