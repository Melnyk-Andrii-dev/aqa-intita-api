package pages;

import enums.elements.listOfAllServicesPage.AllServicesNames;

public class ServicesPage extends BasePage {

    private static final String COURSE_NAME_BUTTON = "//div[@title='%s']";
    private static final String SERVICES_HEADING = "//div[@class='services-top-title']";

    public void clickCourseNameButton(AllServicesNames button){
        findElementByXPath(String.format(COURSE_NAME_BUTTON, button.toString())).click();
    }

    public Boolean isServiceHeadingVisible(){
        return findElementByXPath(SERVICES_HEADING).isDisplayed();
    }

}
