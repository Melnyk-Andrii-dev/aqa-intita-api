package pages;

public class DashboardHeaderComponent extends AbstractPage{

    private static final String BREADCRUMB_FIELD = "//li[@class='breadcrumb-item']//descendant::span";


    public String getBreadcrumbFieldText(){
        return findElementByXPath(BREADCRUMB_FIELD).getText();
    }
}
