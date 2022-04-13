package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage

{
	private WebDriver driver;

	private By serachEle=By.cssSelector(".form-control.input-lg");
	private By headerInfo=By.xpath("(//ul[@class=\"breadcrumb\"]//li/a)[2]");
	private By eleCounts=By.xpath("//div[@id='content']//h2");
	private By footerList=By.xpath("//div[@class='col-sm-3']//li/a");
	private By searchButton=By.cssSelector(".btn.btn-default.btn-lg");
	
	
	//step2 create accountPage constructor
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//step 3 create public actions
	
	
	public String validateAccounttitle()
	{
		return driver.getTitle();
		
		
	}
	

	public boolean isSearchFieldExist()
	{
		return driver.findElement(serachEle).isDisplayed();
		
	}
	
	public int listOfHeaders()
	{
		return driver.findElements(eleCounts).size();
	}
	
	public List<String> headerTxt()
	{
		List<WebElement> header =driver.findElements(eleCounts);
		List<String> listTxt=new ArrayList<String>();
		for(WebElement e:header )
		{
			String txt=e.getText();
			listTxt.add(txt);
		}
		
		return listTxt;
	}
	
	
	public List<String> verifyFooterList()
	{
		List<WebElement> flist = driver.findElements(footerList);
		List<String> ftxt=new ArrayList<String>();
		for(WebElement e:flist )
		{
			String footerTxt=e.getText();
			ftxt.add(footerTxt);
		}
		return ftxt;
	}
	public int verifyFooterSize()
	{
		return driver.findElements(footerList).size();
		
		
	}
	public SearchResultsPage enterTxtInSearchField(String productName)
	{
		if(isSearchFieldExist())
		{
		WebElement ele=driver.findElement(serachEle);
			ele.sendKeys(productName);	
			driver.findElement(searchButton).click();
		}
		
		return new SearchResultsPage(driver);
		
	}
}
