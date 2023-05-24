package steps;

import enums.elements.dashboardPage.ContentDropdownButton;
import io.cucumber.java.en.And;
import pages.DashboardPage;

public class DashboardPageStepdefs {

    private static final DashboardPage dashboardPage = new DashboardPage();

    @And("I click Content Button on DashboardPage")
    public void iClickContentButtonOnDashboardPage() {
        dashboardPage.clickContentButton();
    }

    @And("I click {} on Dashboard Page")
    public void iClickContentDropdownButtonONOnDashboardPage(ContentDropdownButton contentDropdownButton) {
        dashboardPage.clickContentDropdownButton(contentDropdownButton);
    }
}
