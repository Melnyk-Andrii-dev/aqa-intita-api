package enums.elements.editProfilePage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MainTextInput {
    FIRSTNAME("firstName"),
    LASTNAME("secondName"),
    NICKNAME("nickname"),
    ADDRESS("address"),
    PHONE("phone"),
    EMAIL("email"),
    ABOUTME("aboutMy"),
    INTERESTS("interests"),
    EDUCATION("education"),
    PREVIOUS_JOB("prev_job"),
    CURRENT_JOB("current_job"),
    ABOUTUS_SOURCE("aboutUs"),
    SKYPE("skype"),
    LINKEDIN("linkedin"),
    TWITTER("twitter");

    private final String xPath;

    public String toString(){
        return xPath;
    }
}
