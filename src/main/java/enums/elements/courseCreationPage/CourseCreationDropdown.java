package enums.elements.courseCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CourseCreationDropdown {
    LANGUAGE("Українською"),
    ONLINE_STATUS("розробляється"),
    LEVEL("стажер");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
