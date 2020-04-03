package com.сucumberMethods.petsStore;

import com.stepDefinitions.swagger.petsStore.PetsStoreSteps;
import org.json.JSONArray;

import java.util.EmptyStackException;
import java.util.HashMap;

public class Printer {

    public static void printPetInformationById(HashMap<Integer, String> PetInformation) {

        for (Integer key : PetInformation.keySet()) {
            if (key == 400 || key == 404) {
                System.out.println("Статус : " + key);
                System.out.println(PetInformation.get(key));
            } else if (key == 200) {
                System.out.println("Статус : " + key);
                JsonCreator.parsePetInformation(PetInformation.get(key));
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
                        JsonCreator.parsePetInformation(json.toString());
                    }
                }

            }
        }

    }

}
