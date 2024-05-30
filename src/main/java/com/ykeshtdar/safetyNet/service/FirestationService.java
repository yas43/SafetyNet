package com.ykeshtdar.safetyNet.service;

import com.ykeshtdar.safetyNet.model.*;
import com.ykeshtdar.safetyNet.repository.Repository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.io.*;
import java.util.*;
@Service
public class FirestationService {
    @Autowired
    Repository repository;



    public List<Firestations> addFireStation(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        firestationsList.add(firestations);
        return firestationsList;



    }


    public List<Firestations> updateFireStations(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        for (int i=0;i<firestationsList.size();i++){
            if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())){

                firestationsList.get(i).setStation(firestations.getStation());
            }

        }

        return  firestationsList;
    }



    public List<Firestations> deleteFireStations(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
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
