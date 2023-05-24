package pages;

public class DashboardSidebarComponent extends AbstractPage{

    private static final String CREATE_TASK_BUTTON = "//a[@class='create-task-btn']";
    private static final String MY_TASKS_BUTTON = "//a[@title='Мої завдання']";

    public void clickCreateTaskButton(){
        findElementByXPath(CREATE_TASK_BUTTON).click();
    }

    public void clickMyTasksButton(){
        findElementByXPath(MY_TASKS_BUTTON).click();
    }
}
