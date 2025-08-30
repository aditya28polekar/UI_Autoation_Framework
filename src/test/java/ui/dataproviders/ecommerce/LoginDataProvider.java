package ui.dataproviders.ecommerce;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import ui.pojo.ecommerce.LoginData;
import ui.pojo.ecommerce.User;
import utility.CSVReaderUtility;
import utility.ExcelReaderUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "//src//test//testdata//ecommerce//logindata.json");
        FileReader fileReader = new FileReader(testDataFile);
        LoginData data = gson.fromJson(fileReader, LoginData.class);// deserialization

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for (User user : data.getData()) {

            dataToReturn.add(new Object[] { user });
        }

        return dataToReturn.iterator();

    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<Object[]> loginCSVDataProvider() {
        Iterator<User> itr = CSVReaderUtility.readCSVFile("loginData.csv");
        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        while(itr.hasNext()) {
            User user = itr.next();
            dataToReturn.add(new Object[] { user });
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<Object[]> loginExcelDataProvider() {
        Iterator<User> itr = ExcelReaderUtility.readExcelFile("LoginData.xlsx");
        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        while(itr.hasNext()) {
            User user = itr.next();
            dataToReturn.add(new Object[] { user });
        }
        return dataToReturn.iterator();
    }
}
