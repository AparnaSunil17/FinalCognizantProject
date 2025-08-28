//package pageObjects;
//
//import org.openqa.selenium.WebDriver;
//
//public class CarPage extends BasePage{
//	public CarPage(WebDriver driver) {
//		super(driver);
//	}
//}
package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarPage {
    WebDriver driver;
    JavascriptExecutor js;

    public CarPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cv-tab\"]/a/div")
    WebElement commercialInsuranceTab;

    @FindBy(id = "View-Price-Btn")
    WebElement viewPriceBtn;

    @FindBy(xpath = "//*[@id=\"cv-reg-no\"]/div/span")
    WebElement regErrorMsg;

    @FindBy(id = "vehicle-registrationNumner")
    WebElement regNumberInput;

    @FindBy(id = "mobile-number")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//*[@id=\"mobile-number-option\"]/div/span")
    WebElement mobileErrorMsg;

    public void clickCommercialInsurance() {
        commercialInsuranceTab.click();
    }

    public void clickViewPrice() {
        js.executeScript("arguments[0].click()", viewPriceBtn);
    }

    public String getRegErrorMessage() {
        return regErrorMsg.getText();
    }

    public void enterRegistrationNumber(String regNo) {
        regNumberInput.sendKeys(regNo);
    }

    public void enterMobileNumber(String mobileNo) {
        mobileNumberInput.sendKeys(mobileNo);
    }

    public String getMobileErrorMessage() {
        return mobileErrorMsg.getText();
    }
}

