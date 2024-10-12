package steps;

import datas.loginData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePage;
import pages.loginPage;
import pages.moviePage;

import java.time.Duration;
import java.util.List;

public class commonStep {
    WebDriver driver;
    WebDriverWait wait;
    loginPage LoginPage;
    moviePage MoviePage;
    homePage HomePage;

    public commonStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.LoginPage = new loginPage(driver);
        this.MoviePage = new moviePage(driver);
        this.HomePage = new homePage(driver);
    }

    public void loginUser() {
        LoginPage.verifyLoginPage();
        LoginPage.inputUsernameField();
        LoginPage.inputPasswordField();
        LoginPage.clickLoginButton();
    }

    public void deleteAllMoviesFromFavorite() throws InterruptedException {
        driver.get("https://www.themoviedb.org/u/" + loginData.USERNAME + "/favorites");

        List<WebElement> movieTitles = driver.findElements(By.cssSelector("[class=\"poster glyphicons_v2 picture grey poster no_image_holder\"]"));
        if (movieTitles.isEmpty()) {
            System.out.println("No favorite movies available");
        } else {
            for (WebElement title : movieTitles) {
                Thread.sleep(3000);
                title.click();
                MoviePage.clickRemoveFromFavoriteButton();
                driver.navigate().back();
                driver.navigate().refresh();
            }
        }
    }

    public void setDefaultLanguage(String language) throws InterruptedException {
        HomePage.clickLanguageIcon();
        HomePage.selectLanguage(language);
        HomePage.clickReloadPageButton();
        HomePage.verifyInterfaceLanguage(language);
    }
}
