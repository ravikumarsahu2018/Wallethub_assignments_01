package com.assignment01.qa.LoginTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.assgnment01.qa.Base.BaseClass;
import com.assignment01.qa.LoginPage.HomePage;
import com.assignment01.qa.LoginPage.LoginPage;


public class LoginPageTest extends LoginPage{

	//Global dec of page object

	static public HomePage homepage;
	static public LoginPage loginpage;

	// login page constructor 

	public LoginPageTest(){
		super();
	}


	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
	}


	@Test

	public void Logintest(){
		try {	

			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			Thread.sleep(5000);
		}catch (Exception e){ System.out.println(e.getMessage());}
	}



	@AfterMethod
	public void teardown(){
		driver.close();

	}

}
