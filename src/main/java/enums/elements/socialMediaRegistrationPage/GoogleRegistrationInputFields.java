package enums.elements.socialMediaRegistrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GoogleRegistrationInputFields {
    GOOGLE_EMAIL ("email"),
    GOOGLE_PASSWORD("password");

    private final String field;

    @Override
    public String toString(){
        return field;
    }
}
