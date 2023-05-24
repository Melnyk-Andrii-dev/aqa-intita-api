package pages;

import enums.elements.ticketDetailsPage.TicketStatuses;

public class TicketDetailsPage extends BasePage{
    private static final String STATUS_BUTTONS = "//div[@class='detailed-task__states']//i[contains(@class, '%s')]";
    private static final String MY_TASKS_LINK = "//li[@class='breadcrumb-item']/a[text()='Завдання']";

    public void changeTicketStatus(TicketStatuses status){
        findElementByXPath(String.format(STATUS_BUTTONS, status.toString())).click();
    }

    public void clickMyTasksLink(){
        findElementByXPath(MY_TASKS_LINK).click();
    }
}
