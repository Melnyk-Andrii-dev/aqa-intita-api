package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TableFields {
    FIELD("field"),
    TEXT("text");

    private final String name;

    @Override
    public String toString(){
        return name;
    }
}
