package com.stepDefinitions.swagger.petsStore;

import com.сucumberMethods.petsStore.Pet;
import com.сucumberMethods.petsStore.Printer;
import io.cucumber.java.ru.*; //Импортируем все ключевые слова
import com.сucumberMethods.petsStore.PetsStoreMethods;
import org.javatuples.Octet;
import org.json.JSONArray;

import java.util.HashMap;

public class PetsStoreSteps {

    public static String petsStatus;

    @Тогда("я могу получить данные питомца по id = {int}")
    public void я_могу_получить_данные_питомца_по(int id) {

        HashMap PetInformationById = PetsStoreMethods.getPetInformationById(id);
        Printer.printPetInformationById(PetInformationById);

    }

    @Тогда("я могу по id = {int} изменить имя пиомца на {string} и статус на {string}")
    public void я_могу_по_id_изменить_имя_пиомца_на(int id, String newPetName, String newPetStatus) {


        Pet updatePet = new Pet(id, newPetName, newPetStatus);
        PetsStoreMethods.updatePetById(updatePet);

    }

    @Тогда("я могу создать питомца по заданным параметрам : {int}, {int}, {string}, {string}, {string}, {int}, {string}, {string}")
    public void я_могу_создать_питомца_по_заданным_параметрам(int id, int categoryId, String categoryName,
                                                              String petName, String photoURLs, int tagsId,
                                                              String tagsName, String status
        ) {

        Octet<Integer, Integer, String, String, String, Integer, String, String> params = Octet.with(

                id,
                categoryId,
                categoryName,
                petName,
                photoURLs,
                tagsId,
                tagsName,
                status

        );

        Pet newPet = new Pet(params);
        PetsStoreMethods.createPet(newPet);

    }

    @Тогда("я могу получить данные питомцев по статусу = {string}")
    public void я_могу_получить_данные_питомца_по_статусу(String petsStatus) {

        this.petsStatus = petsStatus;
        HashMap PetsInformationByStatus = PetsStoreMethods.getPetsByStatus(petsStatus);
        Printer.printPetInformationByStatus(PetsInformationByStatus);

    }

}
