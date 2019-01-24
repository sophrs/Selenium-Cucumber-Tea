package com.soph.cucumberTea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHome {
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menubutton;
	
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkoutbutton;
	
	public void navigateMenu() {
		menubutton.click();
	}
	
	public void navigatecheckout() {
		checkoutbutton.click();
	}

}
