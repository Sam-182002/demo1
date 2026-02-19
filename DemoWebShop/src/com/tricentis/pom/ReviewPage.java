package com.tricentis.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

	public ReviewPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='review-title']")
	private WebElement reviewTitleInput;

	@FindBy(xpath = "//textarea[@class='review-text']")
	private WebElement reviewTextInput;
	@FindBy(name = "AddProductReview.Rating")
	private List<WebElement> reviewTitleInputBox;

	@FindBy(xpath = "(//div[@class='review-title'])[last()]")
	private WebElement lastReviewtitle;

	@FindBy(name = "add-review")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement successMessage;

	public void enterReviewTitle(String title) {
		reviewTitleInput.sendKeys(title);
	}

	public void enterReviewSummary(String text) {
		reviewTextInput.sendKeys(text);
	}

	public void rateCheckBox(int value) {
		reviewTitleInputBox.get(value - 1).click();
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public String getSuccessMessage() {

		return successMessage.getText();
	}

	public String getLastReviewTitle() {
		return lastReviewtitle.getText();
	}

}
