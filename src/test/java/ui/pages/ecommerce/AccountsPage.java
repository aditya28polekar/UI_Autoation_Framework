package ui.pages.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;

public class AccountsPage extends BrowserUtility {
    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
    private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");

    public AccountsPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public String getUserName() {
        return getTextFromLocator(USER_NAME_LOCATOR);
    }
    
    public SearchResultPage searchForProducts(String itemToSearch){
        enterText(SEARCH_TEXT_BOX_LOCATOR , itemToSearch);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR , Keys.ENTER);
        return new SearchResultPage(getDriver());
    } 



}
