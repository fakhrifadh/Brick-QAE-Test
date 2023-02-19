package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ThreadManager;

public class BaseRunner extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun=true)
    @Parameters({"browserName"})
    public void beforeClass(String browserName)
    {
        ThreadManager.setBrowser(browserName);
    }
}
