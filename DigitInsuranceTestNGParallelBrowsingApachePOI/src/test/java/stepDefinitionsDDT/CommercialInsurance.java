package stepDefinitionsDDT;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommercialPage;
import utilities.DataReader;

public class CommercialInsurance {
	public CommercialPage commercialPage;
	List<HashMap<String, String>> datamap;
	
	@Given("User visits GoDigit commercial insurance quote page")
	public void navigateToCommercialInsurancePage() {
		commercialPage=new CommercialPage(BaseClass.getDriver());
		commercialPage.clickCommercialInsurance();
		BaseClass.getLogger().info("Navigated to Commercial Insurance....");
	}

	@When("User enters the phone number and proceeds clicks View Prices button without entering registration number {string}")
	public void enterPhoneNumberAndProceed(String rows) {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\InsuranceData.xlsx", "Commercial Insurance");
		int index=Integer.parseInt(rows)-1;
		String phone_no= datamap.get(index).get("Valid_Phone_Number");
	    commercialPage.enterMobileNumber(phone_no);
	    BaseClass.getLogger().info("Entered the Phone Number....");
	    commercialPage.clickViewPrice();
	    
	}

	@Then("Capture and display the error message for missing registration number")
	public void captureErrorMessageForMissingRegNumber() {
		try {
		String errorMsg= BaseClass.getDriver().findElement(By.xpath("//*[@id=\"cv-reg-no\"]/div/span")).getText();
		System.out.println("ERROR MESSAGE FOR MISSING REGISTRATION NUMBER : "+errorMsg);
		BaseClass.getLogger().info("Captured the error message for MISSING REGISTRATION NUMBER..");
		}
		catch(Exception e){
			BaseClass.getLogger().info("Failed to capture the error message..");
			Assert.assertTrue(false);
		}
	}

	@Given("User visits GoDigits commercial insurance quote page")
	public void navigateToCommercialInsurancePageSecondTime() {
		commercialPage=new CommercialPage(BaseClass.getDriver());
		commercialPage.clickCommercialInsurance();
		BaseClass.getLogger().info("Navigated to Commercial Insurance....");
	}

	@When("Enters a valid registration number {string}")
	public void enterValidRegNumber(String rows) {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\InsuranceData.xlsx", "Commercial Insurance");
		int index=Integer.parseInt(rows)-1;
		String reg_no= datamap.get(index).get("Commercial_Registration_Number");
		commercialPage.enterRegistrationNumber(reg_no);
		BaseClass.getLogger().info("Entered the Registration Number..");
	}

	@When("Enters an invalid phone number and clicks View Prices button {string}")
	public void invalidPhoneNumber(String rows) {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\InsuranceData.xlsx", "Commercial Insurance");
		int index=Integer.parseInt(rows)-1;
		try {
		Thread.sleep(2000);
		String phone_no= datamap.get(index).get("Invalid_Phone_Number");
		commercialPage.enterMobileNumber(phone_no);
		BaseClass.getLogger().info("Entered the invalid phone Number..");
		}
		catch(Exception e) {
			
		}
		commercialPage.clickViewPrice();
		BaseClass.getLogger().info("Clicked View Prices Button..");
		
	}

	@Then("Capture and display the error message for invalid contact info")
	public void errorMessageInvalidPhoneNumber() {
		try {
		String errorMsg= BaseClass.getDriver().findElement(By.xpath("//*[@id=\"mobile-number-option\"]/div/span")).getText();
		System.out.println("ERROR MESSAGE FOR INVALID PHONE NUMBER : "+errorMsg);
		BaseClass.getLogger().info("Captured the error message for INVALID PHONE NUMBER..");
		}
		catch(Exception e){
			Assert.assertTrue(false);
			BaseClass.getLogger().info("Failed to capture the error message..");
		}
	}



}
