package com.ykeshtdar.safetyNet.reader;

import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class GetJsonNode {
    private static final ObjectMapper mapper = new ObjectMapper();

    public  static JsonNode getPersonNode() throws IOException {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("persons");

    }

    public static JsonNode getFireStationNode() throws IOException {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("firestations");

    }

    public static JsonNode getMedicalRecordsNode() throws IOException {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("medicalrecords");

    }


    public JsonNode JsonReaderFileAll() throws IOException {
        InputStream Input =
                GetJsonNode.class.getClassLoader()
                        .getResourceAsStream("data.json");

       return mapper.readTree(Input);


    }


}
