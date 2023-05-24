package enums.elements.headerNavbarComponent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HeaderNavbarButton {
    COURSES_HEADER_NAVBAR_BUTTON("courses"),
    FORPARTNERS_HEADER_NAVBAR_BUTTON("forproviders"),
    ALUMNI_HEADER_NAVBAR_BUTTON("graduate"),
    VACANCIES_HEADER_NAVBAR_BUTTON("https://www.robotamolodi.org"),
    LIBRARY_HEADER_NAVBAR_BUTTON("library"),
    PROVIDERS_HEADER_NAVBAR_BUTTON("providers"),
    NEWS_HEADER_NAVBAR_BUTTON("news");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
