package com.сucumberMetods.petsStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import com.сucumberMetods.swagger.SwaggerLocators;
import java.io.IOException;
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
                while ((line = reader.readLine()) != null){
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

}
