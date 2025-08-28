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
package stepsDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HealthPage;
import factory.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class HealthInsuranceSteps {

    WebDriver driver;
    HealthPage healthPage;
    List<String> healthMenuItems = new ArrayList<>();

    @Given("User navigates to GoDigit's health insurance section")
    public void navigate_to_health_insurance() {
        driver = BaseClass.getDriver();
        healthPage = new HealthPage(driver);
        healthPage.openHealthSection();
        healthPage.enterPincode("600001");
        healthPage.enterMobileNumber("9999999999");
        healthPage.clickViewPrices();
        healthPage.clickHealthInsurancePolicy();
    }

    @When("User accesses the health insurance menu")
    public void access_health_menu() {
        for (WebElement item : healthPage.getFamilyMenuItems()) {
            healthMenuItems.add(item.getText());
        }
        for (WebElement item : healthPage.getParentMenuItems()) {
            healthMenuItems.add(item.getText());
        }
    }

    @Then("Store all menu items in a list")
    public void store_menu_items() {
        // Already stored in healthMenuItems list
    }

    @And("Display the list of health insurance menu items")
    public void display_menu_items() {
        System.out.println("Health Insurance Menu Items:");
        for (String item : healthMenuItems) {
            System.out.println("- " + item);
        }
    }
}
