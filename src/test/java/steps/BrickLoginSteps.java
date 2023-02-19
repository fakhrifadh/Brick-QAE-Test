package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.BrickLoginPO;
import utilities.Constants;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.Objects;

public class BrickLoginSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private BrickLoginPO brick = new BrickLoginPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user open to {string}")
    public void userNavigates(String url){
        if (url.equalsIgnoreCase("brick-login")){
            url = Constants.BRICK_LOGIN_URL;
        }
        selenium.navigateToPage(url);
    }

    @When("user input email {string}")
    public void userInputEmail(String email){
        brick.fillEmail(email);
    }

    @And("user input password {string}")
    public void userInputPassword(String password){
        brick.fillPassword(password);
    }

    @And("user click login button")
    public void userClickLogin() throws InterruptedException{
        brick.clickLoginButton();
    }

    @Then("a text {string} and {string} should appear in the validation errors region")
    public void userGetErrorLogin(String error, String message){
        Assert.assertEquals(brick.getErrorText(), error);
        Assert.assertEquals(brick.getErrorMessageText(),message);
    }

    @Then("user should be at the dashboard page")
    public void userAtDashboardPage(){
        Assert.assertFalse(brick.getPageTitle().contains("404"));
        Assert.assertTrue(brick.getCurrentUrl().contains("https://qademo.onebrick.io/dashboard"));
    }

    @Then("a text {string} should appear in the {string} or {string} form")
    public void userGetWarningMessage(String message, String email, String password){
        if (!Objects.equals(email, "")){
            Assert.assertEquals(brick.getPasswordWarningMessage(),message);
        }else {
            Assert.assertEquals(brick.getEmailWarningMessage(), message);
        }
    }

    @When("user click forgot password text")
    public void userClickForgotPassword() throws InterruptedException {
        brick.clickForgotPassword();
    }

    @Then("user should be at the forgot password page")
    public void userAtForgotPasswordPage(){
        Assert.assertFalse(brick.getPageTitle().contains("404"));
        Assert.assertTrue(brick.getCurrentUrl().contains("https://qademo.onebrick.io/forgot"));

    }

    @When("user click Sign Up text")
    public void userClickSIgnUp() throws InterruptedException {
        brick.clickSignUp();
    }

    @Then("user should be at the Sign Up page")
    public void userAtSignUpPage(){
        Assert.assertFalse(brick.getPageTitle().contains("404"));
        Assert.assertTrue(brick.getCurrentUrl().contains("https://qademo.onebrick.io"));

    }

}
