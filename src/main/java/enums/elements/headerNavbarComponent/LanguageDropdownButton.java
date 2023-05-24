package enums.elements.headerNavbarComponent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LanguageDropdownButton {
    ENGLISH_LANGUAGE("en"),
    UKRAINIAN_LANGUAGE("ua"),
    RUSSIAN_LANGUAGE("ru");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }
}