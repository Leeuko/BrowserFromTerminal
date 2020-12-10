import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class ParamsTest {

    private WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private Logger logger = LogManager.getLogger(ParamsTest.class);
    ArrayList<String> list2 = new ArrayList<>(Arrays.asList("browser.startup.homepage", "https://www.google.co.uk"));

    @BeforeTest
    @Parameters("browser")
    public void Params(@Optional("firefox") String browser) {
        browser = browser.toLowerCase();
        switch (browser) {
            case "firefox":
                driver = DriverFactory.create(BrowserType.FIREFOX,list2);
                driver.get(cfg.url());
                break;
            case "chrome":
                driver = DriverFactory.create(BrowserType.CHROME);
                driver.get(cfg.url());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        logger.info("Driver is up");
    }

    @Test
    public void openPage() {
        logger.info("Page otus.ru is opened");
    }

    @After
    public  void setDown(){
        if(driver != null){
            driver.quit();
        }
    }

}