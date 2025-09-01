package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
					//features= {".//Features/"},
					features= {".//FeaturesDDT/commercialInsurance.feature"},
					//features= {".//Features/commercialInsurance.feature"},
					//features= {".//Features/travelInsurance.feature"},
					//features= {".//Features/healthInsurance.feature"},
					//features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"},
					//glue={"stepDefinitions","Hooks"},
					glue={"stepDefinitionsDDT","Hooks"},
					plugin= {
								"pretty", "html:reports/myreport.html",   
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:target/rerun.txt",
							
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
	public class TestRunner extends AbstractTestNGCucumberTests{
	
//	@Parameters("browser")
//	@BeforeClass
//	public void setupBrowserParam(String browser, ITestContext context) {
//	    System.setProperty("browser", browser); // ✅ Pass browser to system property
//	}
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


