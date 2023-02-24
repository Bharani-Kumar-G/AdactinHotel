package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reuseable.BaseClass;

public class ConfirmBooking extends BaseClass{
	ConfirmBooking(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "search_hotel")
	private WebElement searchHotel;
	
	@FindBy(id = "my_itinerary")
	private WebElement myItinerary;
	
	@FindBy(id = "logout")
	private WebElement logoutButton;

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getMyItinerary() {
		return myItinerary;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	public void confirmBooking() {
		click(myItinerary);
	}
}
