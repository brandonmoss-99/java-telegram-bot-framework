package com.brandythewuff;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialize{
    private ObjectMapper jsonSerializer;

    public JsonSerialize(){
        jsonSerializer = new ObjectMapper();
        jsonSerializer.setSerializationInclusion(Include.NON_NULL);
    }

    public <T> String serialize(T toSerialize){
        String serialized;
        try{
            serialized = jsonSerializer.writeValueAsString(toSerialize);
        }
        catch(Exception e){
            serialized = null;
            System.out.println("Failed: " + e.getLocalizedMessage());
        }
        return serialized;
    }
}