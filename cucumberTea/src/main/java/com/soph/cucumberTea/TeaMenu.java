package com.soph.cucumberTea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenu {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")
	private WebElement menuTitle;
	
	public String getTitle() {
		return menuTitle.getText();
	}
	
	
}
