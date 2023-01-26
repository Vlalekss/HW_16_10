package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {

    public static final boolean JENKINS = true;

    public static void configDriver(){
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        Configuration.holdBrowserOpen = true;

        if(JENKINS) {
            Configuration.timeout = 10000;
            Configuration.remote = System.getProperty("selenoidURL", "https://user1:1234@selenoid.autotests.cloud") + "/wd/hub";


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
