package steps;

import enums.elements.headerNavbarComponent.LanguageDropdownButton;
import enums.elements.headerNavbarComponent.ProjectDropdownMenuButton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

public class HeaderStepdefs {

    private static final LoginPage loginPage = new LoginPage();

    @Then("My Start page is displayed")
    public void myStartPageIsDisplayed() {
       Assertions.assertThat(loginPage.headerComponent().isStartPageVisible()).isTrue();
    }

    @Then("My Start page is not displayed")
    public void myStartPageIsNotDisplayed() {
        Assertions.assertThat(loginPage.headerComponent().isStartPageVisible()).isFalse();
    }

    @Then("My Start page is displayed {}")
    public void myStartPageIsDisplayed(boolean isDisplayed) {
        Assertions.assertThat(loginPage.headerComponent().isStartPageVisible()).isEqualTo(isDisplayed);
    }

    @And("I choose {} in Language Dropdown Button")
    public void iChooseLanguageInLanguageDropdownButton(LanguageDropdownButton button) {
        loginPage.headerComponent().clickHeaderLanguageButton();
//        loginPage.headerComponent().clickLanguageDropdownButton(button);
    }

    @When("I click Dropdown profile button on Header Component")
    public void iClickDropdownProfileButtonOnHeaderComponent() {
        loginPage.headerComponent().clickDropdownProfileButton();
    }

    @When("I click {} in dropdown menu on HeaderComponent")
    public void iClickProjectDropdownMenuButtonOnHeaderComponent(ProjectDropdownMenuButton projectDropdownMenuButton) {
        loginPage.headerComponent().clickProjectDropdownMenuButton(projectDropdownMenuButton);
    }
}
