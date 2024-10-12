package pages;

import datas.loginData;
import locators.loginLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class loginPage extends loginLocator {
    WebDriver driver;
    WebDriverWait wait;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPage() {
        wait.until(ExpectedConditions.visibilityOf(VERIFY_TEXT_LOGIN_TO_YOUR_ACCOUNT));
        assertTrue("The 'Login to your account' text is not displayed!", VERIFY_TEXT_LOGIN_TO_YOUR_ACCOUNT.isDisplayed());
    }

    public void inputUsernameField() {
        wait.until(ExpectedConditions.visibilityOf(FIELD_USERNAME)).sendKeys(loginData.USERNAME);
    }

    public void inputPasswordField() {
        wait.until(ExpectedConditions.visibilityOf(FIELD_PASSWORD)).sendKeys(loginData.PASSWORD);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN)).click();
    }
}
