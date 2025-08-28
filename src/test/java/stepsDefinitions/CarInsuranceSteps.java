//
//package stepsDefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CarInsuranceSteps {
//
//    WebDriver driver;
//
//    @Given("User visits GoDigit's car insurance quote page")
//    public void visit_car_insurance_page() {
//        driver = new ChromeDriver();
//        driver.get("https://www.godigit.com/car-insurance");
//    }
//
//    @When("User proceeds without entering car number")
//    public void proceed_without_car_number() {
//        driver.findElement(By.id("skip-car-number")).click();
//    }
//
//    @And("Fills in other required details")
//    public void fill_other_details() {
//        driver.findElement(By.id("car-model")).sendKeys("Hyundai i20");
//        driver.findElement(By.id("car-year")).sendKeys("2022");
//    }
//
//    @And("Enters an invalid email or phone number")
//    public void enter_invalid_contact_info() {
//        driver.findElement(By.id("email")).sendKeys("invalid-email");
//        driver.findElement(By.id("phone")).sendKeys("123");
//        driver.findElement(By.id("submit")).click();
//    }
//
//    @Then("Capture and display the error message shown by the site")
//    public void capture_error_message() {
//        WebElement error = driver.findElement(By.cssSelector(".error-message"));
//        System.out.println("Error Message: " + error.getText());
//    }
//}
