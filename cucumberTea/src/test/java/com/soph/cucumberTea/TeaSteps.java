package com.soph.cucumberTea;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {
	ExtentReports extent;
	ExtentTest test;
	ExtentTest test2;
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		extent = new ExtentReports(Constants.reportPath, false);
		test = extent.startTest("menu");
		test.log(LogStatus.INFO, "test started");
		test2 = extent.startTest("checkout");
		test.log(LogStatus.INFO, "test started");
	
	}
	
	@After
	public void teardown() {
		driver.quit();
		extent.endTest(test);
		extent.endTest(test2);
		extent.flush();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address()  {
	 driver.get(Constants.websiteURL);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
		TeaHome home = PageFactory.initElements(driver, TeaHome.class);
		home.navigateMenu();
	 
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
	

		TeaMenu menu = PageFactory.initElements(driver, TeaMenu.class);
		if(menu.getTitle().equals("Menu")) {
			test.log(LogStatus.PASS, "can browse products");
		}
		else {
			test.log(LogStatus.FAIL, "cannot browse products");
		}
		assertEquals("Menu" ,menu.getTitle() );
	
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		TeaHome home = PageFactory.initElements(driver, TeaHome.class);
		home.navigatecheckout();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {

		TeaCheckout checkout = PageFactory.initElements(driver, TeaCheckout.class);
		if(checkout.getTitle().equals("Pay with Credit Card or Log In")) {
			test2.log(LogStatus.PASS, "taken to checkout page");
		}
		else {
			test2.log(LogStatus.FAIL, "not taken to checkout page");
		}
		assertEquals("Pay with Credit Card or Log In", checkout.getTitle());


	}

}
