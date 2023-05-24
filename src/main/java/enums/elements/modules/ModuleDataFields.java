package enums.elements.modules;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ModuleDataFields {

    ID ("Унікальний ідентифікатор, використовується при генерації номера договора про оплату курсу"),
    NAME ("Назва*"),
    NICKNAME ("Псевдонім"),
    HOURS ("Годин в день (рекомендований графік занять)"),
    DAYS ("Днів у тиждень (рекомендований графік занять)");

    private final String xPathField;

    @Override
    public String toString() {
        return xPathField;
    }
}
