package enums.userAttrubutes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserId {
    ADMIN(2525);

    private final Integer value;

    public Integer toInt() {
        return value;
    }
}
