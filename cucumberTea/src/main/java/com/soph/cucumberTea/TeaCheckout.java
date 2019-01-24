package com.soph.cucumberTea;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaCheckout {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong")
	private WebElement title;
	
	public String getTitle() {
		return title.getText();
	}

}
