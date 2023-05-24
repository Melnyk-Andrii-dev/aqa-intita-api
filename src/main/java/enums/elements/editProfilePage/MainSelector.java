package enums.elements.editProfilePage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MainSelector {
    COUNTRY("address_country"),
    CITY("address_city"),
    START_CAREER("careers"),
    SPECIALIZATION("specializations");

    private final String xPath;

    public String toString() {
        return xPath;
    }

}
