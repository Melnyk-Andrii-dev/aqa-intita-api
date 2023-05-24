package enums.userAttrubutes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserPassword {
    CMANAGER_PASSWORD("");
    private final String value;

    public String toString() {
        return value;
    }
}
