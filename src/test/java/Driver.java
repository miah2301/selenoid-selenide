import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void initDriver(){
        Configuration.remote = "http://212.193.51.177:4444/wd/hub";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Configuration.pageLoadStrategy = "eager";

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);

        ChromeOptions capabilities = new ChromeOptions();
        capabilities.setBrowserVersion("109.0");
        Configuration.browserCapabilities = capabilities;
        Configuration.browserCapabilities.setCapability("selenoid:options", options);
    }
}
