package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExtendedRegistration {
    NAME ("firstName"),
    LAST_NAME ("secondName"),
    NICKNAME ("nickname"),
    DATA_OF_BIRTH ("birthday"),
    COUNTRY ("address_country"),
    ADDRESS ("address"),
    PHONE ("phone"),
    EMAIL ("email"),
    PASSWORD ("password"),
    RE_ENTER_PASSWORD ("password_confirmation"),
    ABOUT_MYSELF ("aboutMy"),
    INTERESTS ("interests"),
    PREVIOUS_JOB ("prev_job"),
    CURRENT_JOB ("current_job"),
    INFORMATION_SOURCE ("aboutUs"),
    SKYPE ("skype"),
    FACEBOOK ("facebook"),
    LINKEDIN ("linkedin"),
    TWITTER ("twitter");

    private final String xpathField;

    @Override
    public String toString(){
        return xpathField;
    }
}
