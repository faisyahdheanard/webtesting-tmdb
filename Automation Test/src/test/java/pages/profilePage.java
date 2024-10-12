package pages;

import locators.profileLocator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class profilePage extends profileLocator {
    WebDriver driver;
    WebDriverWait wait;

    public profilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void verifyOnProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(VERIFY_AVATAR));
        assertTrue("The 'Profile Avatar' is not displayed!", VERIFY_AVATAR.isDisplayed());
    }

    public void navigateToMyFavoriteMovieList(String word, String word2 ) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_COMMON_USE_SPAN("Overview"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_COMMON_USE_SPAN(word))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_FAVORITE_MOVIE(word2))).click();
    }

    public void verifyOnMyFavoritePage(String word) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_COMMON_USE_H2(word)));
        WebElement element = driver.findElement(BUTTON_COMMON_USE_H2(word));
        assertTrue("The '" + word + "' text is not displayed!", element.isDisplayed());
    }

    public void verifyMovieIsOnTheList(String movie) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_COMMON_USE_H2(movie)));
        WebElement element = driver.findElement(BUTTON_COMMON_USE_H2(movie));
        assertTrue("The '" + movie + "' movie is not displayed!", element.isDisplayed());
    }

}
