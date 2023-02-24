package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reuseable.BaseClass;

public class BookHotelPage extends BaseClass{
	
	BookHotelPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "cc_num")
	private WebElement creditCardNo;
	
	@FindBy(id = "cc_type")
	private WebElement creditCardType;
	
	@FindBy(id = "cc_exp_month")
	private WebElement creditCardExpMonth;
	
	@FindBy(id = "cc_exp_year")
	private WebElement creditCardExpYear;
	
	@FindBy(id = "cc_cvv")
	private WebElement creditCardCVV;
	
	@FindBy(id = "book_now")
	private WebElement bookNowButton;
	
	@FindBy(id = "cancel")
	private WebElement cancelButton;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCardNo() {
		return creditCardNo;
	}

	public WebElement getCreditCardType() {
		return creditCardType;
	}

	public WebElement getCreditCardExpMonth() {
		return creditCardExpMonth;
	}

	public WebElement getCreditCardExpYear() {
		return creditCardExpYear;
	}

	public WebElement getCreditCardCVV() {
		return creditCardCVV;
	}

	public WebElement getBookNowButton() {
		return bookNowButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	public void bookHotel(String firstname, String lastname, String billingAddress, String credit_cardNo, int creditCardTypeIndex, int expMonthIndex, int expYearIndex, String cvvNo) {
		sendKeys(firstName, firstname);
		sendKeys(lastName, lastname);
		sendKeys(address, billingAddress);
		sendKeys(creditCardNo, credit_cardNo);
		dropDownSelect(creditCardType, creditCardTypeIndex);
		dropDownSelect(creditCardExpMonth, expMonthIndex);
		dropDownSelect(creditCardExpYear, expYearIndex);
		sendKeys(creditCardCVV, cvvNo);
		click(bookNowButton);
	}
}
