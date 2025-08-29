/*package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class CommercialSteps {

    WebDriver driver;
    JavascriptExecutor js;

    @Given("the user opens the Digit site for commercial insurance")
    public void the_user_opens_the_digit_site_for_commercial_insurance() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.godigit.com/");
        js = (JavascriptExecutor) driver;
    }

    @When("the user clicks on the Commercial Insurance section")
    public void the_user_clicks_on_the_commercial_insurance_section() {
        driver.findElement(By.xpath("//*[@id=\"cv-tab\"]/a/div")).click();
    }

    @When("clicks on View Price without entering registration number")
    public void clicks_on_view_price_without_entering_registration_number() {
        WebElement submitBtn = driver.findElement(By.id("View-Price-Btn"));
        js.executeScript("arguments[0].click()", submitBtn);
    }

    @Then("an error message for missing registration number should be displayed")
    public void error_message_for_missing_registration_number_should_be_displayed() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"cv-reg-no\"]/div/span"));
        String message = errorMsg.getText();
        System.out.println("Error message (missing reg no): " + message);
        if (!message.contains("Enter registration number")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    @When("enters registration number {string}")
    public void enters_registration_number(String regNo) {
        driver.findElement(By.id("vehicle-registrationNumner")).sendKeys(regNo);
    }

    @When("enters invalid mobile number {string}")
    public void enters_invalid_mobile_number(String mobile) {
        driver.findElement(By.id("mobile-number")).sendKeys(mobile);
    }

    @When("clicks on View Price")
    public void clicks_on_view_price() {
        WebElement submitBtn = driver.findElement(By.id("View-Price-Btn"));
        js.executeScript("arguments[0].click()", submitBtn);
    }

    @Then("an error message for invalid mobile number should be displayed")
    public void error_message_for_invalid_mobile_number_should_be_displayed() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"mobile-number-option\"]/div/span"));
        String message = errorMsg.getText();
        System.out.println("Error message (invalid mobile): " + message);
        if (!message.contains("Sorry, that mobile number looks incorrect")) {
            throw new AssertionError("Expected mobile number error not displayed");
        }
    }
}
*/
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import pageObjects.CommercialPage;

import java.io.IOException;
import java.time.Duration;

public class CommercialSteps {

    WebDriver driver;
    CommercialPage commercial;

    @Given("the user opens the Digit site for commercial insurance")
    public void openDigitCommercialSite() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://www.godigit.com/");
        driver.get(BaseClass.getProperties().getProperty("appURL"));
        commercial = new CommercialPage(driver);
    }

    @When("the user clicks on the Commercial Insurance section")
    public void clickCommercialSection() {
        commercial.clickCommercialSection();
    }

    @When("clicks on View Price without entering registration number")
    public void clickViewPriceWithoutRegNo() {
        commercial.clickViewPrice();
    }

    @Then("an error message for missing registration number should be displayed")
    public void verifyMissingRegNoError() {
        String message = commercial.getRegNumberError();
        System.out.println("Error message: " + message);
        if (!message.contains("Enter registration number")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    @When("enters registration number {string}")
    public void enterRegistrationNumber(String regNo) {
        commercial.enterRegistrationNumber(regNo);
    }

    @When("enters invalid mobile number {string}")
    public void enterInvalidMobile(String mobile) {
        commercial.enterMobileNumber(mobile);
    }

    @When("clicks on View Price")
    public void clickViewPrice() {
        commercial.clickViewPrice();
    }

    @Then("an error message for invalid mobile number should be displayed")
    public void verifyInvalidMobileError() {
        String message = commercial.getMobileError();
        System.out.println("Mobile error: " + message);
        if (!message.contains("Sorry, that mobile number looks incorrect")) {
            throw new AssertionError("Expected mobile number error not displayed");
        }
    }
}
