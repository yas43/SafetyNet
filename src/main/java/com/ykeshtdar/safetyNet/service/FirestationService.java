package com.ykeshtdar.safetyNet.service;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.repository.Repository;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.io.*;
import java.util.*;
@Service
public class FirestationService {

    private static final Logger logger = LogManager.getLogger(FirestationService.class);
//    @Autowired
//    Repository repository;
    private final Repository repository;

    public FirestationService(Repository repository) {
        this.repository = repository;
    }


    public List<Firestations> addFireStation(Firestations firestations)  {
        List<Firestations> firestationsList = null;
        try {
            firestationsList = repository.firestationRepo();
        } catch (IOException e) {
            logger.error("can not add given Fire Station to the list of Fire Station");
            throw new RuntimeException(e);
        }
        firestationsList.add(firestations);
        return firestationsList;



    }


    public List<Firestations> updateFireStations(Firestations firestations)  {
        List<Firestations> firestationsList = null;
        try {
            firestationsList = repository.firestationRepo();
        } catch (IOException e) {
            logger.error("can not update given Fire Station to the list of Fire Station");
            throw new RuntimeException(e);
        }
        for (int i=0;i<firestationsList.size();i++){
            if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())){

                firestationsList.get(i).setStation(firestations.getStation());
            }

        }

        return  firestationsList;
    }



    public List<Firestations> deleteFireStations(Firestations firestations)  {
        List<Firestations> firestationsList = null;
        try {
            firestationsList = repository.firestationRepo();
        } catch (IOException e) {
            logger.error("can not delete given Fire Station from the list of Fire Station");
            throw new RuntimeException(e);
        }
        List<Firestations> firestationsListdeleted = new LinkedList<>();
        for (int i = 0; i < firestationsList.size(); i++) {

            if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())
                    || firestationsList.get(i).getStation().replace("\"", "").equalsIgnoreCase(firestations.getStation())) {


                firestationsListdeleted.add(firestationsList.get(i));


            }
        }
        for (Firestations firestations1:firestationsListdeleted){
            firestationsList.remove(firestations1);
        }
        return firestationsList;
    }
}
