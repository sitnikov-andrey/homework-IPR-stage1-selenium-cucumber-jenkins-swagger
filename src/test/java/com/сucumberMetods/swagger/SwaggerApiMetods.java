package com.сucumberMetods.swagger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SwaggerApiMetods {

    private static HttpURLConnection connection;
    private static URL url;
    private static int status;

    public static int petStoreStatus(String swaggerUrl) {

        try {
            url = new URL(swaggerUrl);
            connection = (HttpURLConnection) url.openConnection();

            //Настройка запроса
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);

            status = connection.getResponseCode();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (status);
    }

}
