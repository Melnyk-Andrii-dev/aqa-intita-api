package enums.elements.dashboardPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContentDropdownButton {
    COURSES_CONTENT_DROPDOWN_BUTTON("Курси"),
    MODULES_CONTENT_DROPDOWN_BUTTON("Модулі"),
    TESTS_CONTENT_DROPDOWN_BUTTON("Тести");

    private String field;


    @Override
    public String toString() {
        return field;
    }
}
