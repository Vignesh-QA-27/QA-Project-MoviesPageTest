package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    By userNameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginBtn = By.className("login-button");
    By homeHeadingTxtEl = By.className("home-movie-heading");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getHomePgHeading() {
        WebElement homeTxtEl = driver.findElement(homeHeadingTxtEl);
        String homeTxt = homeTxtEl.getText();
        return homeTxt;
    }

    public boolean checkHomePgPlayBtn() {
        WebElement homePg_PlayBtnEl = driver.findElement(By.className("home-movie-play-button"));
        return homePg_PlayBtnEl.isEnabled();
    }

    public boolean checkHomePgContactUsSection() {
        WebElement homePg_GoogleIconEl = driver.findElement(By.className("google-icon"));
        WebElement homePg_TwitterIconEl = driver.findElement(By.className("twitter-icon"));
        WebElement homePg_InstagramIconEl = driver.findElement(By.className("instagram-icon"));
        WebElement homePg_YoutubeIconEl = driver.findElement(By.className("youtube-icon"));
        WebElement homePg_ContactUsEl = driver.findElement(By.className("contact-us-paragraph"));

        boolean contactUsIconAreVisible = homePg_GoogleIconEl.isDisplayed() && homePg_TwitterIconEl.isDisplayed() && homePg_InstagramIconEl.isDisplayed() && homePg_YoutubeIconEl.isDisplayed();

        if(contactUsIconAreVisible) {
            return contactUsIconAreVisible;
        }
        return homePg_ContactUsEl.isDisplayed();
    }

    public boolean checkHomePgMoviesSection() {
        List<WebElement> homePg_Trendingsection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[1]/div/div"));
        List<WebElement> homePg_Originalssection = driver.findElements(By.xpath("/html/body/div/div/div[2]/div[2]/div/div"));
        return !homePg_Trendingsection.isEmpty() && !homePg_Originalssection.isEmpty();
    }

    public void loginToApplication(String username, String password) {
        driver.findElement(userNameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginBtn).click();
    }


}
