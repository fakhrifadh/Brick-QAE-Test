package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;

public class BrickSignupPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public BrickSignupPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameText;

    @FindBy(id = "lastName")
    public WebElement lastNameText;

    @FindBy(id = "email")
    public WebElement emailText;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumberText;

    @FindBy(id = "address")
    public WebElement addressText;

    @FindBy(id = "password")
    public WebElement passwordText;

    @FindBy(id = "confirm_password")
    public WebElement confirmPasswordText;

    @FindBy(name = "register")
    public WebElement registerButton;

    @FindBy(id = "swal2-title")
    public WebElement successText;

    @FindBy(name = "swal2-html-container")
    public WebElement successMessage;

    @FindBy(id = "firstName-error")
    public WebElement firstNameError;

    @FindBy(id = "lastName-error")
    public WebElement lastNameError;

    @FindBy(id = "email-error")
    public WebElement emailError;

    @FindBy(id = "password-error")
    public WebElement passwordError;

    @FindBy(id = "confirm_password-error")
    public WebElement confirmPasswordError;

    @FindBy(id = " phoneNumber-error")
    public WebElement phoneNumberError;

    @FindBy(xpath = "//div[@role = 'combobox']")
    public WebElement countryList;

    @FindBy(id = "iti-0__country-listbox")
    public WebElement listCountry;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginText;

    @FindBy(xpath = "//a[contains(text(), 'Contact sales')]")
    private WebElement contactSalesText;

    @FindBy(id = "swal2-title")
    private WebElement errorText;

    @FindBy(id = "swal2-content")
    private WebElement errorMessage;


    public void fillEmail(String email){
        selenium.enterText(emailText, email, false);
    }

    public void fillFirstName(String name){
        selenium.enterText(firstNameText, name, false);
    }

    public void fillLastName(String name){
        selenium.enterText(lastNameText, name, false);
    }

    public void fillPhoneNumber(String phoneNumber){
        selenium.enterText(phoneNumberText, phoneNumber, false);
    }

    public void fillAddress(String address){
        selenium.enterText(addressText, address, false);
    }

    public void fillPassword(String password){
        selenium.enterText(passwordText, password, false);
    }

    public void fillConfirmationPassword(String confirmPassword){
        selenium.enterText(confirmPasswordText, confirmPassword, false);
    }

    public void clickRegisterButton() throws InterruptedException {
        selenium.clickOn(registerButton);
    }

    public String getPhoneNumberText(){
        return selenium.getValue(phoneNumberText);
    }

    public String getSuccessText(){
        return selenium.getText(successText);
    }
    public String getEmailError(){
        return selenium.getText(emailError);
    }
    public String getFirstNameError(){
        return selenium.getText(firstNameError);
    }
    public String getLastNameError(){
        return selenium.getText(lastNameError);
    }
    public String getPhoneNumberError(){
        return selenium.getText(phoneNumberError);
    }
    public String getPasswordError(){
        return selenium.getText(passwordError);
    }
    public String getConfirmationPasswordError(){
        return selenium.getText(confirmPasswordError);
    }

    public void selectCountryPhoneCode(String country) throws InterruptedException {
        selenium.clickOn(countryList);
        listCountry.findElement(new By.ByXPath("//li/span[text()='"+country+"']")).click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickLoginText() throws InterruptedException {
        selenium.clickOn(loginText);
    }

    public boolean isContactSalesLinkVisible(){
        return contactSalesText.isDisplayed();
    }

    public String getContactSalesLink(){
        return contactSalesText.getAttribute("href");
    }

    public String getErrorText(){
        return selenium.getText(errorText);
    }

    public String getErrorMessageText(){
        return selenium.getText(errorMessage);
    }

}
