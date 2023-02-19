package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverManager;
import utilities.ThreadManager;

public class Hooks {
    DriverManager drivermanager = new DriverManager();

    @Before
    public void setUp()
    {
        drivermanager.setUp(ThreadManager.getBrowser());
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            byte[] screenshotBytes = ((TakesScreenshot) ThreadManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png",scenario.getName());
        }
        drivermanager.tearDown();
    }
}
