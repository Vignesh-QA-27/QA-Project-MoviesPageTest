package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PopularFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page 'PopularPg'")
    public void iamonloginPg_PopularPg() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the Valid user credential 'PopularPg'")
    public void ientervalidcredential_PopularPg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the loginBtn 'PopularPg'")
    public void iclickonloginBtn_PopularPg() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on popular 'PopularPg'")
    public void iclickonpopular_PopularPg() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a")).click();
    }

    @Then("I have verify the movies are displayed or not 'PopularPg'")
    public void ihavetoverifymoviesaredisplayornot_PopularPg() {
        // Test whether the movies are displayed
        WebElement popularPg = driver.findElement(By.linkText("Popular"));
        popularPg.click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,currentUrl,"PopularPg Movies are not Displayed");
    }
}
