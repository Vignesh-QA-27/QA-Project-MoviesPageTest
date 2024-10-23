import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginPgUi() {
        // Test whether the Website logo image is displayed
        boolean logo = loginPage.loginPg_FindLogo();
        if(logo) {
            System.out.println("LoginPg Logo checked successfully");
        }
        else {
            System.out.println("LoginPg Logo check !Failed");
        }

        // Test whether the Heading text is "Login"
        String headingTxt = loginPage.loginPg_GetHeading();
        Assert.assertEquals(headingTxt,"Login","LoginPg heading does not match");

        // Test whether the Username label texts "USERNAME" And "PASSWORD"
        Assert.assertEquals(loginPage.loginPg_GetUserNameLabel(),"USERNAME","LoginPg username label not match");
        Assert.assertEquals(loginPage.loginPg_GetPasswordLabel(),"PASSWORD","LoginPg password label not match");

        // Test the "Login" button
        Assert.assertTrue(loginPage.loginPg_TestLoginBtn(),"LoginPg loginBtn is not Working");
    }

    @Test(priority = 2)
    public void testLoginPgWithEmptyInputs() {
        // Test the login functionality with empty input fields
        loginPage.loginToApplication("","");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPg_GetErrorMsg();
        Assert.assertEquals(errorMsg,"*Username or password is invalid","LoginPg empty input fields does not match");
    }

    @Test(priority = 3)
    public void testLoginPgWithEmptyUserName() {
        // Test the login functionality with empty username fields
        loginPage.loginToApplication("","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPg_GetErrorMsg();
        Assert.assertEquals(errorMsg,"*Username or password is invalid","LoginPg empty username fields does not match");
    }

    @Test(priority = 4)
    public void testLoginPgWithEmptyPassword() {
        // Test the login functionality with empty password fields
        loginPage.loginToApplication("rahul","");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPg_GetErrorMsg();
        Assert.assertEquals(errorMsg,"*Username or password is invalid","LoginPg empty password fields does not match");
    }

    @Test(priority = 5)
    public void testLoginPgWithInvalidCredentials() {
        // Test the login functionality with InvalidCredentials
        loginPage.loginToApplication("rahul","rahul2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMsg = loginPage.loginPg_GetErrorMsg();
        Assert.assertEquals(errorMsg,"*username and password didn't match","LoginPg with InvalidCredentials field does not match");
    }

    @Test(priority = 6)
    public void testLoginPgWithValidCredentials() {
        // Test the login functionality with ValidCredentials
        loginPage.loginToApplication("rahul","rahul@2021");
    }






}
