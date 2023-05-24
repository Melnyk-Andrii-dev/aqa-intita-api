package enums.elements.taskCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRoleButton {
    PERFORMER("Виконавець"),
    DIRECTOR("Постановник"),
    RESPONSIBLE("Відповідальний"),
    OBSERVER("Спостерігач");

    private final String userRole;

    @Override
    public String toString() {
        return userRole;
    }
}
