package stepDefinitionsDDT;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HealthPage;
import utilities.DataReader;

public class HealthInsurance {
	HealthPage healthPage;
	List<HashMap<String, String>> datamap;
	
	@Given("User navigates to GoDigits health insurance section")
	public void navigatesToHealthInsurancePage() {
		healthPage=new HealthPage(BaseClass.getDriver());
		healthPage.openHealthSection();
        BaseClass.getLogger().info("Navigated to Health Insurance section...");
	}

	@When("User fills the pincode and mobile number then click View Prices {string}")
	public void fillsHealthInsurancePage(String rows) {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\InsuranceData.xlsx", "Commercial Insurance");
		int index=Integer.parseInt(rows)-1;
		String pincode= datamap.get(index).get("Pincode");
	    String phone_no= datamap.get(index).get("Phone_Number");
		healthPage.enterPincode(pincode);
		 BaseClass.getLogger().info("Entered pincode: " + pincode);
		healthPage.enterMobileNumber(phone_no);
		BaseClass.getLogger().info("Entered mobile number: " + phone_no);
		healthPage.clickViewPrices();
		BaseClass.getLogger().info("Clicked View Price Button.");
	}

	@Then("User accesses the health insurance menu")
	public void selectHealthInsurancePolicy() {
		healthPage.clickHealthInsurancePolicy();
		BaseClass.getLogger().info("Accessed health insurance policy menu.");
	}

	@Then("Store all menu items in a list and display them")
	public void storeList() {
		try {
		Thread.sleep(4000);
		}
		catch(Exception e) {
			
		}
	    List<WebElement> list1 = healthPage.getFamilyMenuItems();
	    BaseClass.getLogger().info("Fetched family menu items.");
	    
	    List<WebElement> list2 = healthPage.getParentMenuItems();
	    BaseClass.getLogger().info("Fetched parent menu items.");
	    
	    
	    System.out.println("Health Insurance Menu Items:");
	    for(int i=0;i<list1.size();i++) {
	    	System.out.println(list1.get(i).getText());
	    }
	    for(int i=0;i<list2.size();i++) {
	    	System.out.println(list2.get(i).getText());
	    }
	    
	}




}
