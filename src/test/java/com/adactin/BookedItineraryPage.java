package com.adactin;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reuseable.BaseClass;

public class BookedItineraryPage extends BaseClass {
	BookedItineraryPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "order_id_828055")
	private WebElement orderId;
	
	@FindBy(id = "order_id_text")
	private WebElement orderText;
	
	public void getOrderId() throws IOException {
		String orderIdNo = getValue(orderId);
		writeData(3, 0, 0, orderIdNo);
		String orderIdNum = getData(3, 0, 0);
		sendKeys(orderText, orderIdNum);
		takeScreenShot(orderText);
		System.out.println(orderIdNum);
	}
	
}
