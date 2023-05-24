package pages;

import enums.elements.editProfilePage.ChangePasswordTextInput;
import enums.elements.editProfilePage.EducationShift;
import enums.elements.editProfilePage.MainSelector;
import enums.elements.editProfilePage.MainTextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class EditProfilePage extends BasePage {
    private static final String MAIN_FORM_TEXT_INPUTFIELDS = "//input[@id='%s']";
    private static final String MAIN_FORM_TEXTAREA_INPUTFIELDS = "//textArea[@id='%s']";
    private static final String UPLOADAVATAR_BUTTON = "//button[@id='pick-avatar']";
    private static final String DOB_DATEPICKER = "//div[@input-id='birthday']";
    private static final String DATE = "//input[@placeholder='введи в форматі дд/мм/рррр']";

    private static final String FIRSTDAY_IN_DATEPICKER = "//span[contains(@class, 'cell') and text()='1']";
    private static final String MAIN_FORM_SELECTORS = "//label[@for='%s']//parent::div//descendant::input";
    private static final String MAIN_FORM_SELECTORS_CLICKAREA = "//label[@for='%s']//parent::div//div[@class='multiselect__select']";
    private static final String CHANGE_PASSWORD_BUTTON = "//span[contains(@data-target, 'changePassword')]";
    private static final String CHANGE_PASSWORD_INDICATOR = "//div[@id='changePasswordModal']";
    private static final String CHANGE_PASSWORD_POPUP_INPUTFIELDS = "//div[@id='changePasswordModal']//input[@name='%s']";
    private static final String CURRPASSWORD_ERROR = "//input[@name='actual_pass']//following-sibling::div[@class='text-danger']";
    private static final String NEWPASSWORD_ERROR = "//input[@name='new_pass']//following-sibling::div[@class='text-danger']";
    private static final String CONFIRMPASSWORD_ERROR = "//input[@name='confirm_pass']//following-sibling::div[@class='text-danger']";
    private static final String CHANGE_PASSWORD_POPUP_SUBMIT_BUTTON = "//div[@id='changePasswordModal']//div[contains(@class, 'body')]//button";
    private static final String CHANGE_EMAIL_BUTTON = "//span[contains(@data-target, 'changeEmail')]";
    private static final String CHANGE_EMAIL_INDICATOR = "//div[@id='changeEmailModal']";
    private static final String CHANGE_EMAIL_POPUP_EMAILFIELD = "//div[@id='changeEmailModal']//input[@name='email']";
    private static final String EMAIL_ERROR = "//input[@name='email']//following-sibling::div[@class='text-danger']";
    private static final String CHANGE_EMAIL_POPUP_SUBMIT_BUTTON = "//div[@id='changeEmailModal']//div[contains(@class, 'body')]//button";
    private static final String EDUCATIONFORM_CHECKBOX_OFFLINE = "//input[@id='educform']";
    private static final String EDUCATIONSHIFT_RADIOBUTTONS = "//label[@id='shift']//parent::div//input[@name='shift'" +
            " and @value='%s']//parent::label";
    private static final String SUBMIT_BUTTON = "//button[contains(@class, 'btn-submit')]";

    Actions actions = new Actions(getDriverThreadLocal());
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriverThreadLocal();

    public void inputMainFormTextFields(String field, String data) {
        if (field.equals(MainTextInput.ABOUTME.toString()) ||
                field.equals(MainTextInput.CURRENT_JOB.toString()) ||
                field.equals(MainTextInput.PREVIOUS_JOB.toString())) {
            findElementByXPath(String.format(MAIN_FORM_TEXTAREA_INPUTFIELDS, field)).sendKeys(data);
            return;
        }
        if (field.equals(MainTextInput.PHONE.toString())) {
            waitForVisibilityOfAllElements(1);
            findElementByXPath(String.format(MAIN_FORM_TEXT_INPUTFIELDS, field)).click();
            waitForVisibilityOfAllElements(1);
        }
        findElementByXPath(String.format(MAIN_FORM_TEXT_INPUTFIELDS, field)).sendKeys(data);
    }

    public void selectMainFormSelectorsEnum(MainSelector selector, String data) {
        findElementByXPath(String.format(MAIN_FORM_SELECTORS, selector.toString())).sendKeys(data, Keys.ENTER);
    }

    public void selectMainFormSelectors(String selector, String data) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                getDriverThreadLocal().findElement(By.xpath(String.format(MAIN_FORM_SELECTORS_CLICKAREA, selector))));
        waitForVisibilityOfAllElements(2);
        actions.click(getDriverThreadLocal().findElement
                (By.xpath(String.format(MAIN_FORM_SELECTORS_CLICKAREA, selector)))).build().perform();
        waitForVisibilityOfAllElements(2);
        actions.sendKeys(data, Keys.ENTER).build().perform();
        waitForVisibilityOfAllElements(2);
    }

    public void selectFirstDayOfCurrentMonthAsDOB() {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                findElementByXPath(DOB_DATEPICKER));
        waitForClickabilityOfElement(DATE);
        findElementByXPath(DATE).click();
        findElementByXPath(FIRSTDAY_IN_DATEPICKER).click();
    }

    public void clickOfflineEducationCheckbox() {
        findElementByXPath(EDUCATIONFORM_CHECKBOX_OFFLINE).click();
    }

    public void chooseEducationShift(EducationShift shift) {
        findElementByXPath(String.format(EDUCATIONSHIFT_RADIOBUTTONS, shift.toString())).click();
    }

    public void clickChangePassword() {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                findElementByXPath(CHANGE_PASSWORD_BUTTON));
        waitForVisibilityOfAllElements(2);
        actions.click(findElementByXPath(CHANGE_PASSWORD_BUTTON)).build().perform();
    }

    public boolean isChangePasswordPopupOpened() {
        return isElementPresent(CHANGE_PASSWORD_INDICATOR);
    }

    public void inputCurrentPassword(ChangePasswordTextInput field, String data) {
        findElementByXPath(String.format(CHANGE_PASSWORD_POPUP_INPUTFIELDS, field.toString())).sendKeys(data);
    }

    public String getCurrentPasswordError() {
        return findElementByXPath(CURRPASSWORD_ERROR).getText();
    }

    public String getNewPasswordError() {
        return findElementByXPath(NEWPASSWORD_ERROR).getText();
    }

    public String getConfirmPasswordError() {
        return findElementByXPath(CONFIRMPASSWORD_ERROR).getText();
    }

    public void clickSubmitPassword() {
        findElementByXPath(CHANGE_PASSWORD_POPUP_SUBMIT_BUTTON).click();
    }

    public boolean isChangeEmailPopupOpened() {
        return
                isElementPresent(CHANGE_EMAIL_INDICATOR);
    }

    public void clickChangeEmail() {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", findElementByXPath(CHANGE_EMAIL_BUTTON));
        waitForVisibilityOfAllElements(2);
        actions.click(findElementByXPath(CHANGE_EMAIL_BUTTON)).build().perform();
    }

    public void inputEmail(String email) {
        findElementByXPath(CHANGE_EMAIL_POPUP_EMAILFIELD).sendKeys(email);
    }

    public String getEmailError() {
        return findElementByXPath(EMAIL_ERROR).getText();
    }

    public void clickSubmitEmail() {
        findElementByXPath(CHANGE_EMAIL_POPUP_SUBMIT_BUTTON).click();
    }

    public void clickSubmitButton() {
        findElementByXPath(SUBMIT_BUTTON).click();
    }

    public void eraseMainFormTextField(String field) {
        if (field.equals(MainTextInput.ABOUTME.toString()) ||
                field.equals(MainTextInput.CURRENT_JOB.toString()) ||
                field.equals(MainTextInput.PREVIOUS_JOB.toString())) {
            findElementByXPath(String.format(MAIN_FORM_TEXTAREA_INPUTFIELDS, field))
                    .sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            return;
        }
        findElementByXPath(String.format("//input[@id='%s']", field))
                .sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }
}
