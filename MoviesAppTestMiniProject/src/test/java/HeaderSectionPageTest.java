import Pages.HeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderSectionPageTest {
    public static WebDriver driver;
    public HeaderPage headerPgTest;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headerPgTest = new HeaderPage(driver);
        headerPgTest.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testHeaderSectionUi() {
        // Test whether the Website logo is displayed
        Assert.assertTrue(headerPgTest.findHomeHeaderLogo(),"HomePg logo is not found");

        // Test the NavBar elements
        Assert.assertTrue(headerPgTest.findHomeHeaderNavbar(),"Home NavBar is not working");
        Assert.assertTrue(headerPgTest.findHomeHeaderPopulareNavbar(),"Popular NavBar is not working");
        Assert.assertTrue(headerPgTest.findHomeHeaderAccountNavbar(),"Account NavBar is not working");
        Assert.assertTrue(headerPgTest.findHomeHeaderSearchNavbar(),"Search NavBar is not working");
    }

    @Test(priority = 2)
    public void testHeaderSectionFunctionalities() {
        // Test The Header Page Of Home
        WebElement homeNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeNavLink.click();
        String homePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,"https://qamoviesapp.ccbp.tech/","Home page url does not match");

        // Test The Header Page Of Popular
        WebElement popularNavLink = driver.findElement(By.xpath("//a[contains(text(), 'Popular')]"));
        popularNavLink.click();
        String popularPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(popularPageUrl,"https://qamoviesapp.ccbp.tech/popular","Popular page url does not match");


        // Test The Header Page Of Account
        WebElement accountBtn = driver.findElement(By.className("avatar-button"));
        accountBtn.click();
        String accountUrl = driver.getCurrentUrl();
        Assert.assertEquals(accountUrl,"https://qamoviesapp.ccbp.tech/account","Account page url does not match");
    }
}
