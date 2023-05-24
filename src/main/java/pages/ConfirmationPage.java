package pages;

public class ConfirmationPage extends BasePage{

    private static final String INFOBLOCK = "//div[@class='infoblock']//h2";

    public String getConfirmMessage() {
        return findElementByXPath(INFOBLOCK).getText();
    }
}
