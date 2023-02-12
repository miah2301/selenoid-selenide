package org.selenide.examples.selenoid;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SelenoidExtension implements BeforeAllCallback  {
  @Override
  public void beforeAll(ExtensionContext context) {
    Configuration.remote = "http://localhost:4444/wd/hub";
    Configuration.reportsFolder = "target/surefire-reports";
    Configuration.downloadsFolder = "target/downloads";

    ChromeOptions options = new ChromeOptions();

    options.setCapability("selenoid:options", new HashMap<String, Object>() {{
      /* How to add test badge */
      put("name", "Test badge...");

      /* How to set session timeout */
      put("sessionTimeout", "15m");

      /* How to set timezone */
      put("env", new ArrayList<String>() {{
        add("TZ=UTC");
      }});

      /* How to add "trash" button */
      put("labels", new HashMap<String, Object>() {{
        put("manual", "true");
      }});

      /* How to enable video recording */
      put("enableVideo", true);
    }});

    /*Map<String, Boolean> options = new HashMap<>();
    options.put("enableVNC", true);
    options.put("enableVideo", true);
    options.put("enableLog", true);

    ChromeOptions capabilities = new ChromeOptions();
    capabilities.setBrowserVersion("109.0");
    Configuration.browserCapabilities = capabilities;
    Configuration.browserCapabilities.setCapability("selenoid:options", options);*/
  }
}
