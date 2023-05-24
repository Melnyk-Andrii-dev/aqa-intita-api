package enums.elements.ticketDetailsPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TicketStatuses {
    IN_PROGRESS("play"),
    PAUSED("pause"),
    DONE("check");

    private final String xPath;

    public String toString() {
        return xPath;
    }
}
