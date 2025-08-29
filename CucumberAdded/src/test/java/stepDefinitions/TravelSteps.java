/*package stepDefinitions;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import hooks.Hooks;
import io.cucumber.java.en.*;

public class TravelSteps {

    WebDriver driver = Hooks.driver;
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    @Given("the user launches the Digit insurance website")
    public void the_user_launches_the_digit_insurance_website() {
        driver.get("https://www.godigit.com"); // Update with actual URL if different
    }

    @When("the user navigates to the Travel Insurance section")
    public void the_user_navigates_to_the_travel_insurance_section() {
        driver.findElement(By.xpath("//a[normalize-space()='Travel']//div[@class='qf-switcher-img-holder']")).click();
    }

    @When("selects France as the destination")
    public void selects_france_as_the_destination() {
        driver.findElement(By.id("France")).click();
    }

    @When("selects departure date as {string}")
    public void selects_departure_date_as(String date) {
        String[] parts = date.split(" ");
        String day = parts[0], month = parts[1], year = parts[2];

        driver.findElement(By.id("departure-date")).click();
        new Select(driver.findElement(By.xpath("//select[@class='pika-select pika-select-month']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.xpath("//select[@class='pika-select pika-select-year']"))).selectByVisibleText(year);
        driver.findElement(By.xpath("//tbody/tr/td[@data-day='" + day + "']")).click();
    }

    @When("selects return date as {string}")
    public void selects_return_date_as(String date) {
        String[] parts = date.split(" ");
        String day = parts[0], month = parts[1], year = parts[2];

        WebElement returnDateInput = driver.findElement(By.id("return-date"));
        js.executeScript("arguments[0].click()", returnDateInput);

        List<WebElement> monthDropdowns = driver.findElements(By.xpath("//select[@class='pika-select pika-select-month']"));
        new Select(monthDropdowns.get(1)).selectByVisibleText(month);

        List<WebElement> yearDropdowns = driver.findElements(By.xpath("//select[@class='pika-select pika-select-year']"));
        new Select(yearDropdowns.get(1)).selectByVisibleText(year);

        List<WebElement> dayCells = driver.findElements(By.xpath("//tbody/tr/td[@data-day='" + day + "']"));
        dayCells.get(1).click();
    }

    @When("clicks on Get Quote")
    public void clicks_on_get_quote() {
        driver.findElement(By.id("insurance-getquote")).click();
    }

    @Then("the quote form should be displayed")
    public void the_quote_form_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dobField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("travellers")));

        if (!dobField.isDisplayed()) {
            throw new AssertionError("Quote form not displayed");
        }
    }

    @When("the user enters date of birth {string} for the first traveller")
    public void the_user_enters_date_of_birth_for_the_first_traveller(String dob) {
        driver.findElement(By.id("travellers")).sendKeys(dob);
    }

    @When("adds another traveller with date of birth {string}")
    public void adds_another_traveller_with_date_of_birth(String dob) {
        driver.findElement(By.id("add-traveller")).click();
        driver.findElement(By.xpath("//input-field[@id='traveller2']//input[@id='travellers']")).sendKeys(dob);
    }

    @When("clicks on View Prices")
    public void clicks_on_view_prices() {
        WebElement viewPricesBtn = driver.findElement(By.xpath("//button[normalize-space()='View Prices']"));
        js.executeScript("arguments[0].click()", viewPricesBtn);
    }

    @Then("the user should see available insurance plans with their prices")
    public void the_user_should_see_available_insurance_plans_with_their_prices() {
        List<WebElement> plans = driver.findElements(By.xpath("//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"));
        Map<String, String> planPriceMap = new HashMap<>();

        for (WebElement plan : plans) {
            try {
                String name = plan.findElement(By.tagName("h2")).getText();
                String price = plan.findElement(By.xpath(".//p[contains(@class,'notranslate')]")).getText();
                planPriceMap.put(name, price);
            } catch (Exception e) {
                System.out.println("Plan details not found for one of the elements.");
            }
        }

        if (planPriceMap.isEmpty()) {
            throw new AssertionError("No insurance plans found.");
        } else {
            System.out.println("Available Plans and Prices:");
            planPriceMap.forEach((name, price) -> System.out.println(name + " → " + price));
        }
    }
}
*/
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;

import factory.BaseClass;
import hooks.Hooks;
import pageObjects.TravelPage;

import java.io.IOException;
import java.util.Map;

public class TravelSteps {

    WebDriver driver = Hooks.driver;
    TravelPage travel = new TravelPage(driver);

    @Given("the user launches the Digit insurance website")
    public void launchDigitSite() throws Exception {
    	driver.get(BaseClass.getProperties().getProperty("appURL"));
    }

    @When("the user navigates to the Travel Insurance section")
    public void navigateToTravelInsurance() {
        travel.clickTravelSection();
    }

    @When("selects France as the destination")
    public void selectFranceDestination() {
        travel.selectCountry("France");
    }

    @When("selects departure date as {string}")
    public void selectDepartureDate(String date) {
        String[] parts = date.split(" ");
        travel.selectDepartureDate(parts[0], parts[1], parts[2]);
    }

    @When("selects return date as {string}")
    public void selectReturnDate(String date) {
        String[] parts = date.split(" ");
        travel.selectReturnDate(parts[0], parts[1], parts[2]);
    }

    @When("clicks on Get Quote")
    public void clickGetQuote() {
        travel.clickGetQuote();
    }

    @Then("the quote form should be displayed")
    public void verifyQuoteFormDisplayed() {
        WebElement dobField = driver.findElement(By.id("travellers"));
        if (!dobField.isDisplayed()) {
            throw new AssertionError("Quote form not displayed");
        }
    }

    @When("the user enters date of birth {string} for the first traveller")
    public void enterDOBFirstTraveller(String dob) {
        travel.enterTravellerDOB(dob);
    }

    @When("adds another traveller with date of birth {string}")
    public void addSecondTraveller(String dob) {
        travel.addTraveller(dob);
    }

    @When("clicks on View Prices")
    public void clickViewPrices() {
        travel.clickViewPrices();
    }

    @Then("the user should see available insurance plans with their prices")
    public void verifyPlansAndPrices() {
        Map<String, String> plans = travel.getPlans();
        if (plans.isEmpty()) {
            throw new AssertionError("No insurance plans found.");
        }
        System.out.println("Available Plans:");
        plans.forEach((name, price) -> System.out.println(name + " → " + price));
    }
}
