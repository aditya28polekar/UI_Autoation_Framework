package ui.pages.ecommerce;


import constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;
import utility.JSONUtility;

import static constants.Env.QA;

public class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

    public HomePage(Browser browser, boolean isHeadless) {
        super(browser, isHeadless);
        // To Call the Parent Class constructor from the child constructor
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver); // To Call the Parent Class constructor from the child constructor
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage() { // Page Functions------> cannot use void!!!
        //logger.info("Trying to performing click to go to Sign in Page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}
