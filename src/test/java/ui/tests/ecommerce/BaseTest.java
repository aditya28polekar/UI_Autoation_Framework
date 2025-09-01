package ui.tests.ecommerce;

import constants.Browser;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ui.pages.ecommerce.HomePage;
import utility.BrowserUtility;
import utility.LambdaTestUtility;
import utility.LoggerUtlity;




public class BaseTest {
    Logger logger = LoggerUtlity.getLogger(this.getClass());
    protected HomePage homePage;
    private boolean isLambdaTest;


    @BeforeMethod
    @Parameters({ "browser", "isLambdaTest", "isHeadless" })
    public void setup(String browser , boolean isLambdaTest , boolean isHeadless , ITestResult result) {
        WebDriver lambdaDriver;
        this.isLambdaTest = isLambdaTest;


        if (isLambdaTest) {
            logger.info("starting initializeLambdaTestSession isLambdaTest true");
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
            logger.info("executed initializeLambdaTestSession isLambdaTest true now going to homepage");
            homePage = new HomePage(lambdaDriver);

        }
        else {
            homePage = new HomePage(Browser.valueOf("chrome".toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
        if(isLambdaTest) LambdaTestUtility.quitSession();
        else homePage.quit();
    }
}
