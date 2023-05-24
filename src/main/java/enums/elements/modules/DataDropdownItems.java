package enums.elements.modules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DataDropdownItems {

    TRAINEE ("стажер"),
    JUNIOR ("початківець"),
    STRONG_JUNIOR ("сильний початківець"),
    MIDDLE ("середній"),
    HIGH("високий"),
    RUSSIAN_LANGUAGE("Російською"),
    UKRAINIAN_LANGUAGE("Українською"),
    ENGLISH_LANGUAGE("Англійською"),
    AVAILABLE("доступний"),
    IN_DEVELOPMENT ("розробляється");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }
}
