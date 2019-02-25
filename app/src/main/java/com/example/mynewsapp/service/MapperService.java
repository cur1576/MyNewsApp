package com.example.mynewsapp.service;



import com.example.mynewsapp.model.Result;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperService {
    ObjectMapper mapper = new ObjectMapper();

    public MapperService(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,false);
    }

    // Hier passiert MAgic
    public Result unmarshall(String json) throws Exception{
        Result model = mapper.readValue(json, Result.class);
        return model;
    }
}
