import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public static WebDriver driver;
    public HomePage homePageTest;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePageTest = new HomePage(driver);
        homePageTest.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testTheHomePg() {
        // Test the heading texts of section
        Assert.assertEquals(homePageTest.getHomePgHeading(),homePageTest.getHomePgHeading(),"HomePg heading not found");

        // Test whether the play button is displayed or not
        Assert.assertTrue(homePageTest.checkHomePgPlayBtn(),"PlayBtn is not Working");

        // Test whether the Movies are displayed, in the corresponding movies sections
        Assert.assertTrue(homePageTest.checkHomePgMoviesSection(),"Movie are not displayed in the corresponding movies sections");

        // Test the Contact Us Section
        Assert.assertTrue(homePageTest.checkHomePgContactUsSection(),"Contact Us section is not displayed");

    }

}
