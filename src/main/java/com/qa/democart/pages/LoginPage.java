package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;



public class LoginPage
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//step 1: create private by locators
	
	private By emailid=By.xpath("//input[@id='input-email']");
	private By pwd=By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login']");
	private By forgotLink=By.xpath("//input[@id='input-password']/following-sibling::a");
	private By registerLink=By.linkText("Register");
	//step 2: create constructor-->rightnow driver is pointed to null so we have to intialize diver i don't know where driver will coming at the time of obj creation driver will be pointed some value
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	//step 3: create public actions
	
	public String getTitlePage()
	{
		 return eleUtil.waitForTitleContains(Constants.DEFAULT_TIMEOUT, Constants.LOGIN_PAGE_TITLE);
				 //eleUtil.waitForFullTitle(Constants.DEFAULT_TIMEOUT, Constants.LOGIN_PAGE_TITLE);
				
				//.waitForFullTitle(Constants.DEFAULT_TIMEOUT, Constants.LOGIN_PAGE_TITLE);
	}

	public String gePageUrl()
	{
		return driver.getCurrentUrl();
	}
	public boolean IsForgotLink()
	{
		return driver.findElement(forgotLink).isDisplayed();
	}
	
	public WebElement doLoginEmail()
	{
		return driver.findElement(emailid);
	}
	public AccountPage doLogin(String un,String pw)
	{
		driver.findElement(emailid).sendKeys("dandaanupama410@gmail.com");
		driver.findElement(pwd).sendKeys("Anupama@10");
		driver.findElement(loginButton).click();
		
		return new AccountPage(driver);
	}
	
	public boolean isRegisterlink()
	{
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public RegisterDataProvider clickOnRegisterlink()
	{
		if(isRegisterlink())
				{
			driver.findElement(registerLink).click();
				}
		return new RegisterDataProvider(driver);
		
	}
				
	
	

}
