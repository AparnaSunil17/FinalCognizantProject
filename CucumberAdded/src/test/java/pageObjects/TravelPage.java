package pageObjects;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class TravelPage {

    WebDriver driver;
    JavascriptExecutor js;

    public TravelPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void clickTravelSection() {
        driver.findElement(By.xpath("//a[normalize-space()='Travel']//div[@class='qf-switcher-img-holder']")).click();
    }

    public void selectCountry(String countryId) {
        driver.findElement(By.id(countryId)).click();
    }

    public void selectDepartureDate(String day, String month, String year) {
        driver.findElement(By.id("departure-date")).click();
        new Select(driver.findElement(By.xpath("//select[@class='pika-select pika-select-month']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.xpath("//select[@class='pika-select pika-select-year']"))).selectByVisibleText(year);
        driver.findElement(By.xpath("//tbody/tr/td[@data-day='" + day + "']")).click();
    }

    public void selectReturnDate(String day, String month, String year) {
        WebElement returnInput = driver.findElement(By.id("return-date"));
        js.executeScript("arguments[0].click()", returnInput);

        List<WebElement> months = driver.findElements(By.xpath("//select[@class='pika-select pika-select-month']"));
        new Select(months.get(1)).selectByVisibleText(month);

        List<WebElement> years = driver.findElements(By.xpath("//select[@class='pika-select pika-select-year']"));
        new Select(years.get(1)).selectByVisibleText(year);

        List<WebElement> days = driver.findElements(By.xpath("//tbody/tr/td[@data-day='" + day + "']"));
        days.get(1).click();
    }

    public void clickGetQuote() {
        driver.findElement(By.id("insurance-getquote")).click();
    }

    public void enterTravellerDOB(String dob) {
        driver.findElement(By.id("travellers")).sendKeys(dob);
    }

    public void addTraveller(String dob) {
        driver.findElement(By.id("add-traveller")).click();
        driver.findElement(By.xpath("//input-field[@id='traveller2']//input[@id='travellers']")).sendKeys(dob);
    }

    public void clickViewPrices() {
        WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='View Prices']"));
        js.executeScript("arguments[0].click()", btn);
    }

    public Map<String, String> getPlans() {
        List<WebElement> plans = driver.findElements(By.xpath("//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"));
        Map<String, String> planMap = new HashMap<>();

        for (WebElement plan : plans) {
            try {
                String name = plan.findElement(By.tagName("h2")).getText();
                String price = plan.findElement(By.xpath(".//p[contains(@class,'notranslate')]")).getText();
                planMap.put(name, price);
            } catch (Exception e) {
                System.out.println("Plan details not found.");
            }
        }

        return planMap;
    }
}
