package ui.tests.ecommerce;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pojo.ecommerce.User;

@Listeners({ui.listners.TestListener.class})
public class InvalidLoginTest extends BaseTest{
    private static final String INVALID_EMAIL = "aditya";
    private static final String INVALID_PASS = "polekar";

    @Test(description = "verify proper error message is shown if user enters invalid creds" , groups = {"e2e" , "sanity"})
    public void loginInvalid(){
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithInvalidCrreds(INVALID_EMAIL , INVALID_PASS).getErrorMessage() , "Invalid email address.");
    }

}
