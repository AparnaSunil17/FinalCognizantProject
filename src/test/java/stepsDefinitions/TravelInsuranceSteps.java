
package stepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import pageObjects.TravelPage;
public class TravelInsuranceSteps {

    WebDriver driver;
    TravelPage travelPage;
    @Given("Two students aged 21 and 22 want to study in a European country")
    public void students_want_travel_insurance() {
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://www.godigit.com/");
    	travelPage=new TravelPage(driver);
    }
    
    @When("They visit GoDigit's student travel insurance page")
    public void visit_student_travel_page() {
    	travelPage.navigateToTravelInsurance();
    }
    
    @And("Fill in dummy travel details for both students")
    public void fill_dummy_travel_details() {
    	travelPage.selectTravelDates("September", "2025", "26", "December", "2025", "12");
    	travelPage.enterTravellerDOBs("10/04/2000", "19/04/2001");
    	travelPage.clickViewPrices();
    }
    @Then("Display three lowest international student travel insurance plans with amount and provider name")
    public void display_lowest_travel_plans() {
    	 List<WebElement> plans=travelPage.getTopPlans();
    	        for (WebElement plan:plans) {
    	            String name=plan.findElement(By.tagName("h2")).getText();
    	            String price=plan.findElement(By.xpath(".//p[contains(@class,'notranslate')]")).getText();
    	            System.out.println("Plan: " +name+ ", Price: "+price);
    	        }

    }
//    @Given("Two students aged 21 and 22 want to study in a European country")
//    public void students_want_travel_insurance() {
//        driver = new ChromeDriver();
//        driver.get("https://www.godigit.com/international-travel-insurance");
//        driver.manage().window().maximize();
//    }
//
//    @When("They visit GoDigit's student travel insurance page")
//    public void visit_student_travel_page() {
//        // Already navigated
//    }
//
//    @And("Fill in dummy travel details for both students")
//    public void fill_dummy_travel_details() {
//        // Replace with actual selectors
//        driver.findElement(By.id("destination")).sendKeys("Germany");
//        driver.findElement(By.id("traveller1-age")).sendKeys("22");
//        driver.findElement(By.id("traveller2-age")).sendKeys("21");
//        driver.findElement(By.id("start-date")).sendKeys("01/09/2025");
//        driver.findElement(By.id("end-date")).sendKeys("30/09/2025");
//        driver.findElement(By.id("submit-button")).click();
//    }
//
//    @Then("Display three lowest international student travel insurance plans with amount and provider name")
//    public void display_lowest_travel_plans() {
//        List<WebElement> plans = driver.findElements(By.cssSelector(".plan-card"));
//        for (int i = 0; i < Math.min(3, plans.size()); i++) {
//            String provider = plans.get(i).findElement(By.cssSelector(".provider-name")).getText();
//            String price = plans.get(i).findElement(By.cssSelector(".plan-price")).getText();
//            System.out.println("Plan " + (i + 1) + ": " + provider + " - " + price);
//        }
//    }
}
