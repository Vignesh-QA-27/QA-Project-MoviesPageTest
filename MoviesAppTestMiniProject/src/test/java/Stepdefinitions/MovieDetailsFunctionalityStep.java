package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MovieDetailsFunctionalityStep {
    WebDriver driver = Hooks.getDriver();


    @Given("I am on the login page 'MovieDetailsPg'")
    public void iamonloginPg_MovieDetailsPg() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the Valid user credential'MovieDetailsPg'")
    public void ientervalidcredential_MovieDetailsPg() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the loginBtn 'MovieDetailsPg'")
    public void iclickonloginBtn_MovieDetailsPg() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on home 'MovieDetailsPg'")
    public void iclickonhome_MovieDetailsPg() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[1]/a")).click();
    }

    @And("I click on any movie in home section 'MovieDetailsPg'")
    public void iclickanymovieinhomesection_MovieDetailsPg() {
        WebElement imaxMovie = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img"));
        imaxMovie.click();
    }

    @When("I have to verify the home movie ui elements 'MovieDetailsPg'")
    public void ihavetoverifyhomemovieuielements_MovieDetailsPg() {
        // In the Home Page click on any Movie and test all the UI elements present in it
        WebElement movieHeading = driver.findElement(By.className("movie-title"));
        WebElement movieReview = driver.findElement(By.className("movie-review-container"));
        WebElement movieOverView = driver.findElement(By.className("movie-overview"));
        WebElement moviePlayBtn = driver.findElement(By.className("play-button"));
        WebElement movieCategories = driver.findElement(By.className("detailed-movie-categories-container"));

        Assert.assertTrue(movieHeading.isDisplayed(),"MovieDetailsPg Home heading is not found");
        Assert.assertTrue(movieReview.isDisplayed(),"MovieDetailsPg Home movies review is not found");
        Assert.assertTrue(movieOverView.isDisplayed(),"MovieDetailsPg Home movies overview is not found");
        Assert.assertTrue(moviePlayBtn.isDisplayed(),"MovieDetailsPg Home playBtn is not found");
        Assert.assertTrue(movieCategories.isDisplayed(),"MovieDetailsPg Home movies categories is not found");
    }

    @When("I click on popular 'MovieDetailsPg'")
    public void iclickonpopular_MovieDetailsPg() {
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a")).click();
    }

    @And("I click on any movie in popular section 'MovieDetailsPg'")
    public void iclickonanymoviepopularsection_MovieDetailsPg() {
        WebElement lucaMovie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[4]/a/img"));
        lucaMovie.click();
    }

    @Then("I have to verify the popular movie ui elements 'MovieDetailsPg'")
    public void ihavetoverifypopularmovieui_MovieDetailsPg(){
        // In the Popular Page click on any Movie and test all the UI elements present in it
        WebElement movieHeading = driver.findElement(By.className("movie-title"));
        WebElement movieReview = driver.findElement(By.className("movie-review-container"));
        WebElement movieOverView = driver.findElement(By.className("movie-overview"));
        WebElement moviePlayBtn = driver.findElement(By.className("play-button"));
        WebElement movieCategories = driver.findElement(By.className("detailed-movie-categories-container"));

        Assert.assertTrue(movieHeading.isDisplayed(),"MovieDetailsPg Popular heading is not found");
        Assert.assertTrue(movieReview.isDisplayed(),"MovieDetailsPg Popular movies review is not found");
        Assert.assertTrue(movieOverView.isDisplayed(),"MovieDetailsPg Popular movies overview is not found");
        Assert.assertTrue(moviePlayBtn.isDisplayed(),"MovieDetailsPg Popular playBtn is not found");
        Assert.assertTrue(movieCategories.isDisplayed(),"MovieDetailsPg Popular movies categories is not found");
    }

}
