package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public WebDriver driver;

    By userNameEl = By.id("usernameInput");
    By passwordEl = By.id("passwordInput");
    By loginBtn = By.className("login-button");
    By accountBtnEl = By.className("avatar-button");
    By accountNavHeaderEl = By.cssSelector(".nav-header");
    By accountDetailsEl = By.cssSelector(".account-information-container");
    By accountLogOutBtnEl = By.className("logout-button");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginToApplication(String username, String password) {
        driver.findElement(userNameEl).sendKeys(username);
        driver.findElement(passwordEl).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void clickOnAccountBtn() {
        driver.findElement(accountBtnEl).click();
    }

    public boolean findAccountNavBarSection() {
        return driver.findElement(accountNavHeaderEl).isDisplayed();
    }

    public boolean findAccountDetailsSection() {
        return driver.findElement(accountDetailsEl).isDisplayed();
    }

    public void clickOnLogOutBtn() {
        driver.findElement(accountLogOutBtnEl).click();
    }

}
