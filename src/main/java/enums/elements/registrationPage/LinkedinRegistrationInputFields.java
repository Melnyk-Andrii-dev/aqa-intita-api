package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LinkedinRegistrationInputFields {
    LINKEDIN_EMAIL ("text"),
    LINKEDIN_PASSWORD("password");

    private final String field;

    @Override
    public String toString(){
        return field;
    }
}
