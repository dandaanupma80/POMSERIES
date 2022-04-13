package com.qa.demoCart.tests;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.baseUtil.BaseTest;
import com.qa.democart.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegistationTestDataProvider extends BaseTest

{
	public WebDriver driver;
	public Random random;

	@BeforeClass
	public void doSetUpRegister() {
		registerProvider = lp.clickOnRegisterlink();

	}

	@Test(priority = 1)
	@Description("Some detailed test description")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyRegistattionPageUrl() {
		Assert.assertTrue(registerProvider.verifyRegisterPageUrl().contains("account/register"));
		System.out.println(registerProvider.verifyRegisterPageUrl());
	}

	public String generateRandomEmail() {
		random = new Random();
		String randomEmail = "JanNaveen2022" + random.nextInt(1000) + "@gmail.com";
		return randomEmail;
	}

	/*
	 * @DataProvider public Object[][] getData() { return new Object[][] {
	 * 
	 * 
	 * {"PETER","JOHN","1234567885","Test@123","Yes"},
	 * {"Test","JOHN12","1234567345","Test@123","No"},
	 * 
	 * 
	 * 
	 * }; }
	 */

	@DataProvider
	public Object[][] getRegisterData() {
		Object[][] regData = ExcelUtils.getTestdata("RegisterPage");

		return regData;
	}

	@Test(dataProvider = "getRegisterData")
	@Severity(SeverityLevel.CRITICAL)
	public void doEnterAllinfo(String firstName, String LastName, String phno, String password, String subscribeyes) {
		registerProvider.doEnterRegisterPageDetails(firstName, LastName, generateRandomEmail(), phno, password,
				subscribeyes);
		// Assert.assertTrue(registerProvider.validateSuccessmsgg().contains("Your
		// Account Has Been Created"));
		// registerProvider.doEnterRegisterDetails();

	}

	/*
	 * @Test(priority=3) public void doValidateSuccessmssg() {
	 * 
	 * Assert.assertTrue(registerProvider.validateSuccessmsgg().
	 * contains("Your Account Has Been Created"));
	 * registerProvider.doEnterRegisterDetails(); }
	 */

}
