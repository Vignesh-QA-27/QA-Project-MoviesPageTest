import Pages.AccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public AccountPage accountPgTest;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountPgTest = new AccountPage(driver);
        accountPgTest.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testAccountPgUi() {
        // Test all the UI elements present on the web page
        accountPgTest.clickOnAccountBtn();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"Navigate to account page failed");
        Assert.assertTrue(accountPgTest.findAccountNavBarSection(),"AccountPg Header navBar section is not found");
        Assert.assertTrue(accountPgTest.findAccountDetailsSection(),"AccountPg AccountDetails section is not found");
    }

    @Test(priority = 2)
    public void testLogOutFunctionality() {
        // Test the Logout functionality
        accountPgTest.clickOnAccountBtn();
        accountPgTest.clickOnLogOutBtn();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        String currentUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"LogOut Function is not working");
    }

}
