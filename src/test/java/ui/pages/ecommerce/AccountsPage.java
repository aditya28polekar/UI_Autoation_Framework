package ui.pages.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;

public class AccountsPage extends BrowserUtility {
    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");

    public AccountsPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public String getUserName() {
        return getTextFromLocator(USER_NAME_LOCATOR);
    }

}
