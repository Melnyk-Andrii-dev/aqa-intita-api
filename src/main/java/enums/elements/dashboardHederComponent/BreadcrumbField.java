package enums.elements.dashboardHederComponent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BreadcrumbField {
    CREATE_COURSE("Створити"),
    REVIEW_COURSES("Перегляд");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
