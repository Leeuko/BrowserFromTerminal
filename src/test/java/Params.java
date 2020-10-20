import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Params {

    private WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private Logger logger = LogManager.getLogger(Params.class);

    @BeforeTest
    @Parameters("browser")
    public void Params(String browser) {
        browser = browser.toLowerCase();
        switch (browser) {
            case "firefox":
                driver = DriverFactory.getDriver(BrowserType.FIREFOX);
                driver.get(cfg.url());
                break;
            case "chrome":
                driver = DriverFactory.getDriver(BrowserType.CHROME);
                driver.get(cfg.url());
                break;
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