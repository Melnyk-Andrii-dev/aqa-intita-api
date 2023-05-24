package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExtendedRegistrationMessage {
    THANKS_FOR_REGISTRATION_MESSAGE("Дякуємо за реєстрацію"),
    INCORRECT_PASSWORD_MESSAGE("Будь ласка заповни поле");

    private final String message;

    @Override
    public String toString() {
        return message;
    }
}
