package utilities;

import org.openqa.selenium.WebDriver;

public class ThreadManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<String> browser = new ThreadLocal<>();

    /**
     * Set webDriver
     * @param driver
     */
    public static void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    /**
     * Get webDriver
     * @return
     */
    public static WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * Set browser
     * @param browserName
     */
    public static void setBrowser(String browserName) {
        browser.set(browserName);
    }

    /**
     * Get browser
     * @return browser name
     */
    public static String getBrowser() {
        return (String) browser.get();
    }

}