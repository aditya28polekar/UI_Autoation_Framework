package ui.pages.ecommerce;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;
import utility.LoggerUtlity;

public class LoginPage extends BrowserUtility{

    Logger logger = LoggerUtlity.getLogger(this.getClass());

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

    public LoginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public AccountsPage doLoginWith(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_BUTTON_LOCATOR);
        AccountsPage myAccountPage = new AccountsPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCrreds(String emailAddress , String password){
        logger.info("logging in with invalid creds");
        enterText(EMAIL_TEXT_BOX_LOCATOR , emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR , password);
        logger.info("Clicking on login");
        clickOn(SUBMIT_BUTTON_LOCATOR);
        return  new LoginPage(getDriver());
    }

    public String getErrorMessage(){
        return getTextFromLocator(ERROR_MESSAGE_LOCATOR);
    }
}
