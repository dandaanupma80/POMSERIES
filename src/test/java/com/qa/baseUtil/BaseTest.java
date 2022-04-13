package com.qa.baseUtil;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.democart.pages.AccountPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.ProductInfo;
import com.qa.democart.pages.RegisterDataProvider;
import com.qa.democart.pages.SearchResultsPage;
import com.qa.driverFactory.DriverFact;

public class BaseTest {

//base test will call driverfactorya interacts with the properties file and driver factory will return webdriver it will be given to base test & base test will transfer test cases to the constructor of the login page test -->
	
	public WebDriver driver;
	public DriverFact df;
	public LoginPage lp;
	public Properties prop;
	public AccountPage accpage;
	public SearchResultsPage searchPage;
	public ProductInfo productInfo;
	public SoftAssert softassert;
	public RegisterDataProvider registerProvider;
	
	
	
	@BeforeTest
	public void setUp()
	{
		df=new DriverFact();
		prop=df.init_properties();
		driver=df.init_browser(prop);
		lp=new LoginPage(driver);
		softassert=new SoftAssert();
		
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */
	
	
}

