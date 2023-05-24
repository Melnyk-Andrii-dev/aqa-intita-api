package enums.elements.editProfilePage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChangePasswordTextInput {
    CURRENT_PASSWORD("actual_pass"),
    NEW_PASSWORD("new_pass"),
    CONFIRM_PASSWORD("confirm_pass");

    private final String xPath;

    public String toString() {
        return xPath;
    }


}
