package stepsDefinitions;
//
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//
//import com.aventstack.extentreports.gherkin.model.Scenario;
//
//import factory.BaseClass;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//	WebDriver driver;
//	Properties p;
//	
//	@Before
//	public void setup() throws IOException{
//		driver=BaseClass.initialiseBrowser();
//		p=
//		driver.get(p.getProperty("https://www.godigit.com/"));
//		driver.manage().window().maximize();
//	}
//	
//	@After
//	public void tearDown(Scenario scenario) {
//		driver.quit();
//	}	
//}
import factory.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import testRunner.TestRun;
public class Hooks {
    WebDriver driver;
//    @Before
//    public void setUp() {
//        String browser = TestRun.getBrowserName();
//        if (browser == null) {
//            // Default to chrome if the parameter is not set
//            browser = "chrome";
//        }
//        System.out.println("Launching browser: " + browser);
//        driver = BaseClass.initializeDriver(browser);
//    }
//    @After
//    public void tearDown() {
//        BaseClass.quitDriver();
//    }
    @Before
    public void setUp() {
        String browser = TestRun.getBrowserName(); // from testng.xml
        BaseClass.initializeDriver(browser);       // creates browser
        BaseClass.getDriver().get("https://www.godigit.com/"); // opens site
    }

    @After
    public void tearDown() {
        BaseClass.quitDriver(); // closes browser
    }

}