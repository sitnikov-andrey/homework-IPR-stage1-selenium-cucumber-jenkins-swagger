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


        Pet renamePet = Pet.builder()
                .id(id)
                .petName(newPetName)
                .status(newPetStatus)
                .build();

        PetsStoreMethods.renamePetById(renamePet);

    }

    @Тогда("я могу создать питомца по заданным параметрам : {int}, {int}, {string}, {string}, {string}, {int}, {string}, {string}")
    public void я_могу_создать_питомца_по_заданным_параметрам(int id, int categoryId, String categoryName,
                                                              String petName, String photoURLs, int tagsId,
                                                              String tagsName, String status
        ) {

        Pet newPet = Pet.builder()
                .id(id)
                .categoryId(categoryId)
                .categoryName(categoryName)
                .petName(petName)
                .photoURLs(photoURLs)
                .tagsId(tagsId)
                .tagsName(tagsName)
                .status(status)
                .build();

        PetsStoreMethods.createPet(newPet);

    }

    @Тогда("я могу получить данные питомцев по статусу = {string}")
    public void я_могу_получить_данные_питомца_по_статусу(String petsStatus) {

        this.petsStatus = petsStatus;
        HashMap PetsInformationByStatus = PetsStoreMethods.getPetsByStatus(petsStatus);
        Printer.printPetInformationByStatus(PetsInformationByStatus);

    }

    @Тогда("я могу обновить данные питомца по заданным параметрам : {int}, {int}, {string}, {string}, {string}, {int}, {string}, {string}")
    public void  могу_обновить_данные_питомца_по_заданным_параметрам(int id, int categoryId, String categoryName,
                                                              String petName, String photoURLs, int tagsId,
                                                              String tagsName, String status
    ) {

        Pet updatePet = Pet.builder()
                .id(id)
                .categoryId(categoryId)
                .categoryName(categoryName)
                .petName(petName)
                .photoURLs(photoURLs)
                .tagsId(tagsId)
                .tagsName(tagsName)
                .status(status)
                .build();

        PetsStoreMethods.updatePetById(updatePet);

    }

}
