//
//package stepsDefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.*;
//
//public class HealthInsuranceSteps {
//
//    WebDriver driver;
//    List<String> healthMenuItems = new ArrayList<>();
//
//    @Given("User navigates to GoDigit's health insurance section")
//    public void navigate_to_health_insurance() {
//        driver = new ChromeDriver();
//        driver.get("https://www.godigit.com/health-insurance");
//    }
//
//    @When("User accesses the health insurance menu")
//    public void access_health_menu() {
//        List<WebElement> menuItems = driver.findElements(By.cssSelector(".health-menu-item"));
//        for (WebElement item : menuItems) {
//            healthMenuItems.add(item.getText());
//        }
//    }
//
//    @Then("Store all menu items in a list")
//    public void store_menu_items() {
//        // Already stored
//    }
//
//    @And("Display the list of health insurance menu items")
//    public void display_menu_items() {
//        System.out.println("Health Insurance Menu Items:");
//        for (String item : healthMenuItems) {
//            System.out.println("- " + item);
//        }
//    }
//}
