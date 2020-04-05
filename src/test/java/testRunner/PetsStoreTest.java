package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber/petsStore",
        glue = {"com/stepDefinitions/swagger/petsStore", "com/stepDefinitions/swagger/swaggerMain"},
        tags = "@update_pet_by_id",
        plugin = {"pretty", "summary"},
        strict = true
)

public class PetsStoreTest {
}
