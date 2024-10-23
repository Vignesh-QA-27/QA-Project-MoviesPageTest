package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HeaderFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page 'HeaderPg'")
    public void iamonloginpg_header() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I have enter the valid Login details 'HeaderPg'")
    public void ienteredvalidcredentials_heder() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I have click the login  button 'HeaderPg'")
    public void iclickonloginbtn_header() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I have to check the logo and navBar's items are visible 'HeaderPg'")
    public void ihavetochecklogoandnavbarsvisibile_header() {
        WebElement headerPg_logo = driver.findElement(By.className("website-logo"));
        Assert.assertTrue(headerPg_logo.isDisplayed(),"HeaderPg Logo is not displayed");

        WebElement headerPg_HomeNavbar = driver.findElement(By.linkText("Home"));
        WebElement headerPg_PopularNavbar = driver.findElement(By.linkText("Popular"));
        WebElement headerPg_SearchNavar = driver.findElement(By.className("search-empty-button"));
        WebElement headerPg_accounNavbar = driver.findElement(By.className("avatar-button"));
        boolean are_visible = headerPg_HomeNavbar.isDisplayed() && headerPg_PopularNavbar.isDisplayed() && headerPg_SearchNavar.isDisplayed() && headerPg_accounNavbar.isDisplayed();
        Assert.assertTrue(are_visible,"HeaderPg NavBar section is not working");
    }

    @And("I have to check the home section by 'HeaderPg'")
    public void ihavetocheckhomesection() {
        WebElement homeNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeNavLink.click();
        String homePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,"https://qamoviesapp.ccbp.tech/","Home page url does not match");
    }

    @And("I have to check the popular section by 'HeaderPg'")
    public void ihavetocheckpopularsection() {
        WebElement popularNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Popular')]"));
        popularNavLink.click();
        String popularPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(popularPageUrl,"https://qamoviesapp.ccbp.tech/popular","Popular page url does not match");
    }

    @Then("I have to check the account section by 'HeaderPg'")
    public void ihavetocheckaccountsection() {
        WebElement accountBtn = driver.findElement(By.className("avatar-button"));
        accountBtn.click();
        String accountUrl = driver.getCurrentUrl();
        Assert.assertEquals(accountUrl,"https://qamoviesapp.ccbp.tech/account","Account page url does not match");
    }
}
