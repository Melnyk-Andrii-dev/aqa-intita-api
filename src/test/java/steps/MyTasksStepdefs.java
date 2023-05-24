package steps;

import enums.elements.myTasksPage.KanbanColumns;
import enums.elements.ticketDetailsPage.TicketStatuses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyTasksPage;
import pages.TicketDetailsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTasksStepdefs {
    private static final LoginPage loginPage = new LoginPage();
    private static final DashboardPage dashboardPage = new DashboardPage();
    private static final MyTasksPage myTasksPage = new MyTasksPage();
    private static final TicketDetailsPage TICKET_DETAILS_PAGE = new TicketDetailsPage();
    String ticketId;

    @When("I click Dropdown Profile button")
    public void iClickDropdownProfileButton() {
        loginPage.headerComponent().clickDropdownProfileButton();
    }

    @And("I choose Dashboard option")
    public void iChooseDashboardOption() {
        loginPage.headerComponent().clickDashboardDropdownMenuButton();
    }

    @And("I click MyTasks button")
    public void iClickMyTasksButton() {
        dashboardPage.clickMyTasksButton();
    }

    @Then("MyTasks page is opened")
    public void mytasksPageIsOpened() {
        Assertions.assertThat(myTasksPage.isMyTasksPageOpened())
                .as("MyTasks page is not opened").isEqualTo(true);
    }

    @And("More than one ticket are in {} column")
    public void moreThanOneTicketAreInColumn(KanbanColumns column) {
        Assertions.assertThat(myTasksPage.columnTicketsCount(column))
                .as("The number of tickets is different").isGreaterThan(1);
    }

    @When("I change ticket status from {} to {} column")
    public void iChangeTicketStatus(KanbanColumns from, TicketStatuses to) {
        ticketId = myTasksPage.getTicketId(from);
        myTasksPage.clickUpperTicketDetails(from);
        TICKET_DETAILS_PAGE.changeTicketStatus(to);
        TICKET_DETAILS_PAGE.clickMyTasksLink();
    }

    @Then("The ticket is added to {} column")
    public void theTicketIsAddedToColumn(KanbanColumns to) {
        Assertions.assertThat(myTasksPage.isTicketInColumn(ticketId, to))
                .as("The ticket is not present").isEqualTo(true);
    }

    @And("The ticket was removed from {} column")
    public void theTicketWasRemovedFromColumn(KanbanColumns from) {
        Assertions.assertThat(myTasksPage.isTicketInColumn(ticketId, from))
                .as("The ticket is present").isEqualTo(false);
    }

    @When("I fill search by title form with {string}")
    public void iFillSearchByTitleFormWith(String title) {
        myTasksPage.fillSearchByTitleForm(title);
    }

    @And("I click search button")
    public void iClickSearchButton() {
        myTasksPage.clickSearchButton();
        myTasksPage.waitForVisibilityOfAllElements(4);
    }

    @Then("Tickets are filtered by title {string}")
    public void ticketsAreFilteredByTitle(String filteredTitle) {
        List<String> allTicketTitles = myTasksPage.collectAllTicketTitles();
        List<String> filteredTitles = allTicketTitles.stream()
                .filter(title -> title.toLowerCase().contains(filteredTitle))
                .collect(Collectors.toList());
        Assertions.assertThat(filteredTitles)
                .as("Tickets are not filtered by title").hasSameElementsAs(allTicketTitles);
    }

    @Given("There are tickets with different priorities on the board")
    public void thereAreTicketsWithDifferentPrioritiesOnTheBoard() {
        ArrayList<String> allTicketPriorities = myTasksPage.collectAllTicketPriorities();
        String firstPriority = allTicketPriorities.get(0);
        List<String> filteredPriorities = allTicketPriorities.stream()
                .filter(prioriry -> prioriry.equals(firstPriority))
                .collect(Collectors.toList());
        Assertions.assertThat(allTicketPriorities.equals(filteredPriorities))
                .as("Ticket priorities do not differ").isFalse();
    }

    @When("I click FilterByPriority Button")
    public void iClickFilterByPriorityButton() {
        myTasksPage.clickFilterByPriority();
    }

    @And("I select a higher priority option")
    public void iSelectAHigherPriorityOption() {
        myTasksPage.selectHigherPriority();
        myTasksPage.waitForLoading();
    }

    @Then("Tickets are filtered by selected priority")
    public void ticketsAreFilteredBySelectedPriority() {
        ArrayList<String> allTicketPriorities = myTasksPage.collectAllTicketPriorities();
        String selectedPriority = myTasksPage.getSelectedPriority();
        List<String> filteredPriorities = allTicketPriorities.stream()
                .filter(title -> title.contains(selectedPriority))
                .collect(Collectors.toList());
        Assertions.assertThat(allTicketPriorities)
                .as("Tickets are not filtered by priority").hasSameElementsAs(filteredPriorities);
    }

}
