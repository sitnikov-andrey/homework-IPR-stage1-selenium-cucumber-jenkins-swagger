package com.stepDefinitions.swagger.swaggerMain;

import com.сucumberMetods.swagger.SwaggerApiMetods;
import io.cucumber.java.ru.*; //Импортируем все ключевые слова
import static org.junit.Assert.assertEquals;

public class SwaggerMainSteps {

    String swaggerUrlPetStore;
    int mainSwaggerUrlResponse;

    @Когда("у меня есть доступ к разделу {string}")
    public void у_меня_есть_доступ_к_разделу(String swaggerUrlPetStore) throws Throwable {

        this.swaggerUrlPetStore = swaggerUrlPetStore;
        mainSwaggerUrlResponse = SwaggerApiMetods.petStoreStatus(swaggerUrlPetStore);
        assertEquals(mainSwaggerUrlResponse, 200);

    }
}
