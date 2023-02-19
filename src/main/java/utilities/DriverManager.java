package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public void setUp(String browserName){
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--incognito");
                ThreadManager.setDriver(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.setAcceptInsecureCerts(true);
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("browser.privatebrowsing.autostart", true);
                firefoxOptions.addPreference("dom.webnotifications.serviceworker.enabled", false);
                firefoxOptions.addPreference("dom.push.enabled", false);
                ThreadManager.setDriver(new FirefoxDriver(firefoxOptions));
                break;

            default:
                throw new IllegalArgumentException("Please specify valid browser name. Valid browser names are: chrome and firefox");
        }

        ThreadManager.getDriver().manage().timeouts().implicitlyWait(Constants.MIN_WEBDRIVER_DURATION, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGELOAD_WAIT_DURATION, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().timeouts().setScriptTimeout(Constants.WEBDRIVER_WAIT_DURATION, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().window().maximize();
    }

    public void tearDown()
    {
        if(ThreadManager.getDriver()!=null)
        {
            ThreadManager.getDriver().quit();
        }
    }
}
