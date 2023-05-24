package enums.elements.taskCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorMessage {
    NO_DATA_ERROR_MESSAGE("Будь ласка заповни поле");

    private final String message;

    @Override
    public String toString() {
        return message;
    }
}
