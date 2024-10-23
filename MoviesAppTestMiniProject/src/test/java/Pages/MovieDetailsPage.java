package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsPage {
    public WebDriver driver;

    By userNameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginBtn = By.className("login-button");

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password) {
        driver.findElement(userNameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean movieDetailPg_FindMovieHeadingTitle() {
        WebElement movieHeading = driver.findElement(By.className("movie-title"));
        return movieHeading.isDisplayed();
    }

    public boolean movieDetailPg_FindMovieReview() {
        WebElement movieReview = driver.findElement(By.className("movie-review-container"));
        return movieReview.isDisplayed();
    }

    public boolean movieDetailPg_FindMovieOverView() {
        WebElement movieOverView = driver.findElement(By.className("movie-overview"));
        return movieOverView.isDisplayed();
    }

    public boolean movieDetailPg_FindMoviePlayBtn() {
        WebElement moviePlayBtn = driver.findElement(By.className("play-button"));
        return moviePlayBtn.isDisplayed();
    }

    public boolean movieDetailPg_FindMovieCategories() {
        WebElement movieCategories = driver.findElement(By.className("detailed-movie-categories-container"));
        return movieCategories.isDisplayed();
    }


}
