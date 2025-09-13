package utility;

import constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerUtlity.getLogger(this.getClass());
    private Wait wait;

    protected BrowserUtility(WebDriver driver){
        logger.info("in BrowserUtility constructor setting driver");
        this.driver.set(driver);
        wait = new WebDriverWait(this.driver.get() , Duration.ofSeconds(30L));
    }

    protected BrowserUtility(Browser browserName, boolean isHeadless) {
        //logger.info("Launching Browser for " + browserName);

        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // headless
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                driver.set(new ChromeDriver());
                maximizeWindow();
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }
        }

        else if (browserName == Browser.EDGE) {
            System.setProperty("webdriver.edge.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\msedgedriver.exe");
            if (isHeadless) {

                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("disable-gpu");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }
            else {
                driver.set(new EdgeDriver());
                maximizeWindow();
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        }

    }

    protected void goToWebsite(String url){
        driver.get().get(url);
    }

    protected void maximizeWindow(){
        driver.get().manage().window().maximize();
    }

    protected WebDriver getDriver(){
        return driver.get();
    }

    protected void clickOn (By locator){
        WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected void enterText(By locator , String textToEnter){
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }
    public void enterSpecialKey(By locator, Keys keyToEnter) {
        //logger.info("Finding Element with the locator" + locator);

        WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        //logger.info("Element Found and now enter special Key " + keyToEnter);

        element.sendKeys(keyToEnter);
    }

    protected String getTextFromLocator(By locator){
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }
    public String getTextFromLocator(WebElement element) {

        //logger.info("Returning the visibile Text" + element.getText());

        return element.getText();
    }

    public List<String> getAllTextsFromLocator(By locator) {
        //logger.info("Finding All Elements with the locator" + locator);

        List<WebElement> elementList = driver.get().findElements(locator);
        //logger.info("Elements Found and now printing the List of Elements");
        List<String> visibleTextList = new ArrayList<String>();
        for (WebElement element : elementList) {
            System.out.println(getTextFromLocator(element));
            visibleTextList.add(getTextFromLocator(element));
        }

        return visibleTextList;

    }

    public List<WebElement> getAllElements(By locator) {
        //logger.info("Finding All Elements with the locator" + locator);

        List<WebElement> elementList = driver.get().findElements(locator);
        logger.info("Elements Found and now printing the List of Elements");

        return elementList;

    }

    public String takeScreenShot(String name){
        File screenShot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path;

        path = "./src/test/resources/screenshot/" + name + "-" + timeStamp + ".png";
        try {
            FileUtils.copyFile(screenShot , new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;


    }

    public void quit() {
        driver.get().quit();
    }

}
