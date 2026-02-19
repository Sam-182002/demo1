package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;
	
	
	@FindBy (id = "Email")
	private WebElement emailTextBox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextBox;

	@FindBy(id = "RememberMe")
	private WebElement rememberMe;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgetPassword;

	@FindBy ( className =  "login-button")
	private WebElement loginButton;
	


	@FindBy(xpath = "//span[@for='Email']")
	private WebElement emailError;

	@FindBy(id = "password-error")
	private WebElement passwordError;

	@FindBy(xpath = "//div[@class='validation-summary-errors']/child::span")
	private WebElement loginError;

	public void clickRegister() {
		registerButton.click();
	}
	
	public void rememberMeCheckBox(boolean a) {
		if (a != rememberMe.isSelected()) {
			rememberMe.click();
		}
		
	}
	public void clickForget() {
		forgetPassword.click();
	}
	
	
	public void loginUser(String email, String password) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}

	public void loginUser(String email, String password, boolean rememberMe) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		rememberMeCheckBox(rememberMe);
		loginButton.click();
	}
	

	public String getEmailError() {
		return emailError.getText();
	}

	public String getPasswordError() {
		return passwordError.getText();
	}
	
	public String getLoginError() {
		return loginError.getText();
	}
	
	public boolean isSuccessLogin() {
		
		
		try {
	        return !registerButton.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
}
