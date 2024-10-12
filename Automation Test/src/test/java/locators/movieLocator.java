package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class movieLocator {

    @FindBy(css = "[class='glyphicons_v2 heart white true']")
    protected WebElement VERIFY_ICON_HEART_FILLED_COLOR;

    @FindBy(css = "[class='glyphicons_v2 heart white false']")
    protected WebElement VERIFY_ICON_HEART_FADE_COLOR;

    @FindBy(css = "[id='favourite']")
    protected WebElement ICON_HEART;

    @FindBy(css = "[class='k-tooltip-content']")
    protected WebElement VERIFY_TOOLTIP_ALERT;

}
