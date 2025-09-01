package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TravelPage;

public class TravelInsurance {
	public TravelPage travelPage;
	
	@Given("the user selects the travel insurance icon")
	public void navigateToTravelInsurancePage() {
		travelPage=new TravelPage(BaseClass.getDriver());
		travelPage.navigateToTravelInsurance();
	}

	@When("the user fills the details then clicks the View Prices button \\(country={string}, startDay={string},startMonth={string},startYear={string},startDay={string},startMonth={string},startYear={string})")
	public void fillTravelInsurancePage(String country, String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear) {
		WebElement location= BaseClass.getDriver().findElement(By.xpath("//*[@id='"+country+"']"));
		JavascriptExecutor js= (JavascriptExecutor)BaseClass.getDriver();
		js.executeScript("arguments[0].click();",location);
		travelPage.selectTravelDates(0,startMonth,startYear,startDay);
		travelPage.selectTravelDates(1,endMonth,endYear,endDay);
		travelPage.clickGetQuoteButton();
	}

	@When("adds the Date of Births of travelers then clicks View Prices button \\(DOB1= {string}, DOB2={string})")
	public void addDateOfBirthsOfTravellers(String dob1, String dob2) {
	    travelPage.enterTravellerDOBs(dob1, dob2);
	    travelPage.clickViewPrices();
	}

	@Then("find the three lowest insurance plan")
	public void findThreeLowestInsurancePlan() {
		List<String> list=new ArrayList<String>();

		for(int i=0;i<4;i++) {
			travelPage.selectPlanOption(i);
			List<WebElement> planList= BaseClass.getDriver().findElements(By.xpath("//div[contains(@id,\"plan-\")]/div[1]/div[1]//p[1]"));
			int size=planList.size();
			for(int j=0;j<size;j++) {
				if(planList.get(j).isDisplayed()) {
					list.add(planList.get(j).getText());
				}
			}
		}
		Collections.sort(list);
		
		System.out.println("The 3 least insurance values are :");
		System.out.println(list.get(0)+" , "+list.get(1)+" , "+list.get(2));
	}



}
