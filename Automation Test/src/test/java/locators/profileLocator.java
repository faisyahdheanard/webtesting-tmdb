package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class profileLocator {

    @FindBy(css = "[class='avatar']")
    protected WebElement VERIFY_AVATAR;

    protected By BUTTON_FAVORITE_MOVIE(String movie) {
        return By.xpath("//li[@id=\"new_shortcut_bar_mn_active\"]//a[contains(text(), '" + movie + "')]");
    }

    protected By BUTTON_COMMON_USE_H2(String element) {
        return By.xpath("//h2[contains(text(), '" + element + "')]");
    }

    protected By BUTTON_COMMON_USE_SPAN(String element) {
        return By.xpath("//span[contains(text(), '" + element + "')]");
    }
}
