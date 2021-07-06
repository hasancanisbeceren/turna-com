package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    protected String baseURL = "https://www.turna.com/";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    ChromeOptions options = new ChromeOptions();
    public static String Path = "drivers/chromedriver";

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        options.setExperimentalOption("w3c",false);
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver,45,150);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    /*@AfterAll
    public void close(){
        driver.quit();
    }*/
}
