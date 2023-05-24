package steps;

import io.cucumber.java.en.When;
import rest.RegistrationRestClient;

public class RegistrationApiStepdefs {

    RegistrationRestClient registrationRestClient = new RegistrationRestClient();

    @When("I send registration new account request with random email and password {string} and I see 200 code")
    public void iSendRegistrationNewAccountRequest(String password) {
        registrationRestClient.sendRegistrationRequest(password);
    }
}
