package runners;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/brick/cucumber-report.json",  "html:target/brick/runner"},
        features = "src/test/resources/features",
        glue = "steps"
)

public class Runner extends BaseRunner {
}
