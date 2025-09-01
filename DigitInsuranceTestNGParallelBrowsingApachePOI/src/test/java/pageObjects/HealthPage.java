package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthPage extends BasePage{
	public HealthPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath = "//a[normalize-space()='Health']")
	    WebElement healthTab;

	    @FindBy(css = "input[id='resident-pincode-input'][name='pincode-name']")
	    WebElement pincodeInput;

	    @FindBy(id = "health-mob")
	    WebElement mobileInput;

	    @FindBy(xpath = "//div[@id='healthNewFlowForm']//button[normalize-space()='View Prices']")
	    WebElement viewPricesBtn;

	    @FindBy(xpath = "//div[normalize-space()='Health Insurance Policy']")
	    WebElement healthInsurancePolicyLink;

	    @FindBy(xpath = "//div[@class='family-details']//label[2]")
	    List<WebElement> familyMenuItems;

	    @FindBy(xpath = "//div[@class='parent-details']//label[2]")
	    List<WebElement> parentMenuItems;

	    public void openHealthSection() {
	        healthTab.click();
	    }

	    public void enterPincode(String pincode) {
	        pincodeInput.clear();
	        pincodeInput.sendKeys(pincode);
	    }

	    public void enterMobileNumber(String mobile) {
	        mobileInput.sendKeys(mobile);
	    }

	    public void clickViewPrices() {
	    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", viewPricesBtn);
	    }

	    public void clickHealthInsurancePolicy() {
	    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	WebElement policyLink=wait.until(ExpectedConditions.elementToBeClickable(
	    	By.xpath("//div[contains(text(),'Health Insurance Policy')]")));
	        policyLink.click();
	        //healthInsurancePolicyLink.click();
	    }

	    public List<WebElement> getFamilyMenuItems() {
	        return familyMenuItems;
	    }

	    public List<WebElement> getParentMenuItems() {
	        return parentMenuItems;
	    }
}
