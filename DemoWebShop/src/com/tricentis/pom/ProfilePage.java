package com.tricentis.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	public ProfilePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Customer info")
	private WebElement customerInfoLink;
	
	@FindBy(linkText = "Addresses")
	private WebElement addressLink;
	
	
	
	@FindBy(linkText = "Orders")
	private WebElement ordersLink;
	
	
	
	@FindBy(linkText = "Downloadable products")
	private WebElement downloadableProductsLink;
	
	
	@FindBy(linkText = "Back in stock subscriptions")
	private WebElement backInStockLink;
	
	
	@FindBy(linkText = "Reward points")
	private WebElement rewardPointsLink;
	
	
	@FindBy(linkText = "Change password")
	private WebElement changePasswordLink;
	
	
	
	@FindBy(xpath = "//input[@name='Gender']")
	private List<WebElement> genderRadioBox;
	
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox;
	
	
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextBox;
	
	@FindBy (id = "Email")
	private WebElement emailTextBox;
	
	
	
	@FindBy(name =  "save-info-button")
	private WebElement personalDetailsSaveButton;
	
	@FindBy(className = "edit-address-button")
	private List<WebElement> editAddressButtons;
	
	
	@FindBy(className = "delete-address-button")
	private List<WebElement> deleteAddressButtons;
	
	
	@FindBy(className =  "add-address-button")
	private WebElement addNewAddressButton;
	
	@FindBy(className =  "order-details-button")
	private List<WebElement> orderDetailsButtons;
	
	

	@FindBy(id = "OldPassword")
	private WebElement oldPasswordInputBox;
	@FindBy(id = "NewPassword")
	
	private WebElement newPasswordInputBox;
	
	@FindBy(id = "ConfirmNewPassword")
	private WebElement confirmPasswordInputBox;
	
	
	@FindBy(className = "change-password-button")
	private WebElement changePasswordSubmitButton;
	
	private void changePassword(String oldPassword , String newPassword , String confirmPassword) {
		
		oldPasswordInputBox.clear();
		oldPasswordInputBox.sendKeys(oldPassword);
		
		newPasswordInputBox.clear();
		newPasswordInputBox.sendKeys(newPassword);
		
		confirmPasswordInputBox.clear();
		confirmPasswordInputBox.sendKeys(confirmPassword);
		
		changePasswordSubmitButton.click();
	}
	
	
	
}
