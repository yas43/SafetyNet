package com.ykeshtdar.safetyNet.reader;

import com.fasterxml.jackson.databind.*;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class GetJsonNode {

    private static final Logger logger = LogManager.getLogger(GetJsonNode.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public   JsonNode getPersonNode()  {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(Input);
        } catch (IOException e) {
            logger.error("problem for reading Person Node in Json file ");
            throw new RuntimeException(e);
        }
        return rootNode.path("persons");

    }

    public  JsonNode getFireStationNode()  {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(Input);
        } catch (IOException e) {
            logger.error("problem for reading Fire Station Node in Json file ");
            throw new RuntimeException(e);
        }
        return rootNode.path("firestations");

    }

    public  JsonNode getMedicalRecordsNode()  {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(Input);
        } catch (IOException e) {
            logger.error("problem for reading Medical Record Node in Json file ");
            throw new RuntimeException(e);
        }
        return rootNode.path("medicalrecords");

    }


    public JsonNode JsonReaderFileAll() throws IOException {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

       return mapper.readTree(Input);


    }


}
