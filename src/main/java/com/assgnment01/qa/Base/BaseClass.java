// This is base class for basic Initialization of driver properties. 

package com.assgnment01.qa.Base;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	// Global Declaration 
	public static WebDriver driver; 
	public static Properties prop;
	public static String projpath = System.getProperty("user.dir");

	// Base class Constructor

	public BaseClass() {

		try {

			prop= new Properties();  

			// Location of config.properties file
			String projpath = System.getProperty("user.dir");

			FileInputStream ip = new FileInputStream(projpath +"\\src\\main\\java\\com\\assignment01\\qa\\Conf\\Config.properties");
			prop.load(ip);

		} catch (Exception e){ e.getMessage();}

	}

	// initialization 

	public static void initialization(){

		String browsername= prop.getProperty("browser");

		if (browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", projpath + "\\Resources\\chromedriver.exe ");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		}
	}
}
