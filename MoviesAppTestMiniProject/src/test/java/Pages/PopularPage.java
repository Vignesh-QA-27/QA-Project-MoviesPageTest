package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PopularPage {
    public WebDriver driver;

    By userNameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginBtn = By.className("login-button");

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password) {
        driver.findElement(userNameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
