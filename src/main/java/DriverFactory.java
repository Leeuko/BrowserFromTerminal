import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverFactory {

    public static WebDriver create (BrowserType browserType, ArrayList<String>... listOptions){

        switch(browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions()
                        .addArguments(Arrays.toString(listOptions));
                return new FirefoxDriver(options);
            default:
                throw new IllegalArgumentException("Configuration for browser " + browserType + " has not been created");
        }
    }

}