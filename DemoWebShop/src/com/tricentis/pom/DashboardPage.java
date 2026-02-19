package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className   = "ico-login" )
	private WebElement loginLink;
	
	@FindBy(className = "ico-register")
	private WebElement registerLink;
	
	
	public void clickLoginLink() {
		loginLink.click();
	}
	public void clickRegisterLink() {
		registerLink.click();
	}
}
