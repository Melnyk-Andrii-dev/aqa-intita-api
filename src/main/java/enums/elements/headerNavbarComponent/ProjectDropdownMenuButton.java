package enums.elements.headerNavbarComponent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProjectDropdownMenuButton {
    DASHBOARD_BUTTON("Дошка"),
    PROFILE_BUTTON("Profile"),
    LOG_OUT_BUTTON("Log out");

    private final String button;


    @Override
    public String toString() {
        return button;
    }
}
