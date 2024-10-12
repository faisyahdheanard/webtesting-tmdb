package pages;

import locators.homeLocator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.junit.Assert.*;


public class homePage extends homeLocator {
    WebDriver driver;
    WebDriverWait wait;

    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void navigateToTheWeb() {
        driver.get("https://www.themoviedb.org/");
    }

    public void verifyOnHomePage() {
        wait.until(ExpectedConditions.visibilityOf(VERIFY_MEDIA));
        assertTrue("The 'TMDb Media' is not displayed!", VERIFY_MEDIA.isDisplayed());
    }

    public void clickLanguageIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(ICON_LANGUAGE)).click();
    }

    public void selectLanguage(String language) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_DEFAULT_LANGUAGE)).click();
        WebElement dropdownInput = wait.until(ExpectedConditions.visibilityOf(DROPDOWN_DEFAULT_LANGUAGE_INPUT));
        dropdownInput.sendKeys(language);
        Thread.sleep(3000);
        dropdownInput.sendKeys(Keys.ENTER);
    }

    public void clickReloadPageButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_COMMON_USE_A(" Reload Page"))).click();
    }

    public void verifyInterfaceLanguage(String word) throws InterruptedException {
        Map<String, String> languageText = Map.of(
                "Indonesian", "Selamat datang",
                "Inggris", "Welcome."
        );

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(VERIFY_TEXT_TITLE_LANGUAGE));

        String actualText = VERIFY_TEXT_TITLE_LANGUAGE.getText().trim();
        String expectedText = languageText.get(word).trim();

        if (expectedText == null) {
            throw new IllegalArgumentException("Unsupported language: " + word);
        }
        assertEquals("Text mismatch for language: " + word, expectedText, actualText.replaceAll("[\\r\\n]+", ""));
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN)).click();
    }

    public void clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_HOME)).click();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_SEARCH)).click();
    }

    public void searchMovie(String movie) {
        wait.until(ExpectedConditions.visibilityOf(FIELD_SEARCH)).sendKeys(movie, Keys.ENTER);
    }

    public void clickMovieTitle(String movie) {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_COMMON_USE_H2(movie))).click();
    }

    public void navigateToProfilePage(String word) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(ICON_PROFILE)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_VIEW_PROFILE(word))).click();
        Thread.sleep(3000);
    }
}