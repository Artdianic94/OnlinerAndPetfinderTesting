package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/PetfinderFeature"},
        tags = "@api",
        glue = {"PetfinderSteps", "hooks"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
@Test
public class PetfinderTest extends AbstractTestNGCucumberTests {
}