package com.qa.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFact {
	public static final String highlight = "true";
	public WebDriver driver;
	public Properties prop;
	public OptionsManager options;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize browser on the basis of given browser name
	 * 
	 * @param browserName
	 * @return WebDriver
	 */

	public WebDriver init_browser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("browserName is" + browserName);
		options = new OptionsManager(prop);

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(options.getChromeOptions()));
			// driver=new ChromeDriver(options.getChromeOptions());

		} else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("safari")) {

			// WebDriverManager.safaridriver().setup();-->for safari we don't need to write
			// selenium server
			driver = new SafariDriver();
		} else {
			System.out.println("invalid browser name" + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	public WebDriver getDriver() {

		return tldriver.get();
	}

	/**
	 * onlythree lines of codes for reading properties first create obj for
	 * fileinputstream and then load properties by using load method This method is
	 * sued to on the basis of given env varaiables QA/DEB/STAGE/PROD
	 * 
	 * @return this return Properties
	 */
	

	public Properties init_properties() {

		prop = new Properties();
		FileInputStream ip=null;
		//maven clean install -Denv="qa"
		//mvn clean install-->without variable
		String envName=System.getProperty("env");
		System.out.println("env name is:"+envName);
		try
		{
		if(envName==null)
		{
			
			ip = new FileInputStream("./src/test/resources/config/qa.Config.properties");
		}
		else
		{
			//switch(envName.toLowerCase().trim())
			switch (envName.toLowerCase().trim()) {
			case "dev":ip = new FileInputStream("./src/test/resources/config/Dev.Config.properties");

				break;
			case "qa":ip = new FileInputStream("./src/test/resources/config/qa.Config.properties");

				break;
			case "stage":ip = new FileInputStream("./src/test/resources/config/Stage.Config.properties");

				break;

			default:
				System.out.println("invalid env name");
				break;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return prop;
	}
	
	
	
	
//
//	public Properties init_properties() {
//
//		prop = new Properties();
//
//		try {
//			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return prop;
//	}

	/**
	 * take screenshot
	 * 
	 * @return
	 */
	/*
	 * public static String getScreenshot() { File srcFile =
	 * ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); String path
	 * = System.getProperty("user.dir") + "/screenshot/" +
	 * System.currentTimeMillis() + ".png"; File destination = new File(path); try {
	 * FileUtils.copyFile(srcFile, destination); } catch (IOException e) {
	 * e.printStackTrace(); } return path;
	 * 
	 * }
	 */

	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyDirectory(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtils.copyFile(src, destination);

		return path;

	}

}
