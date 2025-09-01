//package hooks;
//
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import factory.BaseClass;
//import io.cucumber.java.*;
//
//public class Hooks {
//
//    public static WebDriver driver;
//    Properties p;
//
//    @Before
//    public void setup() throws IOException {
//        driver = BaseClass.initilizeBrowser();
//        p = BaseClass.getProperties();
//        driver.get(p.getProperty("appURL"));
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//    }
//}
package hooks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testRunner.TestRun;
import utilities.ExcelWrite;

public class Hooks {

    private static ThreadLocal<String> sheetName = new ThreadLocal<>();
    public static WebDriver driver;
    Properties p;

    @Before
    public void setup(Scenario scenario) throws IOException {
        if (sheetName.get() == null) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            sheetName.set("TestRun_" + timeStamp);
            System.out.println("Excel sheet name set for this thread: " + sheetName.get());
        }

        String browser = TestRun.getBrowserName();
        if (browser != null) {
            scenario.attach(("Browser: " + browser).getBytes(), "text/plain", "Browser Info");
        }

        System.out.println("Setting up driver for browser: " + browser + " in thread: " + Thread.currentThread().getId());

        if (BaseClass.getDriver() == null) {
            BaseClass.initializeDriver(browser);
        }

        driver = BaseClass.getDriver();
        p = BaseClass.getProperties();

        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public void teardown(Scenario scenario) {
        String browser = TestRun.getBrowserName();
        String scenarioName = scenario.getName();
        String scenarioStatus = scenario.getStatus().toString();
        String resultMessage = scenarioName + " - " + scenarioStatus;
        String fileName = "ScenarioResults_" + browser.replace("\"", "").trim() + ".xlsx";

        System.out.println("Logging result: " + resultMessage + " to file: " + fileName);
        ExcelWrite.writeMessage(resultMessage, fileName, sheetName.get());

        BaseClass.quitDriver();
    }
}
