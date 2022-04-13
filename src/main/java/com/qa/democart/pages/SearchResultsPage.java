package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	private By searchHeaderTxt = By.xpath("//div[@class='col-sm-4']//a");
	private By subHeading = By.xpath("//div[@class='col-sm-12']/h1");
	private By listOfItems = By.xpath("//div[contains(@class,'product-layout')]//div[@class='caption']//a");
	
	public String verifySearchTitle()
	{
		return driver.getTitle();
		
	}

	public String searchHeaderTxt() {

		return eleutil.waitForEleByUseVisible(Constants.DEFAULT_TIMEOUT, searchHeaderTxt).getText();

	}

	public String subHeaderTxt() {

		return eleutil.getTextFromElement(subHeading);

	}

	public int SizelistOfElements() {
		return eleutil.getElements(listOfItems).size();
	}

	public List<String> getListOfEle() {
		List<WebElement> lstEle = eleutil.getElements(listOfItems);
		List<String> productTxt = new ArrayList<String>();
		for (WebElement e : lstEle) {
			String pctTXt = e.getText();
			productTxt.add(pctTXt);
		}
		return productTxt;

	}

	public ProductInfo doClickSelectedProduct(String productName)
	{
		List<WebElement> lstEle = eleutil.getElements(listOfItems);

     for(WebElement e:lstEle)
	{
    	 String pctTXt = e.getText();
			
		if(pctTXt.equalsIgnoreCase(productName))
		{
			e.click();
			break;
		}
	}
     
     return new ProductInfo(driver);
	}
}