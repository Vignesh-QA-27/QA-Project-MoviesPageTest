package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginFunctionalityStep {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the login page 'LoginPg'")
    public void iamonloginpg_homepg() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Then("I have able to see the website logo, heading, labelText and loginBtn 'LoginPg'")
    public void ihavetoverifyallcontent() {
        // Test whether the Website logo image is displayed
        boolean websiteLogo_loginPg = driver.findElement(By.className("login-website-logo")).isDisplayed();
        Assert.assertTrue(websiteLogo_loginPg,"LoginPg logo is not found");

        // Test whether the Heading text is "Login"
        String heading_loginPg = driver.findElement(By.className("sign-in-heading")).getText();
        Assert.assertEquals(heading_loginPg,"Login","LoginPg heading not match");

        // Test whether the Username label text is "USERNAME
        String userNameLabelTxt_loginPg = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label")).getText();
        Assert.assertEquals(userNameLabelTxt_loginPg,"USERNAME","LoginPg userNameLabel text not match");

        // Test whether the Password label text is "PASSWORD"
        String passwordLabelTxt_loginPg = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label")).getText();
        Assert.assertEquals(passwordLabelTxt_loginPg,"PASSWORD","LoginPg passwordLabel text not match");

        // Test the "Login" button
        boolean loginBtn_loginPg = driver.findElement(By.className("login-button")).isEnabled();
        Assert.assertTrue(loginBtn_loginPg,"LoginPg login button is not working");
    }

    @When("I click on the loginBtn 'LoginPg'")
    public void iclickontheloginbtn_loginPg() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I enter the 'UserName' 'LoginPg'")
    public void ientertheuserName_loginPg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
    }

    @When("I enter the 'Password' 'LoginPg'")
    public void ienterthepassword_loginPg() {
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I enter the 'Wrong Password' 'LoginPg'")
    public void ienterthewrongpassword_loginPg() {
        driver.findElement(By.id("passwordInput")).sendKeys("rahul2021");
    }

    @Then("I have to verify the error text 'Empty Input Field' 'LoginPg'")
    public void verifytheerrortxtemptyinput_loginPg() {
        String errortxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(errortxt,"*Username or password is invalid");
    }

    @Then("I have to verify the error text 'Empty UserName Field' 'LoginPg'")
    public void verifytheerrortxtemptyusername_loginPg() {
        String errortxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(errortxt,"*Username or password is invalid");
    }

    @Then("I have to verify the error text 'Empty Password Field' 'LoginPg'")
    public void verifytheerrortxtemptypassword_loginPg() {
        String errortxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(errortxt,"*Username or password is invalid");
    }

    @Then("I have to verify the error text 'Wrong Password' 'LoginPg'")
    public void verifytheerrortxtwrongpassword_loginPg() {
        String errortxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(errortxt,"*username and password didn't match");
    }

    @Then("I have to verify the login Url 'LoginPg'")
    public void verifytheloginUrl_loginPg() {
        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expUrl,currentUrl);
    }

}
