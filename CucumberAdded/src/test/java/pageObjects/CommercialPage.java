
package pageObjects;

import org.openqa.selenium.*;

public class CommercialPage {

    WebDriver driver;
    JavascriptExecutor js;

    public CommercialPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void clickCommercialSection() {
        driver.findElement(By.xpath("//*[@id=\"cv-tab\"]/a/div")).click();
    }

    public void clickViewPrice() {
        WebElement btn = driver.findElement(By.id("View-Price-Btn"));
        js.executeScript("arguments[0].click()", btn);
    }

    public String getRegNumberError() {
        return driver.findElement(By.xpath("//*[@id=\"cv-reg-no\"]/div/span")).getText();
    }

    public void enterRegistrationNumber(String regNo) {
        driver.findElement(By.id("vehicle-registrationNumner")).sendKeys(regNo);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(By.id("mobile-number")).sendKeys(mobile);
    }

    public String getMobileError() {
        return driver.findElement(By.xpath("//*[@id=\"mobile-number-option\"]/div/span")).getText();
    }
}
