package enums.userAttrubutes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserEmail {
    ADMIN("admin@qaintita.com"),
    CMANAGER_EMAIL("cmanager@qaintita.com");

    private final String value;

    public String toString(){
        return value;
    }
}
