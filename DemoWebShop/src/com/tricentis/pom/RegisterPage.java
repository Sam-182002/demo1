package com.tricentis.pom;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".field-validation-error")
	private List<WebElement> errorMessage;
	@FindBy(id = "gender-male")
	private WebElement radioMale;

	@FindBy(id = "gender-female")
	private WebElement radioFemale;

	@FindBy(id = "FirstName")
	private WebElement inputFirstName;

	@FindBy(id = "LastName")
	private WebElement inputLastName;

	@FindBy(id = "Email")
	private WebElement inputEmail;

	@FindBy(id = "Password")
	private WebElement inputPassword;

	@FindBy(id = "ConfirmPassword")
	private WebElement inputConfirmPassword;

	@FindBy(id = "register-button")
	private WebElement buttonRegiser;

	@FindBy(xpath = "//div[@class='page-body']/div[1]")
	private WebElement registerSuccessText;
	
	
	@FindBy(className = "ico-logout")
	private WebElement logOutLink;
	
	
	public void selectGender(String gender) {

		if (gender.contains("f") || gender.contains("F")) {
			radioFemale.click();
		} else {
			radioMale.click();
		}
	}

	
	private void enterFirstName(String name) {
		inputFirstName.clear();
		inputFirstName.sendKeys(name);
	}

	private void enterLastName(String name) {
		inputLastName.clear();
		inputLastName.sendKeys(name);
	}

	private void enterEmail(String name) {
		inputEmail.clear();
		inputEmail.sendKeys(name);
	}

	private void enterPassword(String name) {
		inputPassword.clear();
		inputPassword.sendKeys(name);
	}

	private void enterConfirmPassword(String name) {
		inputConfirmPassword.clear();
		inputConfirmPassword.sendKeys(name);
	}

	private void clickOnRegisterButton() {
		buttonRegiser.click();
	}

	public List<String> getErrorMessages() {

	    List<String> errors = new ArrayList<>();

	    
	    for (WebElement e : errorMessage) {
	        String text = e.getText().trim();
	        if (!text.isEmpty()) {
	            errors.add(text);
	        }
	    }

	    return errors;
	}
	public String getRegisterSuccessMessage() {
		return registerSuccessText.getText();
	}


	
	public void clickLogOutLink() {
		logOutLink.click();
	}
	public void registerForm(String gender, String firstName, String lastName, String email, String password,
			String confirmPassword) {
		selectGender(gender);
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);

		clickOnRegisterButton();

	}
	

}
