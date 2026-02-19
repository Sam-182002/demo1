package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Enquiry")
	private WebElement enquiryTextBox;
	
	
	@FindBy(name = "send-email")
	private WebElement submitButton;
	
	@FindBy (xpath = "//div[@class='result']" )
	private WebElement successMessageText;
	
	
	
	public void enterText(String msg) {
		
		enquiryTextBox.sendKeys(msg);
		submitButton.click();
	}
	
	public String getMessageText() {
		
		return successMessageText.getText();
	}
	
}
