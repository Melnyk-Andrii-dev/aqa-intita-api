package pages;

import enums.elements.headerNavbarComponent.HeaderNavbarButton;
import enums.elements.headerNavbarComponent.LanguageDropdownButton;
import enums.elements.headerNavbarComponent.ProjectDropdownMenuButton;
import org.openqa.selenium.JavascriptExecutor;

public class HeaderComponent extends AbstractPage {
    private static final String HEADER_NAVBAR_BUTTON = "//div[@class='navbar__desktop']//child::a[@href='/%s']";
    private static final String HEADER_LANGUAGE_BUTTON = "//div[@id='dropdownLgButton']";
    private static final String LANGUAGE_DROPDOWN_BUTTON = "//a[text()='%s']";
    private static final String HEADER_LOGIN_BUTTON = "//button[text()='Log in' or text()='Вхід']";
    private static final String AVATAR_BUTTON = "//div/child::img[@title='avatar']";
    private static final String PROJECT_DROPDOWN_MENU_BUTTON = "//li[@class='project-dropdown-menu__item']/child::a[text()='%s']";
    private static final String DROPDOWN_PROFILE_BUTTON = "//div[@id='dropdownProfileButton']";
    private static final String DASHBOARD_DROPDOWN_MENU_BUTTON = "//li[@class='project-dropdown-menu__item']/a[contains(@href, 'cabinet')]";


    public void clickHeaderNavbarButton(HeaderNavbarButton button) {
        findElementByXPath(String.format(HEADER_NAVBAR_BUTTON, button.toString())).click();
    }

    public void clickHeaderLanguageButton(){
        findElementByXPath(HEADER_LANGUAGE_BUTTON).click();
        ((JavascriptExecutor) getDriverThreadLocal()).executeScript("arguments[0].click();", LANGUAGE_DROPDOWN_BUTTON);
    }

    public void clickLanguageDropdownButton(LanguageDropdownButton button) {
        findElementByXPath(String.format(LANGUAGE_DROPDOWN_BUTTON, button.toString())).click();
    }

    public void clickHeaderLoginButton(){
        findElementByXPath(HEADER_LOGIN_BUTTON).click();
    }

    public void clickAvatarButton(){
        findElementByXPath(AVATAR_BUTTON).click();
    }

    public void clickDropdownProfileButton() {
            findElementByXPath(DROPDOWN_PROFILE_BUTTON).click();
    }

    public void clickDashboardDropdownMenuButton() {
        findElementByXPath(DASHBOARD_DROPDOWN_MENU_BUTTON).click();
    }


    public Boolean isStartPageVisible() {
        return isElementPresent(AVATAR_BUTTON);
    }

    public Boolean isAvatarButtonDisplayed () {
        return findElementByXPath(AVATAR_BUTTON).isDisplayed();
    }

    public void clickProjectDropdownMenuButton(ProjectDropdownMenuButton button){
        findElementByXPath(String.format(PROJECT_DROPDOWN_MENU_BUTTON, button)).click();
    }
}
