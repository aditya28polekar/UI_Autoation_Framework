package ui.tests.ecommerce;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pojo.ecommerce.User;


@Listeners({ui.listners.TestListener.class})
public class LoginTest extends BaseTest{

    @Test (description = "verfify login of users" , groups = {"e2e" , "sanity"} , dataProviderClass = ui.dataproviders.ecommerce.LoginDataProvider.class,
    dataProvider = "LoginTestDataProvider" , retryAnalyzer = ui.listners.MyRetryAnalyzer.class)
    public void login(User user){
        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress() , user.getPassword()).getUserName() , "Adi boss");
    }

//    @Test (description = "verfify login of users" , groups = {"e2e" , "sanity"} , dataProviderClass = ui.dataproviders.ecommerce.LoginDataProvider.class,
//            dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = ui.listners.MyRetryAnalyzer.class)
//    public void login_csv(User user){
//        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress() , user.getPassword()).getUserName() , "Adi boss");
//    }
//
//    @Test (description = "verfify login of users" , groups = {"e2e" , "sanity"} , dataProviderClass = ui.dataproviders.ecommerce.LoginDataProvider.class,
//            dataProvider = "LoginTestExcelDataProvider" , retryAnalyzer = ui.listners.MyRetryAnalyzer.class)
//    public void login_xlsx(User user){
//        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress() , user.getPassword()).getUserName() , "Jatin Sharma");
//    }
}
