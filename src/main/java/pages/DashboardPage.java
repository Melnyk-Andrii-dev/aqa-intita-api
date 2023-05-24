package pages;

import enums.elements.dashboardPage.ContentDropdownButton;

public class DashboardPage extends BasePage{

    private static final String CONTENT_BUTTON = "//span[contains(text(),'Наповнення контенту')]";
    private static final String CONTENT_DROPDOWN_BUTTON = "//a[contains(text(),'%s')]";
    private static final String MY_TASKS_BUTTON = "//a[contains(@href, 'tasks') and @class='nav-link']";

    public void clickMyTasksButton() {
        findElementByXPath(MY_TASKS_BUTTON).click();
    }
    public void clickContentButton(){
        findElementByXPath(CONTENT_BUTTON).click();
    }

    public void clickContentDropdownButton(ContentDropdownButton contentDropdownButton){
        findElementByXPath(String.format(CONTENT_DROPDOWN_BUTTON, contentDropdownButton)).click();
    }
}
