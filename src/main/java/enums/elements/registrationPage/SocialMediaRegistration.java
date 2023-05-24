package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SocialMediaRegistration {
    FACEBOOK("facebook"),
    LINKEDIN("linkedin"),
    GOOGLE("google");

    private final String button;

    @Override
    public String toString() {
        return button;
    }
}
