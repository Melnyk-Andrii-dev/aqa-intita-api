package pages;

import enums.elements.myTasksPage.KanbanColumns;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTasksPage extends BasePage {

    private static final String MY_TASKS_INDICATOR = "//div[@id='kanbanBoard']";
    private static final String KANBAN_COLUMN = "//div[@id='%s']";
    private static final String TICKET_IN_COLUMN = KANBAN_COLUMN + "/div";
    private static final String TICKET_DETAILS_BUTTON = TICKET_IN_COLUMN + "//a[@class='show-task']";
    private static final String TICKET_ID = "//div[@id='%s']/div//self::span[@class='kanbancard-header__date']";
    private static final String TICKET_TITLE = "//div//span[@class='kanbancard-header__name']";
    private static final String TICKET_COLUMN = "//span[contains(text(), '%s')]//ancestor::div[@class='list-group']";
    private static final String SEARCH_BY_TITLE_FORM = "//input[@class='kanban-header__search-item' and @name='taskName']";
    private static final String SEARCH_BUTTON = "//i[@class='fa fa-search']";
    private static final String TICKET_PRIORITY = "//span[@class='kanbancard-header__priority']";
    private static final String FILTER_BY_PRIORITY_BUTTON = "//span[contains(text(), 'Пріоритети')]";
    private static final String HIGHER_PRIORITY_OPTION = "//div[contains(@class, 'multiselect--active')]//li[@class='multiselect__element']//span[contains(@class, 'multiselect__option')]/span";
    private static final String SELECTED_PRIORITY = "//input[@placeholder='Пріоритети']//following-sibling::span[@class='multiselect__single']";

    public boolean isMyTasksPageOpened() {
        return isElementPresent(MY_TASKS_INDICATOR);
    }

    public int columnTicketsCount(KanbanColumns column) {
        return findAllElementsByXPath(String.format(TICKET_IN_COLUMN, column)).size();
    }

    public void clickUpperTicketDetails(KanbanColumns column) {
        findElementByXPath(String.format(TICKET_DETAILS_BUTTON, column.toString())).click();
    }

    public String getTicketId(KanbanColumns column) {
        return findElementByXPath(String.format(TICKET_ID, column)).getText().substring(14, 18);
    }

    public String findColumnOfTicket(String ticketId) {
        return findElementByXPath(String.format(TICKET_COLUMN, ticketId)).getAttribute("id");
    }

    public boolean isTicketInColumn(String ticketId, KanbanColumns column) {
        return findColumnOfTicket(ticketId).equals(column.toString());
    }

    public List<String> collectAllTicketTitles() {
        List<WebElement> allTicketTitles = findAllElementsByXPath(TICKET_TITLE);
        return allTicketTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void fillSearchByTitleForm(String title) {
        findElementByXPath(SEARCH_BY_TITLE_FORM).sendKeys(title);
    }

    public void clickSearchButton() {
        waitForClickabilityOfElement(SEARCH_BUTTON);
        findElementByXPath(SEARCH_BUTTON).click();
        waitForClickabilityOfElement(SEARCH_BUTTON);
    }

    public ArrayList<String> collectAllTicketPriorities() {
        ArrayList<WebElement> allTicketPriorities = new ArrayList<>(findAllElementsByXPath(TICKET_PRIORITY));
        List<String> prioritiesAsString = allTicketPriorities.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return (ArrayList<String>) prioritiesAsString;
    }

    public void clickFilterByPriority() {
        findElementByXPath(FILTER_BY_PRIORITY_BUTTON).click();
    }

    public void selectHigherPriority() {
        findElementByXPath(HIGHER_PRIORITY_OPTION).click();
    }

    public String getSelectedPriority() {
        return findElementByXPath(SELECTED_PRIORITY).getText();
    }
}


