package ui.tests.ecommerce;

import jdk.dynalink.beans.StaticClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.ecommerce.AccountsPage;
import ui.pages.ecommerce.HomePage;

@Listeners({ui.listners.TestListener.class})
public class ProductSearchTest extends BaseTest{

    AccountsPage accountsPage;
    private static final String SEARCH_TERM = "Printed Summer Dress";

    @BeforeMethod(description = "Valid user logs into the application")
    public void setup(){
        accountsPage = homePage.goToLoginPage().doLoginWith("gojat62999@cronack.com" , "passpgpass");
    }
    @Test (description = "Verify if user is able to search products and correct serach results are displayed" , groups = {"e2e" , "sanity"})
    public void searchElementTest(){
        Assert.assertEquals(accountsPage.searchForProducts(SEARCH_TERM).isSearchTermPresent(SEARCH_TERM) , true);
    }
}
