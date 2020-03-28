package com.сucumberMetods.petsStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import com.сucumberMetods.swagger.SwaggerLocators;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class PetsStoreMetods {

    private static HttpURLConnection connection;
    public static URL url;
    public static String jsonResponse;

    public static HashMap getPetInformationById(int id) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        Map<Integer, String> responseAndStatus = new HashMap<Integer, String>();
        int status;

        try {
            url = new URL(SwaggerLocators.urlPetStorePetId + id); //К URL petstore добавляем id
            connection = (HttpURLConnection) url.openConnection(); //Открываем коннект, если URL был корректный

            //Настройка запроса
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            status = connection.getResponseCode(); //Получаем статус ответа

            if (status == 200) {
                //Если статус 200, то значит все ок. Мы получаем данные и передаем их в jsonResponse
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                jsonResponse = responseContent.toString(); //Записываем json ответ в переменную
                responseAndStatus.put(status, jsonResponse);
                return (HashMap) responseAndStatus;

            } else if (status == 404) {

                responseAndStatus.put(status, "Pet not found");
                return (HashMap) responseAndStatus;

            } else if (status == 400) {

                responseAndStatus.put(status, "Invalid ID supplied");
                return (HashMap) responseAndStatus;

            } else {
                //Если статус не соответствует выше перечисленным, то получаем ответ ошибки и передаем его как текст в исключение
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                throw new IOException(responseContent.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void printPetInformationById(HashMap<Integer, String> PetInformation) {

        for (Integer key : PetInformation.keySet()) {
            if (key == 400 || key == 404) {
                System.out.println("Статус : " + key);
                System.out.println(PetInformation.get(key));
            } else if (key == 200) {
                System.out.println("Статус : " + key);
                parsePetInformationById(PetInformation.get(key));
            }
        }

    }

    public static void parsePetInformationById(String PetInformationUglyJson) throws JSONException {

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
        System.out.println("status : " + status);

    }

}
