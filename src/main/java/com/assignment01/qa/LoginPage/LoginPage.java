package com.assignment01.qa.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assgnment01.qa.Base.BaseClass;

public class LoginPage extends BaseClass {

	//PageFactory or OR

	@FindBy(name="email")
	WebElement username;

	@FindBy(name="pass")
	WebElement password;

	@FindBy(id="loginbutton")
	WebElement login_button;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		return (driver.getTitle());	
	}


	public HomePage login( String un, String pw){
		username.sendKeys(un);
		password.sendKeys(pw);
		login_button.click();
		return (new HomePage());

	}

}
