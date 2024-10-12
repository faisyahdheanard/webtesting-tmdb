package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginLocator {

    @FindBy(xpath = "//h2[contains(text(), 'Login to your account')]")
    protected WebElement VERIFY_TEXT_LOGIN_TO_YOUR_ACCOUNT;

    @FindBy(css = "[id='username']")
    protected WebElement FIELD_USERNAME;

    @FindBy(css = "[id='password']")
    protected WebElement FIELD_PASSWORD;

    @FindBy(css = "[id='login_button']")
    protected WebElement BUTTON_LOGIN;

}
