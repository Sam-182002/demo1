package com.tricentis.pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public CartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='product-name']/following::input[@class='qty-input']")
	private List<WebElement> quantityInput;

	@FindBy(xpath = "//a[@class='product-name']/preceding::input[@name='removefromcart']")
	private List<WebElement> removeCheckBox;

	@FindBy(className = "product-name")
	private List<WebElement> productNames;

	@FindBy(xpath = "//a[@class='product-name']/following::span[@class='product-unit-price']")
	private List<WebElement> productPrices;

	@FindBy(className = "checkout-buttons")
	private WebElement checkOutButton;

	
	@FindBy(xpath = "//input[contains(@class,'update-wishlist-button')]")
	private WebElement removeButton;

	@FindBy(className = "wishlist-content")
	private WebElement getMessageText;

	public void removeAll() {
		for (WebElement ele : removeCheckBox) {
			ele.click();
		}
	}
	public void clickOnCheckOut() {
		checkOutButton.click();
	}

	public void changeQuantity(String name, int quantity) {

		for (int i = 0; i < productNames.size(); i++) {
			if (productNames.get(i).getText().equalsIgnoreCase(name)) {
				
				quantityInput.get(i).sendKeys(Integer.toString(quantity));
				return;
			}
		}
	}

	public boolean isNameAndPricePresent(String[] s) {

		String name = s[0];
		String price = s[1];

		for (int i = 0; i < productPrices.size(); i++) {

			if (productNames.get(i).getText().equalsIgnoreCase(name)
					&& productPrices.get(i).getText().equalsIgnoreCase(price)) {
				return true;
			}
		}
		return false;

	}

}
