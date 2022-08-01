package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Baseclass
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactPage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	// Note : how many times we have written method under @Test for that time browser will open & close
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO", "HOME PAGE TITLE NOT MATCHED"); // "HOME PAGE TITLE  NOT MATCHED" will print when assert failed
	} // if this assertion will failed then others test will be executed. 
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink(); // redirect to contact page
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
