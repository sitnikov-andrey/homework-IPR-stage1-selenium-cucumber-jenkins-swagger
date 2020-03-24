package com.stepDefinitions.calculator;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void prepareData() {
        System.out.println("Старт теста");
    }

    @After
    public void clearData() {
        System.out.println("Конец теста");
    }
}