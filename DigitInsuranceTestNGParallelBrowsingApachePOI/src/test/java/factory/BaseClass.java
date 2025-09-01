package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
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

	     static Properties p;
	     static Logger logger;
	     static ThreadLocal<WebDriver> driver =new ThreadLocal<>();

	  	     
	public static WebDriver initilizeBrowser( String browser) throws IOException
	{
		p = getProperties();
        String executionEnv = p.getProperty("execution_env");
        String os = p.getProperty("os").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			 switch (os) {
             case "windows":
                 capabilities.setPlatform(Platform.WINDOWS);
                 break;
             case "mac":
                 capabilities.setPlatform(Platform.MAC);
                 break;
             case "linux":
                 capabilities.setPlatform(Platform.LINUX);
                 break;
             default:
                 System.out.println("No matching OS");
                 return null;
            }
			
			//browser
			 switch (browser) {
             case "chrome":
                 capabilities.setBrowserName("chrome");
                 break;
             case "edge":
                 capabilities.setBrowserName("MicrosoftEdge");
                 break;
             case "firefox":
                 capabilities.setBrowserName("firefox");
                 break;
             default:
                 System.out.println("No matching browser");
                 return null;
             }
	       
	        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities));
			
		}
		else if(executionEnv.equalsIgnoreCase("local"))
			{
				switch(browser.toLowerCase()) 
				{
				case "chrome":
			        driver.set(new ChromeDriver());
			        break;
			    case "edge":
			    	driver.set(new EdgeDriver());
			        break;
			    case "firefox":
			    	driver.set(new FirefoxDriver());
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 getDriver().manage().deleteAllCookies(); 
		 getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		 return getDriver();
		 
	}
	
	public static WebDriver getDriver() {
			return driver.get();
		}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       	p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	

	
}
