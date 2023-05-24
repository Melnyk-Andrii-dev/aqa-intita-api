package pages;

import enums.elements.taskCreationPage.CalendarButton;
import enums.elements.taskCreationPage.UserRoleButton;

public class TaskCreationPage extends BasePage {

    private static final String TASK_NAME_FIELD = "//input[@placeholder='Назва']";
    private static final String CALENDAR_BUTTON = "//input[@placeholder='%s']";
    private static final String CALENDAR_DATE = "//div[@class='flatpickr-calendar animate open arrowTop']" +
            "//span[@class='flatpickr-day today']";
    private static final String COMPLETION_TIME = "//input[@placeholder='Час виконання (год.)']";
    private static final String USER_ROLE_BUTTON = "//span[contains(text(),'%s')]";
    private static final String TYPE_DROPDOWN = "//span[contains(text(),'Завдання')]";
    private static final String BUG_TYPE_DROPDOWN = "//span[@class='multiselect__option " +
            "multiselect__option--highlight']//child::span[text()='Баг']";
    private static final String PRIORITY_DROPDOWN = "//span[contains(text(),'Середній')]";
    private static final String PRIORITY_DROPDOWN_BUTTON = "//span[@class='multiselect__option " +
            "multiselect__option--highlight']//child::span[text()='Низький']";
    private static final String IFRAME = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
    private static final String BODY_FIELD = "//html[@dir='ltr']//p";
    private static final String SAVE_TASK_BUTTON = "//button[@class='btn m-2 btn-outline-success']";
    private static final String NO_NAME_ERROR_MESSAGE = "//div[@class='error-text']";

    public void inputDataToTaskNameField(String name) {
        findElementByXPath(TASK_NAME_FIELD).sendKeys(name);
    }

    public void clickBeginButton(CalendarButton button) {
        findElementByXPath(String.format(CALENDAR_BUTTON, button.toString())).click();
    }

    public void clickCalendarDate() {
        findElementByXPath(CALENDAR_DATE).click();
    }

    public void inputDataToCompletionTimeField(String time) {
        findElementByXPath(COMPLETION_TIME).sendKeys(time);
    }

    public void clickUserRoleButton(UserRoleButton userRole) {
        findElementByXPath(String.format(USER_ROLE_BUTTON, userRole.toString())).click();
    }

    public void clickTypeDropdown() {
        findElementByXPath(TYPE_DROPDOWN).click();
    }

    public void clickBugTypeDropdown() {
        findElementByXPath(BUG_TYPE_DROPDOWN).click();
    }

    public void clickPriorityDropdown() {
        findElementByXPath(PRIORITY_DROPDOWN).click();
    }

    public void clickPriorityDropdownButton() {
        findElementByXPath(PRIORITY_DROPDOWN_BUTTON).click();
    }

    public void inputDataToBodyField(String data) {
        getDriverThreadLocal().switchTo().frame(findElementByXPath(IFRAME));
        findElementByXPath(BODY_FIELD).sendKeys(data);
        getDriverThreadLocal().switchTo().parentFrame();
    }

    public void clickSaveTaskButton() {
        findElementByXPath(SAVE_TASK_BUTTON).click();
    }

    public String noNameErrorMessageGetText() {
        return findElementByXPath(NO_NAME_ERROR_MESSAGE).getText();
    }
}
