package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DashboardPage;

public class DasboardSidebarComponentStepdefs {

    private static final DashboardPage dashboardPage = new DashboardPage();

    @When("I click Create task button on DashboardSidebarComponent")
    public void iClickCreateTaskButtonOnDashboardSidebarComponent() {
        dashboardPage.dashboardSidebarComponent().clickCreateTaskButton();
    }

    @And("I click the button My Tasks on Dashboard Sidebar Component")
    public void iClickTheButtonMyTasks() {
        dashboardPage.dashboardSidebarComponent().clickMyTasksButton();
    }
}
