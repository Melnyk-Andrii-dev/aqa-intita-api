package enums.elements.editProfilePage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EducationShift {
    MORNING("1"),
    EVENING("2"),
    INDIFFERENTLY("3");


    private final String xPath;

    public String toString(){
        return xPath;
    }
}
