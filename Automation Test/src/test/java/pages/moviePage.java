package pages;

import locators.movieLocator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class moviePage extends movieLocator {
    WebDriver driver;
    WebDriverWait wait;

    public moviePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void verifyAlertIsPresent(String alert) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(ICON_HEART).perform();
            assertEquals(alert, VERIFY_TOOLTIP_ALERT.getText());
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void clickHeartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(ICON_HEART)).click();
    }

    public void verifyHeartIconFilledColor() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(VERIFY_ICON_HEART_FILLED_COLOR));
    }

    public void clickRemoveFromFavoriteButton() throws InterruptedException {
        verifyHeartIconFilledColor();
        clickHeartIcon();
        driver.navigate().refresh();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(VERIFY_ICON_HEART_FADE_COLOR));
    }

}
