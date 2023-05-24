package enums.taskAttributes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TaskType {
    TASK(1),
    BUG(2),
    FEATURE(3);

    private Integer value;

    public Integer toInt(){
        return value;
    }
}
