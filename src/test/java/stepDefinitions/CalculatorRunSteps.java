package stepDefinitions;

import io.cucumber.java.PendingException;
import static org.junit.Assert.*;
import io.cucumber.java.ru.*; //Импортируем все ключевые слова
import сucumberMetods.Calculator;

public class CalculatorRunSteps {

    private int total;
    private Calculator calculator;

    @Дано("у меня есть калькулятор")
    public void у_меня_есть_калькулятор() throws Throwable {
        calculator = new Calculator();
    }

    @Когда("я складываю {int} и {int}")
    public void я_складываю(int num1, int num2) throws Throwable {
        total = calculator.summa(num1, num2);
    }

    @Тогда("рузультат будет равен {int}")
    public void рузультат_будет_равен(int result) throws Throwable {
        assertEquals(total, result);
    }

}
