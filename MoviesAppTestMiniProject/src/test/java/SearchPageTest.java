import Pages.PopularPage;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.time.Duration;

public class SearchPageTest {
    public static WebDriver driver;
    public SearchPage searchpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        searchpage = new SearchPage(driver);
        searchpage.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testSearchPgMoviesSearchFunctionality() {
        // Test the Search functionality by searching with some movie names and the count of movies displayed
        WebElement searchbtnFindEl = driver.findElement(By.className("search-empty-button"));
        searchbtnFindEl.click();

        WebElement searchInputEl = driver.findElement(By.id("search"));
        searchInputEl.sendKeys("Titanic");

        WebElement searchBtnEl = driver.findElement(By.className("search-button"));
        searchBtnEl.click();

        List<WebElement> moviesFoundEl = driver.findElements(By.className("movie-icon-item"));

        if(moviesFoundEl.size() == 1) {
            System.out.println("Movies search function No-Of-Movies : " + moviesFoundEl.size());
        }
        else {
            System.out.println("Movies search function is not working");
        }
    }

    @Test(priority = 2)
    public void testSearchFunctionalityWithFailureCase() {
        // Test the failure case in the search functionality by entering invalid movie names, triggering error image and text
        WebElement searchbtnFindEl = driver.findElement(By.className("search-empty-button"));
        searchbtnFindEl.click();

        WebElement searchInputEl = driver.findElement(By.id("search"));
        searchInputEl.sendKeys("JungleBook");

        WebElement searchBtnEl = driver.findElement(By.className("search-button"));
        searchBtnEl.click();

        WebElement errorImgEl = driver.findElement(By.className("not-found-search-image"));

        WebElement errorTxtEl = driver.findElement(By.className("not-found-search-paragraph"));

        boolean is_bothErrorDisplayed = errorImgEl.isDisplayed() && errorTxtEl.isDisplayed();

        if(is_bothErrorDisplayed) {
            System.out.println("Search functionality with failure case is working");
        }
        else {
            System.out.println("Search functionality with failure case is not working");
        }
    }



}
