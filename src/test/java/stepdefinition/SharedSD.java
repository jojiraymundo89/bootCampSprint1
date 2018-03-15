package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.ConfigReader;

public class SharedSD {


    public static void SauceLab() throws MalformedURLException {
          final String USERNAME = "jojiraymundo89";
          final String ACCESS_KEY = "db2fc13b-2c29-4d06-8f31-a50662baeca7";
          final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs" +
                ".com:443/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.13");
        caps.setCapability("version", "64.0");
        /*WebDriver*/ driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        //driver.get("https://amazon.com/");
    }
    private static WebDriver driver = null;
    @Before
    public static void before() throws MalformedURLException {

        ConfigReader configReader = new ConfigReader();

        String browser = configReader.getBrowser();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/joselitowilliamraymundo/Downloads/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/joselitowilliamraymundo/Downloads/geckodriver");
                driver = new FirefoxDriver();
                break;
                case "safari":
                driver = new SafariDriver();
            case"sauceLab":
                SauceLab();
                break;
            default:
                System.out.println("Browser not supported. Please select from 'chrome','firefox' or 'safari' only.");
        }
        //driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(configReader.getUrl());
    }

    @After
    public static void after() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
