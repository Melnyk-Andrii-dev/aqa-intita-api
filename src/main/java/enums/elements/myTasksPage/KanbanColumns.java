package enums.elements.myTasksPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum KanbanColumns {
    EXPECT_EXECUTION("expectToExecute"),
    IN_PROGRESS("execute"),
    PAUSED("pause"),
    DONE("complete");

    private final String xPath;

    public String toString() {
        return xPath;
    }

}
