package pages;

public class ProfilePage extends BasePage {

    private static final String EDIT_PROFILE_LINK = "//i[contains(@class, 'user-edit')]";

    private static final String NAME = "//div[@class='user-data']//h1[1]";
    private static final String SURNAME = "//div[@class='user-data']//h1[2]";
    private static final String NICKNAME = "//div[@class='user-data']//h1[3]";

    private static final String COUNTRY = "//div[@class='user-data']//div[@class='d-flex']//div[1]";

    // City not used due to city change functionality limitations (set up "...div[2/3/4]" for next 3 locators if uncomment)
    private static final String CITY = "//div[@class='user-data']//div[@class='d-flex']//div[2]";
    private static final String ADDRESS = "//div[@class='user-data']//div[@class='d-flex']//div[2]";
    private static final String AGE = "//div[@class='user-data']//div[@class='d-flex']//div[3]";

    private static final String EMAIL = "//div[@id='collapseUserData']//p[contains(text(), 'пошта') or contains(text(), 'почта') or contains(text(), 'Email')]";

    private static final String PROFILE_FIELDS = "//p[contains(text(), '%s')]//following-sibling::p";
    private static final String PHONE = "//div[@id='collapseUserData']//p[contains(text(), 'Телефон') or contains(text(), 'Phone')]//following-sibling::p[1]";
    private static final String EDUCATION = "//div[@id='collapseUserData']//p[contains(text(), 'Освіта') or contains(text(), 'Образование') or contains(text(), 'Education')]//following-sibling::p[1]";
    private static final String INTERESTS = "//div[@id='collapseUserData']//p[contains(text(), 'Інтереси') or contains(text(), 'Интересы') or contains(text(), 'Interests')]//following-sibling::p[1]";
    private static final String INFOSOURCE = "//div[@id='collapseUserData']//p[contains(text(), 'Звідки') or contains(text(), 'Откуда') or contains(text(), 'How')]//following-sibling::p[1]";
    private static final String ABOUTME = "//div[@id='collapseUserData']//p[contains(text(), 'Про себе') or contains(text(), 'О себе') or contains(text(), 'About')]//following-sibling::p[1]";
    private static final String SKYPE = "//div[@id='collapseUserData']//p[contains(text(), 'Skype')]//following-sibling::p[1]";
    private static final String PREVJOB = "//div[@id='collapseUserData']//div[8]//p[2]";
    private static final String CURRJOB = "//div[@id='collapseUserData']//div[9]//p[2]";
    private static final String EDUCFORM = "//div[@id='collapseUserData']//p[contains(text(), 'Форма') or contains(text(), 'Learning')]";

    private static final String FACEBOOK_LINK = "//div[@class='networks']//a[contains(text(), 'facebook')]";
    private static final String LINKEDIN_LINK = "//div[@class='networks']//a[contains(text(), 'linkedin')]";
    private static final String TWITTER_LINK = "//div[@class='networks']//a[contains(text(), 'twitter')]";

    private String textToTrim;

    public void clickEditProfile() {
        findElementByXPath(EDIT_PROFILE_LINK).click();
    }

    public String getFirstName() {
        return findElementByXPath(NAME).getText();
    }

    public String getLastName() {
        return findElementByXPath(SURNAME).getText();
    }

    public String getNickName() {
        return findElementByXPath(NICKNAME).getText();
    }

    public String getCountry() {
        textToTrim = findElementByXPath(COUNTRY).getText();
        return textToTrim.substring(0, (textToTrim.length() - 1));
    }

    // Not used due to city change functionality limitations (requires xPath change if uncomment)
    public String getCity() {
        textToTrim = findElementByXPath(CITY).getText();
        return textToTrim.substring(0, (textToTrim.length() - 1));
    }

    public String getAddress() {
        textToTrim = findElementByXPath(ADDRESS).getText();
        return textToTrim.substring(0, (textToTrim.length() - 1));
    }

    public String getAge() {
        return findElementByXPath(AGE).getText();
    }

    public String getEmail() {
        return findElementByXPath(EMAIL).getText();
    }

    public String getPhone() {
        return findElementByXPath(PHONE).getText();
    }

    public String getEducation() {
        return findElementByXPath(EDUCATION).getText();
    }

    public String getInterests() {
        return findElementByXPath(INTERESTS).getText();
    }

    public String getInfosource() {
        return findElementByXPath(INFOSOURCE).getText();
    }

    public String getAboutme() {
        return findElementByXPath(ABOUTME).getText();
    }

    public String getSkype() {
        return findElementByXPath(SKYPE).getText();
    }

    public String getPrevjob() {
        return findElementByXPath(PREVJOB).getText();
    }

    public String getCurrjob() {
        return findElementByXPath(CURRJOB).getText();
    }

    public String getEducform() {
        return findElementByXPath(EDUCFORM).getText();
    }

    public String getFacebookLink() {
        return findElementByXPath(FACEBOOK_LINK).getAttribute("href");
    }

    public String getLinkedinLink() {
        return findElementByXPath(LINKEDIN_LINK).getAttribute("href");
    }

    public String getTwitterLink() {
        return findElementByXPath(TWITTER_LINK).getAttribute("href");
    }

    public String getProfileFieldText(String field) {
        return findElementByXPath(String.format(PROFILE_FIELDS, field)).getText();
    }
}
