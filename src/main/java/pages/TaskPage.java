package pages;

public class TaskPage extends BasePage{

    private static final String TASK_NAME = "//div[@title='Назва']";
    private static final String TASK_CARD = "//span[@class='kanbancard-header__name' and text()='%s']";

    public Boolean isTaskNameDisplayed(){
        return isElementPresent(TASK_NAME);
    }

    public String getTaskName(){
        return findElementByXPath(TASK_NAME).getText();
    }

    public Boolean isTaskCardPresent(String taskName){
        return isElementPresent(String.format(TASK_CARD, taskName));
    }
}
