package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reuseable.BaseClass;

public class LoginPage extends BaseClass{
	
	LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String userName, String passWord) {
		sendKeys(username, userName);
		sendKeys(password, passWord);
		click(loginButton);
	}
	
}
