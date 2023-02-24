package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reuseable.BaseClass;

public class SelectHotelPage extends BaseClass{
	SelectHotelPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "radiobutton_0")
	private WebElement radioButton;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(id = "cancel")
	private WebElement cancelButton;

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	public void selectHotel() {
		click(radioButton);
		click(continueButton);
	}
}
