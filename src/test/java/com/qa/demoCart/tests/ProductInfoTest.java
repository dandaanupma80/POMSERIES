package com.qa.demoCart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseUtil.BaseTest;
import com.qa.democart.utils.Constants;

public class ProductInfoTest extends BaseTest
{
	
	@BeforeClass
	public void accountSetUp()
	{
		accpage=lp.doLogin(prop.getProperty("userName"), prop.getProperty("Password"));
		
	}
	
	
	@Test(priority=1)
	public void getProductInfo()
	{
		Assert.assertEquals(accpage.validateAccounttitle(), Constants.ACCOUNT_PAGE_TITLE);
		searchPage=accpage.enterTxtInSearchField(prop.getProperty("productName"));
		Assert.assertEquals(searchPage.verifySearchTitle(), Constants.SEARCH_PAGE_TITLE);
		System.out.println(searchPage.searchHeaderTxt());
		System.out.println(searchPage.subHeaderTxt());
		
	}
	
	@Test(priority=2)

	public void listOfProducts()
	{
	Assert.assertEquals(searchPage.SizelistOfElements(), 3);
	System.out.println(searchPage.SizelistOfElements());
		
	}

	@Test(priority=3)

	public void getProducts()
	{
	System.out.println(searchPage.getListOfEle());
	Assert.assertEquals(searchPage.getListOfEle(), Constants.PRODUCTS);
	System.out.println(searchPage.SizelistOfElements());	
	}

	//@Test(priority=4)
//	public void selectListOfProduct()
//	{
//		
//		searchPage.doClickSelectedProduct(prop.getProperty("SelectProduct"));
//	}
	
	@Test(priority=5)
	public void verifyProductInfo()
	{
    productInfo=searchPage.doClickSelectedProduct(prop.getProperty("SelectProduct"));
	//softassert.assertEquals(productInfo.productInformation(),"MacBook");
	//System.out.println(productInfo.productInformation());
	Map<String, String> actualList = productInfo.getProductDetails();
	actualList.forEach((k,v)->System.out.println(k+":"+v));
	productInfo.enterQuantity(2);
	productInfo.doClickAdcart();
	Assert.assertTrue(productInfo.VerfiySuccessMssg().contains("Success: You have added MacBook to your shopping cart"));
	
	
	
	
	//Map<String, String> productlist = productInfo.getProductDetails();
	//productlist.forEach((k,v)--> System.out.println(k+":"+v));
	//softassert.assertAll();

	
	}
	
	
	
		
	
	

}
