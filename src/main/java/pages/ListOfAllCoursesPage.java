package pages;

public class ListOfAllCoursesPage extends BasePage {

    private static final String FIND_COURSE_BY_NICKNAME_FIELD = "//th[@class='filter-th'][2]//descendant::input";
    private static final String COURSE_NICKNAME_FIELD = "//span[contains(text(),'%s')]";
    private static final String CREATE_COURSE_BUTTON = "//a[@class='btn btn-primary']";
    private static final String DELETE_COURSE_BUTTON = "//tr[@class=' vgt-custom'][1]//i[@class ='fa fa-trash fa-fw']";

    public void inputDataInTheFindCourseByNicknameField(String data){
        findElementByXPath(FIND_COURSE_BY_NICKNAME_FIELD).sendKeys(data);
    }

    public void isCourseNicknamePresent(String name){
        isElementPresent(String.format(COURSE_NICKNAME_FIELD, name));
    }

    public void clickCreateCourseButton(){
        findElementByXPath(CREATE_COURSE_BUTTON).click();
    }

    public void clickDeleteCourseButton(){
        findElementByXPath(DELETE_COURSE_BUTTON).click();
    }
    public void deleteCourse(){
        getDriverThreadLocal().switchTo().alert().accept();
    }
}
