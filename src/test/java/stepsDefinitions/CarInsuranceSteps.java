//
//package stepsDefinitions;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.cucumber.java.en.*;
//import pageObjects.CarPage;
//
//public class CarInsuranceSteps {
//    WebDriver driver;
//    CarPage carPage;
//
//    @Given("User visits GoDigit's car insurance quote page")
//    public void user_visits_godigit_car_insurance_quote_page() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.godigit.com/");
//        carPage = new CarPage(driver);
//    }
//
//    @When("User proceeds without entering car number")
//    public void user_proceeds_without_entering_car_number() {
//        carPage.clickCommercialInsurance();
//        carPage.clickViewPrice();
//    }
//
//    @And("Fills in other required details")
//    public void fills_in_other_required_details() {
//        carPage.enterRegistrationNumber("KA04DK1234");
//    }
//
//    @And("Enters an invalid email or phone number")
//    public void enters_invalid_email_or_phone_number() {
//        carPage.enterMobileNumber("12345");
//        carPage.clickViewPrice();
//    }
//
//    @Then("Capture and display the error message shown by the site")
//    public void capture_and_display_error_message() {
//        System.out.println("Registration Error: " + carPage.getRegErrorMessage());
//        System.out.println("Mobile Error: " + carPage.getMobileErrorMessage());
//    }
//}
package stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.CarPage;

public class CarInsuranceSteps {
    WebDriver driver;
    CarPage carPage;

    @Given("User visits GoDigit's car insurance quote page")
    public void user_visits_godigit_car_insurance_quote_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godigit.com/");
        carPage = new CarPage(driver);
        carPage.clickCommercialInsurance();
    }

    @When("User proceeds without entering car number")
    public void user_proceeds_without_entering_car_number() {
        carPage.clickViewPrice();
    }

    @Then("Capture and display the error message for missing car number")
    public void capture_and_display_error_message_for_missing_car_number() {
        System.out.println("Registration Error: " + carPage.getRegErrorMessage());
        driver.quit();
    }

    @And("Enters a valid car number")
    public void enters_a_valid_car_number() {
        carPage.enterRegistrationNumber("KA04DK1234");
    }

    @When("User fills in other required details")
    public void user_fills_in_other_required_details() {
        // This step is already covered by entering registration number
        // You can add more fields here if needed
    }

    @And("Enters an invalid email or phone number")
    public void enters_an_invalid_email_or_phone_number() {
        carPage.enterMobileNumber("12345"); // Invalid number
        carPage.clickViewPrice();
    }

    @Then("Capture and display the error message for invalid contact info")
    public void capture_and_display_error_message_for_invalid_contact_info() {
        System.out.println("Mobile Error: " + carPage.getMobileErrorMessage());
        driver.quit();
    }
}
