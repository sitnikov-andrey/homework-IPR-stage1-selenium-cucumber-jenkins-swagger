package com.сucumberMethods.petsStore;

import org.javatuples.Octet;

public class JsonCreator {

    public static String createNewPetJson(Octet<Integer, Integer, String, String, String, Integer, String, String> params) {

        int id = params.getValue0();
        int categoryId = params.getValue1();
        String categoryName = params.getValue2();
        String petName = params.getValue3();
        String photoURLs = params.getValue4();
        int tagsId = params.getValue5();
        String tagsName = params.getValue6();
        String status = params.getValue7();

        String newPetJson = "{ \"id\": " + id + ", \"category\": { \"id\": " + categoryId + "," +
                " \"name\": \"" + categoryName + "\" }, \"name\": \"" + petName + "\"," +
                " \"photoUrls\": [ \"" + photoURLs + "\" ], \"tags\": [ { \"id\": " + tagsId + ", \"name\": \"" + tagsName + "\" } ]," +
                " \"status\": \"" + status + "\"}";

        return newPetJson;
    }

}
