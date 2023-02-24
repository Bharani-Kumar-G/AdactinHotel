package com.adactin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reuseable.BaseClass;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainPage extends BaseClass{
	
	@BeforeClass
	static public void launchWebBrowser() {
		launchBrowser();
		windowMaximize();
		url("https://adactinhotelapp.com/");
	}
	
	@Test
	public void a_loginTest() throws IOException {
		LoginPage login = new LoginPage();
		login.login(getData(0, 0, 0), getData(0, 0, 1));
	}
	@Test
	public void b_searchHotelTest() throws IOException {
		SearchHotelPage searchHotel = new SearchHotelPage();
		searchHotel.searchHotels(1, 1, 1, 1, 1, 1, getData(1, 0, 0), getData(1, 0, 1));
	}
	@Test
	public void c_selectHotelTest() {
		SelectHotelPage selectHotel = new SelectHotelPage();
		selectHotel.selectHotel();
	}
	@Test
	public void d_bookHotelTest() throws IOException {
		BookHotelPage bookHotel = new BookHotelPage();
		bookHotel.bookHotel(getData(2, 0, 0), getData(2, 0, 1), getData(2, 0, 2), getData(2, 0, 3), 1, 1, 11, getData(2, 0, 4));
	}
	
	@Test
	public void e_confirmBookingTest() throws IOException, InterruptedException {
		wait(14);
		ConfirmBooking confirmBook = new ConfirmBooking();
		confirmBook.confirmBooking();
	}
	@Test
	public void f_orderIdTest() throws IOException {
		BookedItineraryPage itinerary = new BookedItineraryPage();
		itinerary.getOrderId();
	}
	@AfterClass
	static public void closeBrowser() {
		windowClose();
	}
}
