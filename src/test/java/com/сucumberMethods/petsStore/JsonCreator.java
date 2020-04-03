package com.сucumberMethods.petsStore;

import org.javatuples.Octet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

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

    public static void parsePetInformation(String PetInformationUglyJson) throws JSONException {

        int id;
        JSONObject category;
        int categoryId;
        String categoryName;
        String name;
        JSONArray photoUrls;
        JSONArray tags;
        int tagsId;
        String tagsName;
        String status;

        JSONObject petInformationById = new JSONObject(PetInformationUglyJson);
        id = petInformationById.getInt("id");
        System.out.println("id : " + id);

        category = petInformationById.getJSONObject("category");
        categoryId = category.getInt("id");
        categoryName = category.getString("name");
        System.out.println("category :");
        System.out.println("    id : " + categoryId);
        System.out.println("    name : " + categoryName);

        name = petInformationById.getString("name");
        System.out.println("name : " + name);

        photoUrls = petInformationById.getJSONArray("photoUrls");
        System.out.println("photoUrls :");
        for (Object photo : photoUrls){
            System.out.println("    " + photo);
        }

        tags = petInformationById.getJSONArray("tags");
        System.out.println("tags :");
        Iterator tagsItr = tags.iterator();
        while (tagsItr.hasNext()) {
            JSONObject tag = (JSONObject) tagsItr.next();
            tagsId = (Integer) tag.get("id");
            tagsName = (String) tag.get("name");
            System.out.println("    id : " + tagsId);
            System.out.println("    name : " + tagsName);
        }

        status = petInformationById.getString("status");
        System.out.println("status : " + status + "\n");


    }

}
