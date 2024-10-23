package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(className = "sign-in-heading")
    WebElement loginPg_HeadingEl;

    @FindBy(id = "usernameInput")
    WebElement loginPg_UserNameEl;

    @FindBy(id = "passwordInput")
    WebElement loginPg_PasswordEl;

    @FindBy(className = "login-button")
    WebElement loginPg_LoginBtnEl;

    @FindBy(className = "error-message")
    WebElement loginPg_ErrorMsgEl;

    WebElement loginPg_logoEl;

    WebElement loginPg_UserNameLabelEl;

    WebElement loginPg_PasswordLabelEl;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        loginPg_logoEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
        loginPg_UserNameLabelEl = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label"));
        loginPg_PasswordLabelEl = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label"));
    }

    public boolean loginPg_FindLogo() {
        return loginPg_logoEl.isDisplayed();
    }

    public String loginPg_GetHeading() {
        return loginPg_HeadingEl.getText();
    }

    public String loginPg_GetUserNameLabel() {
        return loginPg_UserNameLabelEl.getText();
    }

    public String loginPg_GetPasswordLabel() {
        return loginPg_PasswordLabelEl.getText();
    }

    public boolean loginPg_TestLoginBtn() {
        boolean is_btnEnabled = loginPg_LoginBtnEl.isEnabled() && loginPg_LoginBtnEl.isDisplayed();
        return is_btnEnabled;
    }

    public String loginPg_GetErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return loginPg_ErrorMsgEl.getText();
    }


    public void loginToApplication(String username, String password) {
        loginPg_UserNameEl.sendKeys(username);
        loginPg_PasswordEl.sendKeys(password);
        loginPg_LoginBtnEl.click();
    }
}
