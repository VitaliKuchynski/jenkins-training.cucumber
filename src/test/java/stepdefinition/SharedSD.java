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
import util.ConfigDrivers;
import util.ConfigReader;
import util.ConfigSaucelabs;

import java.net.MalformedURLException;

import static framework.BasePage.asynchronusScript;
import static framework.BasePage.pageLoadingWait;

public class SharedSD {

    private static WebDriver driver = null;

    @Before
 public static void before() throws MalformedURLException {
        //Instance of config reader
        ConfigReader configReader = new ConfigReader();
        //Instance of config driver
        ConfigDrivers configDrivers = new ConfigDrivers(configReader.getBrowser());
        String environment = configReader.getEnvironment();

        switch(environment)
        {
            case "local":
                driver = configDrivers.setBrowser();
                break;
            case "sauselabs":
                ConfigSaucelabs configSaucelabs = new ConfigSaucelabs();
                driver = configSaucelabs.setSaucelabsDriver();
                break;
            default:
                driver = configDrivers.setBrowser();
                break;
        }
        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
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

