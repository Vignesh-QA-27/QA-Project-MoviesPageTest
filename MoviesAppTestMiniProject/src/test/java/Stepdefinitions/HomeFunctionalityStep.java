package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class HomeFunctionalityStep {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page 'HomePg'")
    public void iamonloginpg_header() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I have enter the valid Login details 'HomePg'")
    public void ienteredvalidcredentials_heder() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I have click the login  button 'HomePg'")
    public void iclickonloginbtn_header() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I have to access all the home page contents 'HomePg'")
    public void ihavetoaccessallhomepagecontents() {
        // Test the heading texts of section
        WebElement homePg_heading = driver.findElement(By.className("home-movie-heading"));
        String headingTxt = homePg_heading.getText();
        Assert.assertEquals(headingTxt,headingTxt,"HHomePg heading no found");

        // Test whether the play button is displayed or not
        WebElement homePg_playBtn = driver.findElement(By.className("home-movie-play-button"));
        boolean playBtn = homePg_playBtn.isDisplayed();
        Assert.assertTrue(playBtn,"HomePg play button not found");

        // Test the Contact Us Section
        WebElement homePg_GoogleIconEl = driver.findElement(By.className("google-icon"));
        WebElement homePg_TwitterIconEl = driver.findElement(By.className("twitter-icon"));
        WebElement homePg_InstagramIconEl = driver.findElement(By.className("instagram-icon"));
        WebElement homePg_YoutubeIconEl = driver.findElement(By.className("youtube-icon"));
        WebElement homePg_ContactUsEl = driver.findElement(By.className("contact-us-paragraph"));

        boolean contactUsIconAreVisible = homePg_GoogleIconEl.isDisplayed() && homePg_TwitterIconEl.isDisplayed() && homePg_InstagramIconEl.isDisplayed() && homePg_YoutubeIconEl.isDisplayed();
        boolean contactUsPara = homePg_ContactUsEl.isDisplayed();
        Assert.assertTrue(contactUsIconAreVisible && contactUsPara,"Contact Us section is not displayed");

        // Test whether the Movies are displayed, in the corresponding movies sections
        List<WebElement> homePg_Trendingsection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[1]/div/div"));
        List<WebElement> homePg_Originalssection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[2]/div/div"));
        boolean homePg_MoviesCorrespondingSection = !homePg_Trendingsection.isEmpty() && !homePg_Originalssection.isEmpty();
        Assert.assertTrue(homePg_MoviesCorrespondingSection,"HomePg movies are not displayed in corresponding section");
    }
}
