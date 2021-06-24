package com.brandythewuff;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class JsonParse{
    private ObjectMapper jsonMapper = new ObjectMapper();

    public JsonParse(){
        // REMOVE WHEN ALL DATATYPES DEFINED AND COMPLETE
        // Stops JsonParser from complaining when it enounters data not defined
        // in the object it's meant to put it into
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Keep this, means won't serialize null values
        //jsonMapper.setSerializationInclusion(Include.NON_NULL);
    }

    public <T> T parseResponse(HashMap<String, String> responseData, Class<T> type){
        T JResponse = null;
        try{
            JResponse = jsonMapper.readValue(responseData.get("Data"), type);
        }
        catch(Exception e){
            System.out.println("Parsing to JSON failed: " + e.getMessage());
        }
        return JResponse;
    }
}