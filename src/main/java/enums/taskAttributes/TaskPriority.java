package enums.taskAttributes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TaskPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4);

    private Integer value;

    public Integer toInt(){
        return value;
    }
}
