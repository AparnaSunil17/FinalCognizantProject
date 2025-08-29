/*package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.cucumber.java.en.*;

public class HealthSteps {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    List<String> healthMenuItems = new ArrayList<>();

    @Given("the user launches the GoDigit website")
    public void launchWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.godigit.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @When("the user clicks on Health Insurance")
    public void clickHealthInsurance() {
        driver.findElement(By.xpath("//a[normalize-space()='Health']")).click();
    }

    @When("the user enters pincode {string}")
    public void enterPincode(String pincode) {
        WebElement pincodeInput = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[id='resident-pincode-input'][name='pincode-name']")));
        pincodeInput.clear();
        pincodeInput.sendKeys(pincode);
    }

    @When("the user enters mobile number {string}")
    public void enterMobileNumber(String number) {
        driver.findElement(By.id("health-mob")).sendKeys(number);
    }

    @When("the user clicks on View Prices")
    public void clickViewPrices() {
        WebElement submitbtn = driver.findElement(By.xpath(
            "//div[@id='healthNewFlowForm']//button[normalize-space()='View Prices']"));
        js.executeScript("arguments[0].click();", submitbtn);
    }

    @When("the user selects Health Insurance Policy")
    public void selectHealthInsurancePolicy() {
        driver.findElement(By.xpath("//div[normalize-space()='Health Insurance Policy']")).click();
    }

    @Then("the user should see the available health insurance menu items")
    public void verifyMenuItems() {
        List<WebElement> menuItemElement1 = driver.findElements(
            By.xpath("//div[@class='family-details']//label[2]"));
        List<WebElement> menuItemElement2 = driver.findElements(
            By.xpath("//div[@class='parent-details']//label[2]"));

        for (WebElement menu : menuItemElement1) {
            healthMenuItems.add(menu.getText());
        }
        for (WebElement menu : menuItemElement2) {
            healthMenuItems.add(menu.getText());
        }

        System.out.println("Menu items for health insurance:");
        for (String item : healthMenuItems) {
            System.out.println(item);
        }

        driver.quit();
    }
}
*/
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import pageObjects.HealthPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HealthSteps {

    WebDriver driver;
    HealthPage health;

    @Given("the user launches the GoDigit website")
    public void launchWebsite() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://www.godigit.com/");
        driver.get(BaseClass.getProperties().getProperty("appURL"));
        health = new HealthPage(driver);
    }

    @When("the user clicks on Health Insurance")
    public void clickHealthInsurance() {
        health.clickHealthSection();
    }

    @When("the user enters pincode {string}")
    public void enterPincode(String pincode) {
        health.enterPincode(pincode);
    }

    @When("the user enters mobile number {string}")
    public void enterMobileNumber(String number) {
        health.enterMobile(number);
    }

    @When("the user clicks on View Prices")
    public void clickViewPrices() {
        health.clickViewPrices();
    }

    @When("the user selects Health Insurance Policy")
    public void selectHealthInsurancePolicy() {
        health.selectHealthPolicy();
    }

    @Then("the user should see the available health insurance menu items")
    public void verifyMenuItems() {
        List<String> items = health.getMenuItems();
        System.out.println("Health Insurance Menu Items:");
        for (String item : items) {
            System.out.println(item);
        }
        driver.quit();
    }
}
