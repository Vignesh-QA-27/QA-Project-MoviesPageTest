import Pages.MovieDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {
    public static WebDriver driver;
    public MovieDetailsPage moviedetailspage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        moviedetailspage = new MovieDetailsPage(driver);
        moviedetailspage.loginToApplication("rahul","rahul@2021");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void quitTheBrowser() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testMovieDetailsPgHomePgUi() {
        // In the Home Page click on any Movie and test all the UI elements present in it
        WebElement homePg = driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[1]/a"));
        homePg.click();

        WebElement homePgTitanicMovie = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div/div[3]/div/a/div/img"));
        homePgTitanicMovie.click();

        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieHeadingTitle(),"MovieDetailsPg Home heading is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieReview(),"MovieDetailsPg Home movies review is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieOverView(),"MovieDetailsPg Home movies overview is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMoviePlayBtn(),"MovieDetailsPg Home playBtn is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieCategories(),"MovieDetailsPg Home movies categories is not found");

        // In the Popular Page click on any Movie and test all the UI elements present in it
        WebElement popularPg = driver.findElement(By.linkText("Popular"));
        popularPg.click();

        WebElement popularPgNarniaMovie = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[16]/a/img"));
        popularPgNarniaMovie.click();

        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieHeadingTitle(),"MovieDetailsPg Popular heading is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieReview(),"MovieDetailsPg Popular movies review is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieOverView(),"MovieDetailsPg Popular movies overview is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMoviePlayBtn(),"MovieDetailsPg Popular playBtn is not found");
        Assert.assertTrue(moviedetailspage.movieDetailPg_FindMovieCategories(),"MovieDetailsPg Popular movies categories is not found");
    }
}
