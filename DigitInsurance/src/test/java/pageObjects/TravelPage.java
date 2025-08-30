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
	
	@FindBy(xpath="//h3[@class=\"notranslate ng-tns-c111-16\"]")
	private List<WebElement> planOptions;
	
//	@FindBy(xpath="//tbody/tr/td[@data-day]")
//	private List<WebElement> dayCells;
	
	public void navigateToTravelInsurance() {
		travelInsuranceLink.click();
	}
	
	public void selectTravelDates(int index, String month,String year,String day) {
		if(index==0) {
			departureDateInput.click();
		}
		else {
			returnDateInput.click();
		}
		new Select(monthDropdowns.get(index)).selectByVisibleText(month);
		new Select(yearDropdowns.get(index)).selectByVisibleText(year);
		List<WebElement> dayElement= driver.findElements(By.xpath("//button[text()='"+day+"' and @data-pika-day='"+day+"']"));
		dayElement.get(index).click();

	}
	public void clickGetQuoteButton() {
		getQuoteButton.click();
	}
	public void enterTravellerDOBs(String dob1,String dob2) {
		traveller1DOB.sendKeys(dob1);
		addTravellerButton.click();
		traveller2DOB.sendKeys(dob2);
	}
	public void clickViewPrices() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",viewPricesButton);
	}
	
	public void selectPlanOption(int index) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",planOptions.get(index));
	}
	
//	public List<WebElement> getTopPlans(){
//		return driver.findElements(By.xpath("//div[@id='plan-0' or @id='plan-1' or @id='plan-2']"));
//	}
}