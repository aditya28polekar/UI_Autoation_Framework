package ui.pages.ecommerce;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;
import utility.LoggerUtlity;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {
    Logger logger = LoggerUtlity.getLogger(this.getClass());
    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
    private static final By ALL_PRODUCTS_LOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a[contains(@class,'product-name')]");
    SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getSearchTitle(){
        return getTextFromLocator(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresent(String SearchKey){
        logger.info("validating search results");
        //String SearchKey = getSearchTitle();
        List<String> keywords = Arrays.asList(SearchKey.split(" "));
        List<String> productList = getAllTextsFromLocator(ALL_PRODUCTS_LOCATOR);

        //AllMatch - Only return true if every product in productList contains at least one keyword
        boolean result = productList.stream()
                .allMatch(product->
                        //Does this product contain any of the keywords?
                        (keywords.stream().anyMatch(keyword -> product.toLowerCase().contains(keyword.toLowerCase())))
                );


        if(result) logger.info("search result is validated and its correct");
        else logger.info("search result is validated and its not correct");

        return result;
    }
}
