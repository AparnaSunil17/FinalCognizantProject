//
//package factory;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
// 
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
// 
//public class Demo {
// 
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.godigit.com/");
//        driver.findElement(By.xpath("//a[normalize-space()='Travel']//div[@class='qf-switcher-img-holder']")).click();
//        driver.findElement(By.id("France")).click();
//
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;  
//        //select date
//        String 	startMonth = "September";
//        String startYear = "2025";
//        String 	endMonth = "December";
//        String endYear = "2025";
//        String startDay = "26";
//        String endDay = "12";
//        driver.findElement(By.xpath("//input[@id='departure-date']")).click();
//        WebElement monthDropdown1 = driver.findElement(By.xpath("//select[@class='pika-select pika-select-month']"));
//        Select select = new Select(monthDropdown1);
//        select.selectByVisibleText(startMonth);
//        WebElement yearDropdown1 = driver.findElement(By.xpath("//select[@class='pika-select pika-select-year']"));
//        select = new Select(yearDropdown1);
//        select.selectByVisibleText(startYear);
//        driver.findElement(By.xpath("//tbody/tr/td[@data-day='"+startDay+"']")).click();
//        WebElement returndropdown = driver.findElement(By.xpath("//input[@id='return-date']"));
//        js.executeScript("arguments[0].click()", returndropdown);
//        List<WebElement> monthDropdown2 = driver.findElements(By.xpath("//select[@class='pika-select pika-select-month']"));
//        select = new Select(monthDropdown2.get(1));
//        select.selectByVisibleText(endMonth);
//        List<WebElement> yearDropdown2 = driver.findElements(By.xpath("//select[@class='pika-select pika-select-year']"));
//        select = new Select(yearDropdown2.get(1));
//        select.selectByVisibleText(endYear);
//        //driver.findElement(By.xpath("//tbody[2]/tr/td[@data-day='"+endDay+"']")).click();
//        List<WebElement> returnDay = driver.findElements(By.xpath("//tbody/tr/td[@data-day='"+endDay+"']"));
//        //js.executeScript("arguments[0].click()", returnDay.get(0));
//        returnDay.get(1).click();
// 
//        driver.findElement(By.id("insurance-getquote")).click();
//        driver.findElement(By.xpath("//input[@id='travellers']")).sendKeys("10/04/2000");//input[@id='travellers']
//        driver.findElement(By.id("add-traveller")).click();
//        driver.findElement(By.xpath("//input-field[@id='traveller2']//input[@id='travellers']")).sendKeys("19/04/2001");
//        WebElement submitbtn = driver.findElement(By.xpath("//button[normalize-space()='View Prices']"));
//        js.executeScript("arguments[0].click()", submitbtn);
//
//        //PLANS
//        List<WebElement> plans = driver.findElements(By.xpath(
//        	    "//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"
//        	));
// 
//        Map<String,String> planPriceMap = new HashMap<>();
//        for(WebElement plan : plans)
//        {
//        	String name = plan.findElement(By.tagName("h2")).getText();
//        	String price = plan.findElement(By.xpath(".//p[@class='notranslate ng-tns-c111-16']")).getText();
//        	planPriceMap.put(name, price);
//        }
//        for (Map.Entry<String, String> entry : planPriceMap.entrySet()) {
//            System.out.println("Plan: " + entry.getKey() + ", Price: " + entry.getValue());
//        }
//       // driver.quit();
//	}
// 
//}