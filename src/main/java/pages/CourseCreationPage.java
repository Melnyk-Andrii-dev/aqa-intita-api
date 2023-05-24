package pages;

import cache.TestCache;
import cache.TestCacheKey;
import enums.elements.courseCreationPage.CourseCreationDropdown;
import enums.elements.courseCreationPage.CourseCreationInputField;
import enums.elements.courseCreationPage.CourseCreationTextarea;
import org.apache.commons.lang3.RandomStringUtils;

import static enums.elements.courseCreationPage.CourseCreationInputField.TERM_OF_INTERNSHIP_INPUT_FIELD;

public class CourseCreationPage extends BasePage {

    private static final String COURSE_CREATION_INPUT_FIELD = "//input[@placeholder='%s']";
    private static final String COURSE_CREATION_DROPDOWN = "//span[text()='%s']";
    private static final String OFFLINE_STATUS_DROPDOWN = "//div[text()='Офлайн-статус']//following::span[text()='розробляється']";
    private static final String COURSE_CREATION_TEXTAREA = "//div[contains(text(),'%s')]//following-sibling::textarea";
    private static final String AUTOPUBLICATE_ALUMNI_CHECKBOX = "//input[@name='autopublicate_alumni']";
    private static final String SAVE_BUTTON = "//button[@class='btn btn-outline-primary']";
    private static final String RETURN_BUTTON = "//button[@class='btn btn-outline-secondary ml-2']";


    public void inputDataInCourseCreationInputField(CourseCreationInputField field, String data) {
        String randomCourseNickname = data + RandomStringUtils.randomAlphanumeric(6);
        findElementByXPath(String.format(COURSE_CREATION_INPUT_FIELD, field.toString()))
                .sendKeys(randomCourseNickname);
        TestCache.putDataInCache(TestCacheKey.COURSE_NICKNAME, randomCourseNickname);
    }

    public void inputTermOfInternship(String data){
        findElementByXPath(String.format(COURSE_CREATION_INPUT_FIELD, TERM_OF_INTERNSHIP_INPUT_FIELD)).sendKeys(data);
    }

    public void clickCourseCreationDropdown(CourseCreationDropdown field) {
        findElementByXPath(String.format(COURSE_CREATION_DROPDOWN, field.toString())).click();
    }

    public void clickCourseCreationDropdownButton(String text) {
        findElementByXPath(String.format(COURSE_CREATION_DROPDOWN, text)).click();
    }

    public void clickOfflineStatusDropdown() {
        findElementByXPath(OFFLINE_STATUS_DROPDOWN).click();
    }

    public void clickAutopublicateAlumniCheckbox() {
        findElementByXPath(AUTOPUBLICATE_ALUMNI_CHECKBOX).click();
    }

    public void clickSaveButton() {
        findElementByXPath(SAVE_BUTTON).click();
    }

    public void clickReturnButton() {
        findElementByXPath(RETURN_BUTTON).click();
    }

    public void inputDataInCourseCreationTextarea(CourseCreationTextarea field, String data) {
        findElementByXPath(String.format(COURSE_CREATION_TEXTAREA, field.toString())).sendKeys(data);
    }
}
