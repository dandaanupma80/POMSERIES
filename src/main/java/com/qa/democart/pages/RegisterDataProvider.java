package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtil;


public class RegisterDataProvider {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstName = By.name("firstname");
	private By LastName = By.name("lastname");
	private By email = By.name("email");
	private By phno = By.name("telephone");
	private By password = By.name("password");
	private By confirmPwd = By.name("confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']/input[@type='radio' and @value='1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']/input[@type='radio' and @value='0']");
	private By checkBox = By.xpath("//input[@type='checkbox']");
	private By ctnButton = By.xpath("//input[@type='submit']");
	private By successmssg = By.xpath("//div[@id='content']/h1");
	private By logOutbtn = By.linkText("Logout");
	private By registerbtn = By.xpath("//div[@class='list-group']//a[text()='Register']");

	public RegisterDataProvider(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String verifyRegisterPageUrl() {
		String ActualTitle = driver.getCurrentUrl();
		return ActualTitle;
	}

	public boolean doEnterRegisterPageDetails(String firstName, String LastName, String email, String phno,
			String password, String subscribeYes) {

		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.LastName, LastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.phno, phno);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPwd, password);
		if (subscribeYes.equalsIgnoreCase("Yes")) {
			eleUtil.doClick(this.subscribeYes);

		} else {
			eleUtil.doClick(this.subscribeNo);
		}

		eleUtil.doClick(this.checkBox);
		eleUtil.doClick(this.ctnButton);
		if (validateSuccessmsgg().contains("Your Account Has Been Created")) {
			doEnterRegisterDetails();
			return true;
		}

		return false;

	}

	public String validateSuccessmsgg() {
		return eleUtil.doElementGetText(successmssg);

	}

	public void doEnterRegisterDetails() {
		eleUtil.doClick(logOutbtn);
		eleUtil.doClick(registerbtn);

	}
}
