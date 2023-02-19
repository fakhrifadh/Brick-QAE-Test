package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers
{
    WebDriver driver;
    Actions actions;

    public SeleniumHelpers(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void enterText(WebElement e, String text, boolean clear)
    {
        e = waitTillElementIsVisible(e);
        if(clear)
        {
            e.clear();
        }
        e.sendKeys(text);
    }

    public String getText(WebElement e)
    {
        return waitTillElementIsVisible(e).getText().trim();
    }

    public String getValue(WebElement e){
        return waitTillElementIsVisible(e).getAttribute("value");
    }

    public void clickOn(WebElement e) throws InterruptedException
    {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }


    public WebElement waitTillElementIsClickable(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    public WebElement waitTillElementIsVisible(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }


    public  void waitForJavascriptToLoad() throws InterruptedException
    {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait <WebDriver> wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
        try
        {
            wait.until(expectation);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void navigateToPage(String url)
    {
        driver.get(url);
    }

}