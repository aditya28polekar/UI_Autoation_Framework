package ui.tests.ecommerce;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pojo.ecommerce.User;
import utility.CSVReaderUtility;
import utility.JSONUtility;

import java.util.Iterator;

import static constants.Env.QA;

public class Temp {

    @Test (retryAnalyzer = ui.listners.MyRetryAnalyzer.class)
    public void test1(){
        Assert.assertEquals("123" ,"345");
    }

    @Test (retryAnalyzer = ui.listners.MyRetryAnalyzer.class)
    public void test2(){
        Assert.assertEquals("123" ,"345");
    }
}
