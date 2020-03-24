package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber/calculator",
        glue = "com/stepDefinitions/calculator",
        tags = "@sum_of_two",
        plugin = {"pretty", "summary"},
        strict = true
)
public class CalculatorMetodsTest {
}