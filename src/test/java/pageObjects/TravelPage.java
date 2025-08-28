package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class TravelPage extends BasePage {
	public TravelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[normalize-space()='Travel']//div[@class='qf-switcher-img-holder']")
	private WebElement travelInsuranceLink;
	
	@FindBy(id="France")
	private WebElement franceOption;
	
	@FindBy(id="departure-date")
	private WebElement departureDateInput;
	
	@FindBy(id="return-date")
	private WebElement returnDateInput;
	
	@FindBy(id="insurance-getquote")
	private WebElement getQuoteButton;
	
	@FindBy(xpath="//input[@id='travellers']")
	private WebElement traveller1DOB;
	
	@FindBy(id="add-traveller")
	private WebElement addTravellerButton;
	
	@FindBy(xpath="//input-field[@id='traveller2']//input[@id='travellers']")
	private WebElement traveller2DOB;
	
	@FindBy(xpath="//button[normalize-space()='View Prices']")
	private WebElement viewPricesButton;
	
	@FindBy(xpath="//select[@class='pika-select pika-select-month']")
	private List<WebElement> monthDropdowns;
	
	@FindBy(xpath="//select[@class='pika-select pika-select-year']")
	private List<WebElement> yearDropdowns;
	
	@FindBy(xpath="//tbody/tr/td[@data-day]")
	private List<WebElement> dayCells;
	
	public void navigateToTravelInsurance() {
		travelInsuranceLink.click();
		franceOption.click();
	}
	public void selectTravelDates(String startMonth,String startYear,String startDay,String endMonth,String endYear,String endDay) {
		departureDateInput.click();
		new Select(monthDropdowns.get(0)).selectByVisibleText(startMonth);
		new Select(yearDropdowns.get(1)).selectByVisibleText(endYear);
        List<WebElement> returnDays = driver.findElements(By.xpath("//tbody/tr/td[@data-day='" + endDay + "']"));
        returnDays.get(1).click();

	}
	public void enterTravellerDOBs(String dob1,String dob2) {
		getQuoteButton.click();
		traveller1DOB.sendKeys(dob1);
		addTravellerButton.click();
		traveller2DOB.sendKeys(dob2);
	}
	public void clickViewPrices() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",viewPricesButton);
		
	}
	public List<WebElement> getTopPlans(){
		return driver.findElements(By.xpath("//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"));
	}
}

//package pageObjects;
//
//import java.util.List;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class TravelPage extends BasePage {
//
//    public TravelPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//a[normalize-space()='Travel']//div[@class='qf-switcher-img-holder']")
//    private WebElement travelInsuranceLink;
//
//    @FindBy(id = "France")
//    private WebElement franceOption;
//
//    @FindBy(id = "departure-date")
//    private WebElement departureDateInput;
//
//    @FindBy(id = "return-date")
//    private WebElement returnDateInput;
//
//    @FindBy(id = "insurance-getquote")
//    private WebElement getQuoteButton;
//
//    @FindBy(xpath = "//input[@id='travellers']")
//    private WebElement traveller1DOB;
//
//    @FindBy(id = "add-traveller")
//    private WebElement addTravellerButton;
//
//    @FindBy(xpath = "//input-field[@id='traveller2']//input[@id='travellers']")
//    private WebElement traveller2DOB;
//
//    @FindBy(xpath = "//button[normalize-space()='View Prices']")
//    private WebElement viewPricesButton;
//
//    public void navigateToTravelInsurance() {
//        travelInsuranceLink.click();
//        franceOption.click();
//    }
//
////    public void selectTravelDates(String startDay, String endDay) {
////        // Select departure date
////        departureDateInput.click();
////        WebElement startDateElement = driver.findElement(By.xpath("//button[text()='" + startDay + "' and @data-pika-day='" + startDay + "']"));
////        startDateElement.click();
////
////        // Select return date
////        returnDateInput.click();
////        List<WebElement> endDateElements = driver.findElements(By.xpath("//button[text()='" + endDay + "' and @data-pika-day='" + endDay + "']"));
////        if (endDateElements.size() > 1) {
////            endDateElements.get(1).click(); // Click second match
////        } else if (!endDateElements.isEmpty()) {
////            endDateElements.get(0).click(); // Fallback to first match
////        }
////    }
//    public void selectTravelDates(String startDay, String endDay) {
//        // Select departure date
//        departureDateInput.click();
//        List<WebElement> startDateElements = driver.findElements(By.xpath("//button[@data-pika-day='" + startDay + "' and not(ancestor::td[contains(@class,'is-disabled')])]"));
//        if (!startDateElements.isEmpty()) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", startDateElements.get(0));
//        }
//
//        // Select return date
//        returnDateInput.click();
//        List<WebElement> endDateElements = driver.findElements(By.xpath("//button[@data-pika-day='" + endDay + "' and not(ancestor::td[contains(@class,'is-disabled')])]"));
//        if (endDateElements.size() > 1) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", endDateElements.get(1));
//        } else if (!endDateElements.isEmpty()) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", endDateElements.get(0));
//        }
//    }
//
//
//    public void enterTravellerDOBs(String dob1, String dob2) {
//        getQuoteButton.click();
//        traveller1DOB.sendKeys(dob1);
//        addTravellerButton.click();
//        traveller2DOB.sendKeys(dob2);
//    }
//
//    public void clickViewPrices() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", viewPricesButton);
//    }
//
//    public List<WebElement> getTopPlans() {
//        return driver.findElements(By.xpath("//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"));
//    }
//}
//
