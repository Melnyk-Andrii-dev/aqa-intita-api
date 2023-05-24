package enums.elements.taskCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CalendarButton {
    BEGIN("Початок"),
    END("Кінець"),
    DEADLINE("Крайній термін");

    private final String button;

    @Override
    public String toString() {
        return button;
    }
}
