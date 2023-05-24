package enums.elements.listOfAllServicesPage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AllServicesNames {

    FULL_STACK_PHP("Інтернет-програміст (Full Stack, РНР)"),
    JAVA_DEVELOPER("Програміст (Java)");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }
}
