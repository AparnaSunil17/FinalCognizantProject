package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialPage extends BasePage{
	public CommercialPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id=\"cv-tab\"]/a/div")
    WebElement commercialInsuranceTab;

    @FindBy(id = "View-Price-Btn")
    WebElement viewPriceBtn;

    @FindBy(id = "vehicle-registrationNumner")
    WebElement regNumberInput;

    @FindBy(id = "mobile-number")
    WebElement mobileNumberInput;
    
    public void clickCommercialInsurance() {
        commercialInsuranceTab.click();
    }

    public void clickViewPrice() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", viewPriceBtn);
    }

    
    public void enterRegistrationNumber(String regNo) {
        regNumberInput.sendKeys(regNo);
    }

    public void enterMobileNumber(String mobileNo) {
        mobileNumberInput.sendKeys(mobileNo);
    }

}
