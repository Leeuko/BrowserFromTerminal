import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;

public class DriverFactory {

    public static WebDriver create (BrowserType browserType){

        switch(browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Configuration for browser " + browserType + " has not been created");
        }
    }

    public static WebDriver create (BrowserType browserType, ArrayList<String> listOptions){

        switch(browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options1 = new ChromeOptions()
                        .addArguments(listOptions);
                return new ChromeDriver(options1);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options2 = new FirefoxOptions()
                        .addArguments(listOptions)
                        .addPreference("browser.startup.page", 1);
                return new FirefoxDriver(options2);
            default:
                throw new IllegalArgumentException("Configuration for browser " + browserType + " has not been created");
        }
    }

}