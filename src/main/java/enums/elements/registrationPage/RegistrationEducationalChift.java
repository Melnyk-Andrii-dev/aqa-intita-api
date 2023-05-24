package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RegistrationEducationalChift {
    MORNING("morning_chift"),
    EVENING("evening_chift"),
    ALLONE("all_one_chift");

    private final String xPath;

    public String toString(){
        return xPath;
    }
}
