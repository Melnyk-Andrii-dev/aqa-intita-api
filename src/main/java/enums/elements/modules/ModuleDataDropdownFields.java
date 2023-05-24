package enums.elements.modules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ModuleDataDropdownFields {

    LEVEL ("стажер"),
    LANGUAGE ("Українською"),
    ONLINE_STATUS ("розробляється"),
    OFFLINE_STATUS ("розробляється");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }
}
