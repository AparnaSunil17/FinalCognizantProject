//package factory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//public class BaseClass {
//	private WebDriver driver;
//	@Parameters({"browser"})
//    @BeforeClass
//		public void setup(String br) {
//		switch (br.toLowerCase()) {
//        case "chrome":
//            driver = new ChromeDriver();
//            break;
//        case "edge":
//        	//name and location
//            System.setProperty("webdriver.edge.driver","C:\\Users\\2401259\\Downloads\\edgedriver_win64\\msedgedriver.exe"
//                    );
//            driver = new EdgeDriver();
//            break;
//        default:
//            System.out.println("Invalid Browser");
//            return;
//    }
//}
//}
package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseClass {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver initializeDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\\\Users\\\\2401259\\\\Downloads\\\\edgedriver_win64\\\\msedgedriver.exe");
			driver.set(new EdgeDriver());
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		return getDriver();
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}
