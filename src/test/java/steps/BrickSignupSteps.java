package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.BrickSignupPO;
import utilities.Constants;
import utilities.FakerUtil;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;


public class BrickSignupSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private BrickSignupPO brick = new BrickSignupPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private FakerUtil faker = new FakerUtil();

    @Given("user navigate to {string}")
    public void userNavigates(String url){
        if (url.equalsIgnoreCase("brick-signup")){
            url = Constants.BRICK_SIGNUP_URL;
        }
        selenium.navigateToPage(url);
    }
    
    @When("user enter valid {string},{string},{string},{string},{string}")
    public void userInputRegistrationData(String firstName, String lastName, String address, String password, String confirmPassword){
        brick.fillFirstName(firstName);
        brick.fillLastName(lastName);
        brick.fillAddress(address);
        brick.fillPassword(password);
        brick.fillConfirmationPassword(confirmPassword);
    }

    @And("user enter a random valid email")
    public void usesRandomEmail(){
        brick.fillEmail(faker.randomEmail());
    }

    @And("user enter a random valid phone number")
    public void usesRandomPhone(){
        brick.fillPhoneNumber(faker.randomPhoneNumber());
    }

    @And("user select {string} in the phone number dropdown")
    public void userSelectCountryCode(String country) throws InterruptedException {
        brick.selectCountryPhoneCode(country);
    }

    @And("user click register button")
    public void userClickRegisterButton() throws InterruptedException {
        brick.clickRegisterButton();
    }

    @And("user should get {string} in the front of phone number input")
    public void userGetCountryCode(String code){
        Assert.assertEquals(brick.getPhoneNumberText(),code);
    }

    @Then("user should get success text")
    public void userGetSuccessRegistration(){
        Assert.assertEquals(brick.getSuccessText(),"Success");
    }

    @When("user enter {string},{string},{string},{string},{string},{string},{string}")
    public void userInputRegistrationData(String firstName, String lastName, String email, String phone, String address, String password, String confirmPassword){
        brick.fillFirstName(firstName);
        brick.fillLastName(lastName);
        brick.fillEmail(email);
        brick.fillPhoneNumber(phone);
        brick.fillAddress(address);
        brick.fillPassword(password);
        brick.fillConfirmationPassword(confirmPassword);
    }

    @Then("user should receive a {string} warning")
    public void userRegistrationFailed(String cases){
        switch (cases){
            case "empty input":
                Assert.assertEquals(brick.getEmailError(),"Please provide an email");
                Assert.assertEquals(brick.getFirstNameError(),"Please enter a firstname");
                Assert.assertEquals(brick.getLastNameError(),"Please enter a lastname");
                Assert.assertEquals(brick.getPasswordError(),"Please enter a password");
                Assert.assertEquals(brick.getPasswordError(),"Please enter a password");
                Assert.assertFalse(brick.getPhoneNumberError().isEmpty());
                break;
            case "password not match":
                Assert.assertEquals(brick.getConfirmationPasswordError(), "Password need to match");
                break;
            case "password length invalid":
                Assert.assertEquals(brick.getPasswordError(), "Please enter at least 6 characters.");
                break;
            case "invalid email":
                Assert.assertEquals(brick.getEmailError(),"Please enter a valid email address.");
                break;
            case "invalid phone number":
                Assert.assertFalse(brick.getPhoneNumberError().isEmpty());
                break;
            case "email already registered":
                Assert.assertEquals(brick.getErrorText(), "Error");
                Assert.assertEquals(brick.getErrorMessageText(),"Email has been taken!");
                break;
        }
    }

    @When("user click sign in text")
    public void userCLickSignIn() throws InterruptedException {
        brick.clickLoginText();
    }

    @Then("user should be at the sign in page")
    public void userAtSignInPage(){
        Assert.assertFalse(brick.getPageTitle().contains("404"));
        Assert.assertEquals(brick.getCurrentUrl(), "https://qademo.onebrick.io/login");
    }

    @When("user want to click contact sales text")
    public void userCheckContactSales()  {
        Assert.assertTrue(brick.isContactSalesLinkVisible());
    }

    @Then("user should receive email link to contact sales")
    public void userReceiveContactSalesEmailLink(){
        Assert.assertEquals(brick.getContactSalesLink(),"mailto:sales@onebrick.io?subject=Interested%20in%20Brick%20for%20Enterprise&body=Please%20tell%20us%20more%20about%20how%20we%20can%20help%2C%20What%20are%20you%20building%2C%20What%27s%20the%20estimated%20end%20users%2C%20Details%20are%20helpful");
    }

}
