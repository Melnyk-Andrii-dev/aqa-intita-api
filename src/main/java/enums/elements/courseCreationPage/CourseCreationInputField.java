package enums.elements.courseCreationPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CourseCreationInputField {
    COURSE_NAME_INPUT_FIELD("Назва*"),
    COURSE_NICKNAME_INPUT_FIELD("Псевдонім*"),
    TERM_OF_INTERNSHIP_INPUT_FIELD("Термін стажування (міс.)");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
