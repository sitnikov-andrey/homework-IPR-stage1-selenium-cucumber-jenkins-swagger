package com.сucumberMethods.petsStore;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;

import com.сucumberMethods.swagger.SwaggerLocators;
import org.openqa.selenium.NotFoundException;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class PetsStoreMethods {

    private static HttpURLConnection connection;
    public static URL url;
    public static String jsonResponse;

    public static HashMap getPetInformationById(int id) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        Map<Integer, String> responseAndStatus = new HashMap<Integer, String>();
        int responseStatus;

        try {
            url = new URL(SwaggerLocators.urlPetStorePetId + id); //К URL petstore добавляем id
            connection = (HttpURLConnection) url.openConnection(); //Открываем коннект, если URL был корректный

            //Настройка запроса
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            responseStatus = connection.getResponseCode(); //Получаем статус ответа

            if (responseStatus == 200) {
                //Если статус 200, то значит все ок. Мы получаем данные и передаем их в jsonResponse
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                jsonResponse = responseContent.toString(); //Записываем json ответ в переменную
                responseAndStatus.put(responseStatus, jsonResponse);
                return (HashMap) responseAndStatus;

            } else if (responseStatus == 404) {

                responseAndStatus.put(responseStatus, "Pet not found");
                return (HashMap) responseAndStatus;

            } else if (responseStatus == 400) {

                responseAndStatus.put(responseStatus, "Invalid ID supplied");
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

    public  static HashMap getPetsByStatus(String petsStatus){

        BufferedReader reader;
        String line;
        Map<Integer, String> responseAndStatus = new HashMap<Integer, String>();
        StringBuffer responseContent = new StringBuffer();
        int responseStatus;

        try {
            url = new URL(SwaggerLocators.urlPetStorePetsStatus + petsStatus); //К URL petstore добавляем id
            connection = (HttpURLConnection) url.openConnection(); //Открываем коннект, если URL был корректный

            //Настройка запроса
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            responseStatus = connection.getResponseCode(); //Получаем статус ответа

            if (responseStatus == 200) {
                //Если статус 200, то значит все ок. Мы получаем данные и передаем их в jsonResponse
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

                jsonResponse = responseContent.toString(); //Записываем json ответ в переменную
                responseAndStatus.put(responseStatus, jsonResponse);

                return (HashMap) responseAndStatus;

            } else if (responseStatus == 400) {

                System.out.println("Invalid status value");
                responseAndStatus.put(responseStatus, jsonResponse);

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

    public static void renamePetById(Pet renamePet) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        Map<Integer, String> responseAndStatus = new HashMap<Integer, String>();
        int responseStatus;

        try {

            url = new URL(SwaggerLocators.urlPetStorePetId + renamePet.getId()); //К URL petstore добавляем id
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", SwaggerLocators.USER__AGENT);
            connection.setRequestProperty("Accept-Language", SwaggerLocators.ACCEPT_LANGUAGE);
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            String urlParameters = "name=" + renamePet.getPetName() + "&status=" + renamePet.getStatus();

            //Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            responseStatus = connection.getResponseCode(); //Получаем статус ответа
            System.out.println("Статус : " + responseStatus);

            if (responseStatus == 200) {

                System.out.println("Новое имя питомца : " + renamePet.getPetName());
                System.out.println("Новый статус питомца : " + renamePet.getStatus());

            } else if (responseStatus == 404) {

                throw new NotFoundException("Pet not found");

            } else if (responseStatus == 405) {

                throw new NotFoundException("Invalid input");

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
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createPet(Pet newPet) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int responseStatus;

        try {
            url = new URL(SwaggerLocators.urlPetStorePetId);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", SwaggerLocators.USER__AGENT);
            connection.setRequestProperty("Accept-Language", SwaggerLocators.ACCEPT_LANGUAGE);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            String responseBody = JsonCreator.createPetJson(newPet);

            //Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(responseBody);
            wr.flush();
            wr.close();

            responseStatus = connection.getResponseCode(); //Получаем статус ответа
            System.out.println("Статус : " + responseStatus);

            if (responseStatus == 200) {

                System.out.println("id : " + newPet.getId());
                System.out.println("Category :");
                System.out.println("    id : " + newPet.getCategoryId());
                System.out.println("    name : " + newPet.getCategoryName());
                System.out.println("Name : " + newPet.getPetName());
                System.out.println("Photo URLs : " + newPet.getPhotoURLs());
                System.out.println("Tags :");
                System.out.println("    id : " + newPet.getTagsId());
                System.out.println("    name : " + newPet.getTagsName());
                System.out.println("Status : " + newPet.getStatus());

            } else if (responseStatus == 405) {

                throw new NotFoundException("Invalid input");

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
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void updatePetById(Pet updatePet) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int responseStatus;

        try {
            url = new URL(SwaggerLocators.urlPetStorePetId);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("User-Agent", SwaggerLocators.USER__AGENT);
            connection.setRequestProperty("Accept-Language", SwaggerLocators.ACCEPT_LANGUAGE);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            String responseBody = JsonCreator.createPetJson(updatePet);

            //Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(responseBody);
            wr.flush();
            wr.close();

            responseStatus = connection.getResponseCode(); //Получаем статус ответа
            System.out.println("Статус : " + responseStatus);

            if (responseStatus == 200) {
                System.out.println("Данные питомца удачно обновлены :");
                System.out.println("id : " + updatePet.getId());
                System.out.println("Category :");
                System.out.println("    id : " + updatePet.getCategoryId());
                System.out.println("    name : " + updatePet.getCategoryName());
                System.out.println("Name : " + updatePet.getPetName());
                System.out.println("Photo URLs : " + updatePet.getPhotoURLs());
                System.out.println("Tags :");
                System.out.println("    id : " + updatePet.getTagsId());
                System.out.println("    name : " + updatePet.getTagsName());
                System.out.println("Status : " + updatePet.getStatus());

            } else if (responseStatus == 405) {

                throw new NotFoundException("Validation exception");

            } else if (responseStatus == 404) {

                throw new NotFoundException("Pet not found");

            } else if (responseStatus == 400) {

                throw new NotFoundException("Invalid ID supplied");

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
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
