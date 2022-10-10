package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/featureFiles/PurchaseOrder.feature",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
