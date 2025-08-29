package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public HealthPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    public void clickHealthSection() {
        driver.findElement(By.xpath("//a[normalize-space()='Health']")).click();
    }

    public void enterPincode(String pincode) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[id='resident-pincode-input'][name='pincode-name']")));
        input.clear();
        input.sendKeys(pincode);
    }

    public void enterMobile(String mobile) {
        driver.findElement(By.id("health-mob")).sendKeys(mobile);
    }

    public void clickViewPrices() {
        WebElement btn = driver.findElement(By.xpath("//div[@id='healthNewFlowForm']//button[normalize-space()='View Prices']"));
        js.executeScript("arguments[0].click()", btn);
    }

    public void selectHealthPolicy() {
        driver.findElement(By.xpath("//div[normalize-space()='Health Insurance Policy']")).click();
    }

    public List<String> getMenuItems() {
        List<String> items = new ArrayList<>();
        List<WebElement> family = driver.findElements(By.xpath("//div[@class='family-details']//label[2]"));
        List<WebElement> parent = driver.findElements(By.xpath("//div[@class='parent-details']//label[2]"));

        for (WebElement el : family) items.add(el.getText());
        for (WebElement el : parent) items.add(el.getText());

        return items;
    }
}
