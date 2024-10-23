package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page 'SearchPg'")
    public void iamonloginPg_PopularPg() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the Valid user credential 'SearchPg'")
    public void ientervalidcredential_PopularPg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the loginBtn 'SearchPg'")
    public void iclickonloginBtn_PopularPg() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on the search bar 'SearchPg'")
    public void iclickonsearchbar_SearchPg() {
        driver.findElement(By.className("search-empty-button")).click();
    }

    @And("I enter the search correct movie name input 'SearchPg'")
    public void ientercorrectsearchinput_SearchPg() {
        driver.findElement(By.id("search")).sendKeys("PAW");
    }

    @And("I click ont the search button 'SearchPg'")
    public void iclickonsearchBtn_SearchPg() {
        driver.findElement(By.className("search-button")).click();
    }

    @Then("I have to verify the count of movies 'SearchPg'")
    public void ihavetoverifycountofmovies_SearchPg() {
        List<WebElement> moviesFoundEl = driver.findElements(By.className("movie-icon-item"));
        if(moviesFoundEl.size() == 1) {
            System.out.println("Movies search function No-Of-Movies : " + moviesFoundEl.size());
        }
        else {
            System.out.println("Movies search function is not working");
        }
    }

    @And("I enter the search wrong movie name input 'SearchPg'")
    public void ienterwrongsearchinput_SearchPg() {
        driver.findElement(By.id("search")).sendKeys("God Of War");
    }

    @Then("I have to verify the Error Msg of empty search 'SearchPg'")
    public void ihavetoverifyerrormsgofemptysearch_SearchPg() {
        WebElement errorImgEl = driver.findElement(By.className("not-found-search-image"));
        WebElement errorTxtEl = driver.findElement(By.className("not-found-search-paragraph"));
        boolean is_bothErrorDisplayed = errorImgEl.isDisplayed() && errorTxtEl.isDisplayed();
        Assert.assertTrue(is_bothErrorDisplayed,"Search functionality with failure case is not working");
    }
}
