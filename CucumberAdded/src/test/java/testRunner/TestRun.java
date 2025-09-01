//
//package testRunner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = {".//Features/"},
//    glue = {"stepDefinitions", "hooks"},
//    plugin = {
//        "pretty", 
//        "html:reports/myreport.html",   
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "rerun:target/rerun.txt"
//    },
//    dryRun = false,
//    monochrome = true,
//    publish = true
//    // tags = "@sanity" // Uncomment as needed
//)
//public class TestRun extends AbstractTestNGCucumberTests {
//}
//
package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {".//Features/"},
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty", 
        "html:reports/myreport.html",   
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/rerun.txt"
    },
    dryRun = false,
    monochrome = true,
    publish = true
    // tags = "@sanity" // Uncomment as needed
)
public class TestRun extends AbstractTestNGCucumberTests {

    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setBrowser(@Optional("chrome") String browser) {
        browserName.set(browser.replace("\"", "").trim());
        System.out.println("Browser set for thread " + Thread.currentThread().getId() + ": " + browserName.get());
    }

    public static String getBrowserName() {
        return browserName.get();
    }
}
