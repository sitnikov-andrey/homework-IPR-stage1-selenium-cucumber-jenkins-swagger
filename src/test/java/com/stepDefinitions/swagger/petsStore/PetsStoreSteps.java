package com.stepDefinitions.swagger.petsStore;

import io.cucumber.java.ru.*; //Импортируем все ключевые слова
import com.сucumberMetods.petsStore.PetsStoreMetods;

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

}
