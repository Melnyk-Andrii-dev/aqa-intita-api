package enums.elements.courseCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CourseCreationTextarea {
    FOR_WHOM_TEXTAREA("Для кого"),
    WHAT_WILL_YOU_LEARN_TEXTAREA("Чого навчишся"),
    WHAT_WILL_YOU_GET_TEXTAREA("Що отримаєш");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
