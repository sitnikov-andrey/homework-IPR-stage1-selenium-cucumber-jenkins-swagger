package com.сucumberMethods.petsStore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pet {

    private int id;
    private int categoryId;
    private String categoryName;
    private String petName;
    private String photoURLs;
    private int tagsId;
    private String tagsName;
    private String status;
    private String avatarPhoto;
    private String metadata;

}