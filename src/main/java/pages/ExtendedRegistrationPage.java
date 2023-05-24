package pages;

import enums.elements.registrationPage.ExtendedRegistration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class ExtendedRegistrationPage extends BasePage {

    private static final String REGISTRATION_FIELDS = "//div[@class='col-sm-8']//input[@id='%s']";
    private static final String DATE_OF_BIRTH = "//input[@placeholder='введи в форматі дд/мм/рррр']";
    private static final String CLICK_YEAR_LINK = "//div[@class='vdp-datepicker__calendar']//span[@class='prev']";
    private static final String CLICK_ARROW_LINK = "//span[@class='day__month_btn up']";
    private static final String SELECT_MONTH_OF_BIRTH = "//span[text()='Лютий']";
    private static final String SELECT_BIRTHDAY = "//span[contains(@class,'cell day') and text()='8']";
    private static final String COUNTRY_FIELD = "//label[@for='address_country']//parent::div//div[@class='multiselect__select']";
    private static final String SELECT_COUNTRY_FIELD= "//span[text()='Україна']";
    private static final String INPUT_INFORMATION = "//div[@class='col-sm-8']//following::textarea[@name='%s']";
    private static final String INPUT_ADDITIONAL_INFORMATION = "//div[@class='col-sm-8']//following::input[@id='%s']";
    private static final String EARLY_CAREER_FIELD = "//label[@for='careers']//parent::div//div[@class='multiselect__select']";
    private static final String SELECT_CAREER_START_FIELD = "//span[text()='Фріланс']";
    private static final String SPECIALIZATION_FIELD = "//label[@for='specializations']//parent::div//div[@class='multiselect__select']";
    private static final String SELECT_SPECIALIZATION_FIELD = "//span[text()='Ручне тестування']";
    private static final String EDUCATIONAL_FORM_OFFLINE = "//div[@class='form-check offline']//span";
    private static final String SAVE_BUTTON = "//button[text()='ЗБЕРЕГТИ />']";
    private static final String ERROR_MESSAGE = "//div[@class='text-danger input-error error-position']";


    Actions actions = new Actions(getDriverThreadLocal());
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriverThreadLocal();

    public void inputDataToExtendedRegistrationField(String data, ExtendedRegistration field) {
        findElementByXPath(String.format(REGISTRATION_FIELDS, field.toString())).sendKeys(data);
    }
    public void inputEmailToEmailField(ExtendedRegistration field){
        findElementByXPath(String.format(REGISTRATION_FIELDS, field.toString()))
                .sendKeys(String.format("%s@gmail.com", RandomStringUtils.randomAlphanumeric(6)));
    }

    public void clickBirthdayField() {
        findElementByXPath(DATE_OF_BIRTH).click();
    }

    public void clickOnTheYear(){findElementByXPath(CLICK_YEAR_LINK).click();
    }

    public void clickOnTheArrowLink(){findElementByXPath(CLICK_ARROW_LINK).click();
    }

    public void clickOnTheMonthOfBirthday(){findElementByXPath(SELECT_MONTH_OF_BIRTH).click();}

    public void selectDateOfBirth() {findElementByXPath(SELECT_BIRTHDAY).click();
    }

    public void clickCountryField(){findElementByXPath(COUNTRY_FIELD).click();
    }

    public void selectCountry(){findElementByXPath(SELECT_COUNTRY_FIELD).click();
    }

    public void inputYourInformationInTheField(String information, ExtendedRegistration field) {
       findElementByXPath(String.format(INPUT_INFORMATION, field.toString())).sendKeys(information);
    }
    public void inputAdditionalInformationInTheField(String information, ExtendedRegistration field) {
        findElementByXPath(String.format(INPUT_ADDITIONAL_INFORMATION, field.toString())).sendKeys(information);
    }
    public void  iClickInTheSpecializationField() {
        waitForVisibilityOfAllElements(3);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                findElementByXPath(SPECIALIZATION_FIELD));
        waitForVisibilityOfAllElements(3);
        actions.click(findElementByXPath(SPECIALIZATION_FIELD)).build().perform();
        waitForVisibilityOfAllElements(3);
    }

    public void iSelectMySpecialization (){findElementByXPath(SELECT_SPECIALIZATION_FIELD).click();
    }

    public void clickEducationFormCheckbox() {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
                findElementByXPath(EDUCATIONAL_FORM_OFFLINE));
        waitForVisibilityOfAllElements(2);
        actions.click(findElementByXPath(EDUCATIONAL_FORM_OFFLINE)).build().perform();
    }

    public void clickSaveButton() {findElementByXPath(SAVE_BUTTON).click();
    }
    public void clickEarlyCareerField(){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", findElementByXPath(EARLY_CAREER_FIELD));
        waitForVisibilityOfAllElements(2);
        actions.click(findElementByXPath(EARLY_CAREER_FIELD)).build().perform();    }

    public void selectCareerStart(){
        findElementByXPath(SELECT_CAREER_START_FIELD).click();
    }

    public String getErrorMessage(){
        return findAllElementsByXPath(ERROR_MESSAGE).get(0).getText();
    }


}
