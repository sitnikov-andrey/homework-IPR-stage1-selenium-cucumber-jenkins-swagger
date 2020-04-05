package com.сucumberMethods.petsStore;

import org.javatuples.Octet;

public class JsonCreator {

    public static String createPetJson(Pet pet) {

        String newPetJson = "{ \"id\": " + pet.getId() + ", \"category\": { \"id\": " + pet.getCategoryId() + "," +
                " \"name\": \"" + pet.getCategoryName() + "\" }, \"name\": \"" + pet.getPetName() + "\"," +
                " \"photoUrls\": [ \"" + pet.getPhotoURLs() + "\" ], \"tags\": [ { \"id\": " + pet.getTagsId() +
                ", \"name\": \"" + pet.getTagsName() + "\" } ], \"status\": \"" + pet.getStatus() + "\"}";

        return newPetJson;
    }

}
