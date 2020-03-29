package com.stepDefinitions.swagger.petsStore;

import io.cucumber.java.ru.*; //Импортируем все ключевые слова
import com.сucumberMetods.petsStore.PetsStoreMetods;
import org.javatuples.Octet;

import java.util.HashMap;

public class PetsStoreSteps {

    @Тогда("я могу получить данные питомца по id = {int}")
    public void я_могу_получить_данные_питомца_по(int id) {

        HashMap PetInformationById = PetsStoreMetods.getPetInformationById(id);
        PetsStoreMetods.printPetInformationById(PetInformationById);

    }

    @Тогда("я могу по id = {int} изменить имя пиомца на {string} и статус на {string}")
    public void я_могу_по_id_изменить_имя_пиомца_на(int id, String newPetName, String newPetStatus) {

    PetsStoreMetods.updatePetById(id, newPetName, newPetStatus);

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

        PetsStoreMetods.createPet(params);

    }

}
