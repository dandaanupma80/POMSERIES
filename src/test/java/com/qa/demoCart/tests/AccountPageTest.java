package com.qa.demoCart.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseUtil.BaseTest;
import com.qa.democart.utils.Constants;

public class AccountPageTest extends BaseTest 

{

	//before account i need to launch the browser and launch url and login user by using un,pwd
	public WebDriver driver;
	
	@BeforeClass
	public void accountSetUp()
	{
		accpage=lp.doLogin(prop.getProperty("userName"), prop.getProperty("Password"));
		
	}
	
	@Test(priority=1)
	public void AccountTitlePage()
	{
		String actualTitle=accpage.validateAccounttitle();
		Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
		System.out.println("actualtitle is:"+actualTitle);
	}
	


@Test(priority=3)
public void verfiyHeadersCount()
{
	int headercount=accpage.listOfHeaders();
	Assert.assertEquals(headercount, Constants.HEADER_COUNT);
	System.out.println("headerscount is"+headercount);
	
	
}
@Test(priority=4)
public void displayheadersText()
{
	List<String> txt=accpage.headerTxt();
	Assert.assertEquals(txt, Constants.EXPECTED_HEADER_TXT);
	System.out.println("headers txt is:"+txt);
}
	
@Test(priority=5)
public void footerSize()
{
	Assert.assertEquals(accpage.verifyFooterSize(), Constants.FOOTER_LIST_SIZE);
	List<String> footerTxt=accpage.verifyFooterList();
	System.out.println(footerTxt);
	
}
	


@Test(priority=6)
public void validateSearchBox()
{
	Assert.assertTrue(accpage.isSearchFieldExist());
	searchPage=accpage.enterTxtInSearchField(prop.getProperty("productName1"));
	Assert.assertEquals(searchPage.verifySearchTitle(), Constants.SEARCH_PAGE_TITLE);
	System.out.println(searchPage.searchHeaderTxt());
	System.out.println(searchPage.subHeaderTxt());
}
	
@Test(priority=7)

public void listOfProducts()
{
Assert.assertEquals(searchPage.SizelistOfElements(), 3);
System.out.println(searchPage.SizelistOfElements());
	
}

@Test(priority=8)

public void getProducts()
{
System.out.println(searchPage.getListOfEle());
Assert.assertEquals(searchPage.getListOfEle(), Constants.PRODUCTS);
System.out.println(searchPage.SizelistOfElements());	
}

@Test(priority=9)
public void selectListOfProduct()
{
	searchPage.doClickSelectedProduct(prop.getProperty("SelectProduct"));
}
	
	
}
