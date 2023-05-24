package steps;

import cache.TestCache;
import cache.TestCacheKey;
import enums.elements.modules.DataDropdownItems;
import enums.elements.modules.ModuleDataDropdownFields;
import enums.elements.modules.ModuleDataFields;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import pages.ModuleCreatingPage;

public class ModuleCreatingStepdefs {

    private static final ModuleCreatingPage creatingModulePage = new ModuleCreatingPage();

    @When("I click filling content dropdown button")
    public void iClickFillingContentDropdownButton() {
        creatingModulePage.clickFillingContentDropdownButton();
    }

    @And("Click active button Modules")
    public void clickActiveButtonModules() {
        creatingModulePage.clickModulesActiveLink();
    }

    @When("I click button Create")
    public void iClickButtonCreate() {
        creatingModulePage.clickCreateModuleButton();
    }

    @And("I enter in the field {} data {string} on Creating Module Page")
    public void iEnterInTheFieldIDDataOnCreatingModulePage(ModuleDataFields fields, String moduleName) {
        String randomModuleName = moduleName+ RandomStringUtils.randomAlphanumeric(4);
        creatingModulePage.inputDataToEnumFields(fields, randomModuleName);
        TestCache.putDataInCache(TestCacheKey.MODULE_NAME, randomModuleName);
    }

    @And("I click in the enum dropdown field {}")
    public void iClickInTheEnumDropdownField(ModuleDataDropdownFields button) {
        creatingModulePage.clickDropdownButton(button);
    }

    @And("I choose enum dropdown item {} on Creating Module Page dropdown fields")
    public void iChooseEnumDropdownItemOnCreatingModulePageDropdownFields(DataDropdownItems button) {
        creatingModulePage.chooseDropdownItem(button);
    }

    @And("I delete the text from the field")
    public void iDeleteTheTextFromTheField() {
        creatingModulePage.clearTextInField();
    }

    @And("I enter the price {string}")
    public void iEnterThePrice(String data) {
        creatingModulePage.inputPrice(data);
    }

    @And("I click button Save")
    public void iClickButtonSave() {
        creatingModulePage.clickSaveModuleButton();
    }

    @And("I enter the module name in the field Name on the Modules Page")
    public void iEnterTheModuleNameInTheFieldNameOnTheModulesPage() {
        String randomModuleName = TestCache.getStringFromCache(TestCacheKey.MODULE_NAME);
        creatingModulePage.inputDataToModuleNameFilter(randomModuleName);
    }

    @Then("Module is displayed on the page AllModulesPage")
    public void moduleModuleIsDisplayedOnThePage() {
        String randomModuleName = TestCache.getStringFromCache(TestCacheKey.MODULE_NAME);
        creatingModulePage.isModuleNamePresent(randomModuleName);
    }

    @And("I click the current module")
    public void iClickTheModuleModule() {
        String randomModuleName = TestCache.getStringFromCache(TestCacheKey.MODULE_NAME);
        creatingModulePage.clickModuleName(randomModuleName);
    }

    @And("I click delete the module button")
    public void iClickDeleteTheModuleButton() {
        creatingModulePage.clickDeleteModuleButton();
        creatingModulePage.deleteModule();
    }

    @Then("message of absence data is visible {}")
    public void messageOfAbsenceDataIsVisible(boolean isDisplayed) {
        Assertions.assertThat(creatingModulePage.absenceOfModuleMessageIsDisplayed()).isEqualTo(isDisplayed);
    }

    @And("I delete the text from the field {}")
    public void iDeleteTheTextFromTheFieldNAME(ModuleDataFields fields) {
        creatingModulePage.clearTextInNameField(fields);
    }

    @And("I enter in the enum field {} data {string} on Creating Module Page")
    public void iEnterInTheEnumFieldIDDataOnCreatingModulePage(ModuleDataFields fields, String value) {
        creatingModulePage.inputDataToEnumFields(fields, value);
    }

    @And("I click Module button")
    public void iClickModuleButton() {
        creatingModulePage.clickModuleButton();
    }
}
