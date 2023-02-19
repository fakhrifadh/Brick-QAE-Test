package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;
import utilities.SeleniumHelpers;

public class BrickLoginPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public BrickLoginPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
    }

    @FindBy(id = "your_email")
    private WebElement emailText;

    @FindBy(id = "password")
    private WebElement passwordText;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(className = "swal2-popup swal2-modal swal2-icon-error swal2-show")
    private WebElement errorFrame;

    @FindBy(id = "swal2-title")
    private WebElement errorText;

    @FindBy(id = "swal2-content")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/forgot']")
    private WebElement forgotPasswordText;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement signUpText;


    public void fillEmail(String email){
        selenium.enterText(emailText, email, false);
    }

    public void fillPassword(String password){
        selenium.enterText(passwordText, password, false);
    }

    public void clickLoginButton() throws InterruptedException{
        selenium.clickOn(loginButton);
    }

    public String getErrorText(){
        return selenium.getText(errorText);
    }

    public String getErrorMessageText(){
        return selenium.getText(errorMessage);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPasswordWarningMessage(){
        return passwordText.getAttribute("validationMessage");
    }
    public String getEmailWarningMessage(){
        return emailText.getAttribute("validationMessage");
    }

    public void clickForgotPassword() throws InterruptedException {
        selenium.clickOn(forgotPasswordText);
    }

    public void clickSignUp() throws InterruptedException {
        selenium.clickOn(signUpText);
    }

}
