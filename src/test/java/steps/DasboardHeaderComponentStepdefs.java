package steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.DashboardPage;


public class DasboardHeaderComponentStepdefs {

    private static final DashboardPage dashboardPage = new DashboardPage();

    @Then("The page {string} is opened")
    @Then("The Task Creation page {string} is opened")
    public void aPageIsOpened(String expectedBreadcrumbFieldText){
        String actualBreadcrumbFieldText = dashboardPage.dashboardHeaderComponent().getBreadcrumbFieldText();
        Assertions.assertThat(actualBreadcrumbFieldText)
                .as("Actual: "+ actualBreadcrumbFieldText + " Expected: " + expectedBreadcrumbFieldText)
                .isEqualTo(expectedBreadcrumbFieldText);
    }
}
