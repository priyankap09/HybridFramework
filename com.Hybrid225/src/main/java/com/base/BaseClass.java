package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.PropertyUtils;

public class BaseClass {
	public static WebDriver driver = null;
	
	public static void initialiazation() throws Exception{
		String browserName = PropertyUtils.readProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readProperty("url"));
	}
	public static void main(String[] args) throws Exception {
		initialiazation();
	}

}
