package pages;

import enums.elements.modules.DataDropdownItems;
import enums.elements.modules.ModuleDataDropdownFields;
import enums.elements.modules.ModuleDataFields;
import org.openqa.selenium.Keys;

public class ModuleCreatingPage extends BasePage {

    private static final String FILLING_CONTENT_DROPDOWN = "//span[contains(text(), 'Наповнення контенту')]";
    private static final String MODULES_ACTIVE_BUTTON = "//a[@href='#/content_manager/modules/index']";
    private static final String CREATE_MODULE_BUTTON = "//a[@class='btn btn-primary']";
    private static final String INPUT_DATA_FIELD = "//input[@placeholder='%s']";
    private static final String DROPDOWN_DATA_FIELD = "//span[text()='%s']";
    private static final String PRICE_FIELD = "//div[contains(text(),'Ціна')]//following::input[@class='cabinet-form-input']";
    private static final String SAVE_MODULE_BUTTON = "//button[@class='btn btn-success']";
    private static final String MODULE_NAME_FILTER = "//th[@class='filter-th'][2]//descendant::input";
    private static final String MODULE_NAME = "//a[contains(@title,'%s')]";
    private static final String DELETE_MODULE_BUTTON = "//tr[@class=' vgt-custom'][1]//i[@class ='fa fa-trash fa-fw']";
    private static final String ABSENCE_OF_MODULE_MESSAGE = "//div[contains(text(),'Дані відсутні')]";
    private static final String MODULE_BUTTON = "//a[@href='#/content_manager/modules']";

    public void clickFillingContentDropdownButton(){
        findElementByXPath(FILLING_CONTENT_DROPDOWN).click();
    }

    public void clickModulesActiveLink(){
        findElementByXPath(MODULES_ACTIVE_BUTTON).click();
    }

    public void clickCreateModuleButton(){
        findElementByXPath(CREATE_MODULE_BUTTON).click();
    }

    public void inputDataToEnumFields(ModuleDataFields fields, String data){
        findElementByXPath(String.format(INPUT_DATA_FIELD, fields.toString())).sendKeys(data);
    }

    public void clickDropdownButton(ModuleDataDropdownFields button){
        findElementByXPath(String.format(DROPDOWN_DATA_FIELD, button.toString())).click();
    }

    public void chooseDropdownItem(DataDropdownItems button){
        findElementByXPath(String.format(DROPDOWN_DATA_FIELD, button.toString())).click();
    }

    public void clearTextInField(){
        findElementByXPath(PRICE_FIELD).sendKeys(Keys.chord(Keys.COMMAND, "a"));
    }

    public void inputPrice(String data){
        findElementByXPath(PRICE_FIELD).sendKeys(data);
    }

    public void clickSaveModuleButton(){
        findElementByXPath(SAVE_MODULE_BUTTON).click();
    }

    public void inputDataToModuleNameFilter(String data){
        findElementByXPath(MODULE_NAME_FILTER).sendKeys(data);
    }

    public void isModuleNamePresent(String name){
        isElementPresent(String.format(MODULE_NAME, name));
    }

    public void clickModuleName(String name){
        findElementByXPath(String.format(MODULE_NAME, name)).click();
    }

    public void clearTextInNameField(ModuleDataFields fields){
        findElementByXPath(String.format(INPUT_DATA_FIELD, fields)).sendKeys(Keys.chord(Keys.COMMAND, "a"));
    }

    public void clickDeleteModuleButton(){
        findElementByXPath(DELETE_MODULE_BUTTON).click();
    }

    public void deleteModule(){
        getDriverThreadLocal().switchTo().alert().accept();
    }

    public Boolean absenceOfModuleMessageIsDisplayed(){
        return findElementByXPath(ABSENCE_OF_MODULE_MESSAGE).isDisplayed();
    }

    public void clickModuleButton(){
        findElementByXPath(MODULE_BUTTON).click();
    }
}
