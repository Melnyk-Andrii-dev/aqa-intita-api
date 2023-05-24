package pages;

import lombok.Getter;
import lombok.experimental.Accessors;


@Getter
@Accessors(fluent = true)
public class BasePage extends AbstractPage {

    @Getter
    @Accessors(fluent = true)
    protected HeaderComponent headerComponent = new HeaderComponent();
    protected DashboardSidebarComponent dashboardSidebarComponent = new DashboardSidebarComponent();
    protected DashboardHeaderComponent dashboardHeaderComponent = new DashboardHeaderComponent();

}
