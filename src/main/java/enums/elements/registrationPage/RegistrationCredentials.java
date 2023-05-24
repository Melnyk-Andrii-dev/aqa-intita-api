package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RegistrationCredentials {
    EMAIL ("email"),
    PASSWORD("password");

    private final String field;

    @Override
    public String toString(){
        return field;
    }
}
