package com.сucumberMethods.petsStore;

import org.javatuples.Octet;

public class Pet {

    public int id;
    public int categoryId;
    public String categoryName;
    public String petName;
    public String photoURLs;
    public int tagsId;
    public String tagsName;
    public String status;
    public String petJson;

    public Pet(Octet<Integer, Integer, String, String, String, Integer, String, String> params) {

        this.id = params.getValue0();
        this.categoryId = params.getValue1();
        this.categoryName = params.getValue2();
        this.petName = params.getValue3();
        this.photoURLs = params.getValue4();
        this.tagsId = params.getValue5();
        this.tagsName = params.getValue6();
        this.status = params.getValue7();
        this.petJson = JsonCreator.createNewPetJson(params);

    }

    public Pet(int id, String petName, String status) {

        this.id = id;
        this.petName = petName;
        this.status = status;

    }


}


