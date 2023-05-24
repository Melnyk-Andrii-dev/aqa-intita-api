package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExtendedRegistrationFieldEnam {

    EARLY_CAREER_FIELD("careers");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }

}







