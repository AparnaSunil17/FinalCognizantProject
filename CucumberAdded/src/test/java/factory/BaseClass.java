
package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties p;
    private static Logger logger;

    public static WebDriver initializeDriver(String browser) throws IOException {
        p = getProperties();
        String executionEnv = p.getProperty("execution_env");
        String os = p.getProperty("os");

        if (executionEnv.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (os.toLowerCase()) {
                case "windows": capabilities.setPlatform(Platform.WINDOWS); break;
                case "mac": capabilities.setPlatform(Platform.MAC); break;
                case "linux": capabilities.setPlatform(Platform.LINUX); break;
                default: throw new RuntimeException("Unsupported OS: " + os);
            }

            switch (browser.toLowerCase()) {
                case "chrome": capabilities.setBrowserName("chrome"); break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox": capabilities.setBrowserName("firefox"); break;
                default: throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));

        } else {
            switch (browser.toLowerCase()) {
                case "chrome": driver.set(new ChromeDriver()); break;
                case "edge": driver.set(new EdgeDriver()); break;
                case "firefox": driver.set(new FirefoxDriver()); break;
                default: throw new RuntimeException("Unsupported browser: " + browser);
            }
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(p.getProperty("implicitWait", "10"))));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(p.getProperty("pageLoadTimeout", "20"))));

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public static Properties getProperties() throws IOException {
        if (p == null) {
            FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            p = new Properties();
            p.load(file);
        }
        return p;
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getLogger();
        }
        return logger;
    }
}
