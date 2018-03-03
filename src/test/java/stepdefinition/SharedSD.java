package stepdefinition;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.ConfigReader;

import java.net.MalformedURLException;

import static framework.BasePage.asynchronusScript;
import static framework.BasePage.pageLoadingWait;

public class SharedSD {

    private static WebDriver driver = null;

    @Before
 public static void before() throws MalformedURLException {

        ConfigReader configReader = new ConfigReader();

        String browser = System.getProperty("BROWSER");
        if(browser==null)
       {
            browser = System.getenv("BROWSER");
            if(browser==null)
            {
                browser= "chrome";
           }
        }
        switch (browser)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", configReader.getFirefoxDriverPath());
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
                break;
        }
        driver.manage().window().maximize();
        pageLoadingWait(10);
        asynchronusScript(10);
        driver.get(configReader.getUrl());

    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @After
    public void actionsAfterScenario(Scenario scenario){
        //Verifies if the scenario fails and make a screenshot
        if (scenario.isFailed()) {
            //Takes screenshot to cucumber report
            saveScreenshot(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        }
        driver.quit();
    }

//    @After
//    public void actionsAfterScenario(Scenario scenario){
//        //Verifies if the scenario fails and make a screenshot
//        if (scenario.isFailed()) {
//            //Takes screenshot to cucumber report
//            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }

    public static WebDriver getDriver() {
        return driver;
    }
}

