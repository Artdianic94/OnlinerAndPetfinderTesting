package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/OnlinerFeatures"},
        tags = "@ui",
        glue = {"OnlinerSteps", "hooks"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
)

public class OnlinerTest extends AbstractTestNGCucumberTests {
}
