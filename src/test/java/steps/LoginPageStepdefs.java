package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

public class LoginPageStepdefs {
    private static final LoginPage loginPage = new LoginPage();

    @Given("Login page is opened in pop up")
    public void loginPageIsOpenedInPopUp() {
        loginPage.headerComponent().clickHeaderLoginButton();
    }

    @When("I enter email {string} on Login page")
    public void iEnterEmailInTheFieldOnLoginPage(String email) {
        loginPage.inputEmailToEmailField(email);
    }

    @When("I enter password {string} on Login page")
    public void iEnterPasswordInTheFieldOnLoginPage(String password) {
        loginPage.inputPasswordToPasswordField(password);
    }

    @And("I click Sign in button on Login page")
    public void iClickSignInButtonOnLoginPage() {
        loginPage.clickSignInButton();
    }

    @When("I click button Sign up")
    public void iClickButtonSignUp() {
        loginPage.clickSignUpButton();
    }

    @Then("The {string} message is displayed under the password field")
    public void theIncorrectEmailOrPasswordMessageIsDisplayedUnderThePasswordField(String message) {

        String  incorrectEmailOrPasswordDisplayedMessage = loginPage.getIncorrectEmailOrPasswordDisplayedMessage();

        Assertions.assertThat(incorrectEmailOrPasswordDisplayedMessage).as(String.format("Expected: %s, Actual: %s", message, incorrectEmailOrPasswordDisplayedMessage)).isEqualTo(message);

    }
}


