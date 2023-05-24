package enums.elements.registrationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum IncorrectInputFieldMessage {

    INCORRECT_EMAIL_MESSAGE("Електронна пошта не являється правильною"),
    INCORRECT_PASSWORD_MESSAGE("Будь ласка заповни поле");

    private final String message;

    @Override
    public String toString() {
        return message;
    }
}
