import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final BrowserType CHROME = BrowserType.CHROME;
    private static final BrowserType FIREFOX = BrowserType.FIREFOX;


    public static WebDriver getDriver(BrowserType browserType){
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
}