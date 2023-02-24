package com.adactin;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.reuseable.BaseClass;

public class SearchHotelPage extends BaseClass{
	SearchHotelPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;
	
	@FindBy(id = "room_type")
	private WebElement roomType;
	
	@FindBy(id = "room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id = "datepick_in")
	private WebElement checkInDate;
	
	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;
	
	@FindBy(id = "adult_room")
	private WebElement adultPerRoom;
	
	@FindBy(id = "child_room")
	private WebElement childPerRoom;
	
	@FindBy(id = "Submit")
	private WebElement searchButton;
	
	@FindBy(id = "Reset")
	private WebElement resetButton;
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getChildPerRoom() {
		return childPerRoom;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}
	
	public void searchHotels(int locationIndex, int hotelIndex, int roomTypeIndex, int roomNosIndex, int adultIndex, int childIndex, String checkIn, String checkOut) {
		dropDownSelect(location, locationIndex);
		dropDownSelect(hotels, hotelIndex);
		dropDownSelect(roomType, roomTypeIndex);
		dropDownSelect(noOfRooms, roomNosIndex);
		clear(checkInDate);
		sendKeys(checkInDate, checkIn);
		clear(checkOutDate);
		sendKeys(checkOutDate, checkOut);
		dropDownSelect(adultPerRoom, adultIndex);
		dropDownSelect(childPerRoom, childIndex);
		click(searchButton);
	}
}
