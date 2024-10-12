package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homeLocator {

    @FindBy(css = "[id='media_v4']")
    protected WebElement VERIFY_MEDIA;

    @FindBy(css = "[class='translate']")
    protected WebElement ICON_LANGUAGE;

    @FindBy(css = "[aria-labelledby='default_language_popup_label']")
    protected WebElement DROPDOWN_DEFAULT_LANGUAGE;

    @FindBy(xpath = "//input[@aria-owns='default_language_popup_listbox']")
    protected WebElement DROPDOWN_DEFAULT_LANGUAGE_INPUT;

    @FindBy(xpath = "//div[@class='title']/h2")
    protected WebElement VERIFY_TEXT_TITLE_LANGUAGE;

    @FindBy(css = "[class='no_click tooltip_hover']")
    protected WebElement ICON_PROFILE;

    @FindBy(css = "[aria-label='Login']")
    protected WebElement BUTTON_LOGIN;

    @FindBy(css = "[class='logo']")
    protected WebElement BUTTON_HOME;

    @FindBy(css = "[class='glyph search_buttons']")
    protected WebElement BUTTON_SEARCH;

    @FindBy(css = "[id='search_v4']")
    protected WebElement FIELD_SEARCH;

    protected By BUTTON_VIEW_PROFILE(String element) {
        return By.xpath("//div[@class='k-animation-container']//a[contains(text(), '" + element + "')]");
    }

    protected By BUTTON_COMMON_USE_A(String element) {
        return By.xpath("//a[contains(text(), '" + element + "')]");
    }

    protected By BUTTON_COMMON_USE_H2(String element) {
        return By.xpath("//h2[contains(text(), '" + element + "')]");
    }
}
