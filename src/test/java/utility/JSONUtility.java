package utility;

import com.google.gson.Gson;
import constants.Env;
import ui.pojo.ecommerce.Config;
import ui.pojo.ecommerce.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {
    public static Environment readJSON(Env env) {

        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "//src//config//config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get("QA");

        return environment;
    }
}
