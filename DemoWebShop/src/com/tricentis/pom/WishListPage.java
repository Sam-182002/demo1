package com.tricentis.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[@class='cart-item-row']/td[4]/a")
	private List<WebElement> productsName;

	@FindBy(xpath = "//tr[@class='cart-item-row']/td[5]/span[2]")
	private List<WebElement> productsPrice;

	@FindBy(xpath = "//input[@name='removefromcart']")
	private List<WebElement> removeFromCartCheckBox;

	@FindBy(xpath = "//input[@value='Update wishlist']")
	private WebElement updateWishlist;

	@FindBy(className = "wishlist-content")
	private WebElement getMessageText;

	public void removeAll() {
		for (WebElement ele : removeFromCartCheckBox) {
			ele.click();
		}
		updateWishlist.click();
	}

	public String getMessage() {
		return getMessageText.getText();
	}

	public boolean isNameAndPricePresent(String[] s) {

		String name = s[0];
		String price = s[1];

		for (int i = 0; i < productsPrice.size(); i++) {

			if (productsName.get(i).getText().equalsIgnoreCase(name)
					&& productsPrice.get(i).getText().equalsIgnoreCase(price)) {
				return true;
			}
		}
		return false;

	}

}
