//
//package testRunner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = ".\\features",                      // Path to your .feature files
//    glue = "stepsDefinitions",                   // Package containing all step definition classes
//    plugin = {
//        "pretty",                               // Console output
//        "html:target/cucumber-report.html",     // HTML report
//        //"json:target/cucumber-report.json"      // JSON report (optional for integrations)
//    },
//    publish = true                              // Enables publishing to reports.cucumber.io
//)
//public class TestRun extends AbstractTestNGCucumberTests {
//}

package testRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
    features = ".//features",
    glue = {"stepsDefinitions", "Hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)
public class TestRun extends AbstractTestNGCucumberTests {
   private static ThreadLocal<String> browserName = new ThreadLocal<>();
    @Parameters("browser")
    @BeforeClass
    public void setBrowser(@Optional("chrome")String browser) {
        browserName.set(browser);
    }
    public static String getBrowserName() {
        return browserName.get();
    }
}
 

