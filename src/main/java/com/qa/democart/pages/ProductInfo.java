package com.qa.democart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;


public class ProductInfo 
{
private WebDriver driver;
private ElementUtil eleUtil;
private Map<String,String> productData;


private By searchHeader=By.xpath("(//div[@class='container'])[2]//a");
private By productinfo=By.cssSelector("div#content h1");
private By productmetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
private By priceMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
private By productImages=By.xpath("//ul[@class='thumbnails']//li");
private By quantity=By.id("input-quantity");
private By addcartbtn=By.id("button-cart");
private By successmssg=By.cssSelector(".alert.alert-success.alert-dismissible");


	public ProductInfo(WebDriver driver) 
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);	
	}
	
	
	public String productInformation()
	{
		return eleUtil.doElementGetText(productinfo);
	}
	
	public Map<String, String> getProductDetails()
	{
		productData=new LinkedHashMap<String,String>();
		
		productData.put("ProductKey", productInformation());
		productData.put("imagesCount", String.valueOf(getProductImagesCount()));
		productmetaData();
		priceMetaData();
		return productData;
		
		
	}
	
	private Map<String,String> productmetaData()
	{
		List<WebElement> metaDataList=eleUtil.getElements(productmetaData);
		
		for(WebElement e:metaDataList)
		{
			String rawtxt=e.getText().trim();
			String[] metaData = rawtxt.split(":");
			String metaKey = metaData[0].trim();
			String metaValue = metaData[1].trim();
			productData.put(metaKey, metaValue);
			
		}
		return productData;
		
	}
	
	
	private Map<String,String> priceMetaData()
	{
		List<WebElement> metaPriceList=eleUtil.getElements(priceMetaData);
		String price=metaPriceList.get(0).getText().trim();
		String EXTaxInfo=metaPriceList.get(1).getText().trim();
			productData.put("price", price);
			productData.put("exTaxPrice", EXTaxInfo);

		return productData;
		
	}
	
//	public void pricemetaData()
//	{
//		eleUtil.getElements(priceMetaData);
//	}
	
	public int getProductImagesCount()
	{
		return eleUtil.getElements(productImages).size();
	}
	
	public void enterQuantity(int Quantity)
	{
		eleUtil.doSendKeys(quantity, String.valueOf(Quantity));
	}
	
	public void doClickAdcart()
	{
		eleUtil.doClick(addcartbtn);
	}
	public String VerfiySuccessMssg()
	{
		return eleUtil.doElementGetText(successmssg);
	}
	

}
