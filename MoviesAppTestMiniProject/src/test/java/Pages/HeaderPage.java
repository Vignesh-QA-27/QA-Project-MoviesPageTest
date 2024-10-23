package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    public WebDriver driver;

    By userNameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginBtn = By.className("login-button");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password) {
        driver.findElement(userNameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean findHomeHeaderLogo() {
        WebElement homePg_Logo = driver.findElement(By.className("website-logo"));
        return homePg_Logo.isDisplayed();
    }

    public boolean findHomeHeaderNavbar() {
        WebElement homePg_HomeNavbarEl = driver.findElement(By.linkText("Home"));
        return homePg_HomeNavbarEl.isDisplayed();
    }

    public boolean findHomeHeaderPopulareNavbar() {
        WebElement homePg_PopularNavbarEl = driver.findElement(By.linkText("Popular"));
        return homePg_PopularNavbarEl.isDisplayed();
    }

    public boolean findHomeHeaderAccountNavbar() {
        WebElement homePg_AccountNavbarEl = driver.findElement(By.className("avatar-button"));
        return homePg_AccountNavbarEl.isDisplayed();
    }

    public boolean findHomeHeaderSearchNavbar() {
        WebElement homePg_SearchNavbarEl = driver.findElement(By.className("search-empty-button"));
        return homePg_SearchNavbarEl.isDisplayed();
    }
}
