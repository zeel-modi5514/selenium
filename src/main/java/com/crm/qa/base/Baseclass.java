package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class Baseclass
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Baseclass() // super keyword will call this constructor first from LoginPgeFirst
	{
		try {
			 prop = new Properties();
			//FileInputStream ip = new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
			
			 FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
			+ "/qa/config/config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}	
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if (browserName.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
				
				driver.get(prop.getProperty("url")); 
				
				
		}
	
		
	
}
