package com.qa.demoCart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.baseUtil.BaseTest;
import com.qa.democart.utils.Constants;

public class LoginPageTest extends BaseTest
{

	@Test(priority=1)
	public void VerfiytitlePAge()
	{
		String actualtitle= lp.getTitlePage();
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE);
		
		System.out.println(actualtitle);
	}
  @Test(priority=2)
  public void getPageUrl()
  {
	  String actualUrl=lp.gePageUrl();
	Assert.assertTrue(actualUrl.contains(Constants.FRACTION_PAGE_URL));
  }
	
  @Test(priority=3)
  public void forgotPasswordLinkExist()
  {
	  Assert.assertTrue(lp.IsForgotLink());
  }
  
  
  @Test(priority=5)
  public void doLoginTest()
  {
	  lp.doLogin(prop.getProperty("userName"),prop.getProperty("Password"));
  }
  
  
  @Test(priority=4)
  public void isRegisterLinkExists()
  {
	 Assert.assertTrue(lp.isRegisterlink()); 
  }
  
  @Test(enabled=false)
  public void navigationRegistationPage()
  {
	  lp.clickOnRegisterlink();
  }
	
	

}
