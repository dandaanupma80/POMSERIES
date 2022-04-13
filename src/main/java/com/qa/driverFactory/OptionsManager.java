package com.qa.driverFactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager 
{
	
	private Properties prop;
	private ChromeOptions co;

	public OptionsManager (Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions()
	{
		co=new ChromeOptions();
				if(Boolean.parseBoolean(prop.getProperty("headless")))
						{
					co.addArguments("--headless");
						}
				if(Boolean.parseBoolean(prop.getProperty("incognito")))
				{
			co.addArguments("--incognito");
				}
				
				return co;
				
	}
	
	public ChromeOptions getFireFoxOptions()
	{
		co=new ChromeOptions();
				if(Boolean.parseBoolean(prop.getProperty("headless")))
						{
					co.addArguments("--headless");
						}
				if(Boolean.parseBoolean(prop.getProperty("incognito")))
				{
			co.addArguments("--incognito");
				}
				
				return co;
				
	}
	
	
}
