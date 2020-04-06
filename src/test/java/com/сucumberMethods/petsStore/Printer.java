package com.сucumberMethods.petsStore;

import com.stepDefinitions.swagger.petsStore.PetsStoreSteps;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NotFoundException;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;

public class Printer {

    public static void printPetInformationById(HashMap<Integer, String> PetInformation) {

        for (Integer key : PetInformation.keySet()) {
            if (key == 400 || key == 404) {
                System.out.println("Статус : " + key);
                throw new NotFoundException(PetInformation.get(key));

            } else if (key == 200) {
                System.out.println("Статус : " + key);
                System.out.println("Данные питомца удачно получены :");
                parsePetInformation(PetInformation.get(key));
            }
        }

    }

    public static void printPetInformationByStatus(HashMap<Integer, String> PetInformation) {

        for (Integer key : PetInformation.keySet()) {
            if (key == 400 || key == 404) {
                System.out.println("Статус : " + key);
            } else if (key == 200) {
                System.out.println("Статус : " + key);
                JSONArray jsonResponseList = new JSONArray(PetInformation.get(key));
                if (jsonResponseList.length() == 0){
                    System.err.println("Питомцев со статусом = '" + PetsStoreSteps.petsStatus + "' не существует");
                    throw new EmptyStackException();
                }else{
                    for (Object json : jsonResponseList){
                        parsePetInformation(json.toString());
                    }
                }

            }
        }

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

        JSONObject petInformation = new JSONObject(PetInformationUglyJson);
        id = petInformation.getInt("id");
        System.out.println("id : " + id);

        category = petInformation.getJSONObject("category");
        categoryId = category.getInt("id");
        categoryName = category.getString("name");
        System.out.println("category :");
        System.out.println("    id : " + categoryId);
        System.out.println("    name : " + categoryName);

        name = petInformation.getString("name");
        System.out.println("name : " + name);

        photoUrls = petInformation.getJSONArray("photoUrls");
        System.out.println("photoUrls :");
        for (Object photo : photoUrls){
            System.out.println("    " + photo);
        }

        tags = petInformation.getJSONArray("tags");
        System.out.println("tags :");
        Iterator tagsItr = tags.iterator();
        while (tagsItr.hasNext()) {
            JSONObject tag = (JSONObject) tagsItr.next();
            tagsId = (Integer) tag.get("id");
            tagsName = (String) tag.get("name");
            System.out.println("    id : " + tagsId);
            System.out.println("    name : " + tagsName);
        }

        status = petInformation.getString("status");
        System.out.println("status : " + status + "\n");


    }

}
