package Stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountFunctionalityStep {
    WebDriver driver = Hooks.getDriver();


    @Given("I am on the login page 'AccountPg'")
    public void iamonloginpg_accountPg() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I have enter the valid Login details 'AccountPg'")
    public void ienteredavaidcredentials_accountpg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I have click the login  button 'AccountPg'")
    public void iclickonloginbtn_accountpg() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I have click on account section 'AccountPg'")
    public void iclickonaccountsection_accountpg() {
        driver.findElement(By.className("avatar-button")).click();
    }

    @And("I have to verify the account page navigation 'AccountPg'")
    public void ihavetoverifytaccountnavigation_accountpg() {
        String expectedUrlAccounPg = "https://qamoviesapp.ccbp.tech/account";
        String currentUrlAccountPg = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlAccounPg,currentUrlAccountPg,"Navigation to account page failed");
    }

    @And("I have to verify the NavBar section 'AccountPg'")
    public void ihavetoverifythenavbarsection_accountpg() {
        WebElement is_nabarSection_Displayed = driver.findElement(By.className("nav-header"));
        Assert.assertTrue(is_nabarSection_Displayed.isDisplayed(),"NavBar section for account Page is not found");
    }

    @Then("I have to verify the account section 'AccountPg'")
    public void ihavetoverifytheaccountsection_accountpg() {
        WebElement is_accountSection_Displayed = driver.findElement(By.className("account-information-container"));
        Assert.assertTrue(is_accountSection_Displayed.isDisplayed(),"Account details for account page is not found");
    }

    @When("I click on the logout button 'AccountPg'")
    public void iclickonlogoutbtn_accounpg() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/button")).click();
    }

    @Then("I have to redirect to the login page 'AccountPg'")
    public void ihaveredirecttologinpage() {
        String expectedLoginUrl = "https://qamoviesapp.ccbp.tech/login";
        String currentLoginUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedLoginUrl,currentLoginUrl,"Logout function is not working");
    }

}
