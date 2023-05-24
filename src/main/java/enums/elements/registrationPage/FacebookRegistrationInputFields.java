package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FacebookRegistrationInputFields {
    FACEBOOK_EMAIL ("email"),
    FACEBOOK_PASSWORD("pass");

    private final String field;

    @Override
    public String toString(){
        return field;
    }
}
