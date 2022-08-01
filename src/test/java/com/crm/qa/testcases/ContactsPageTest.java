package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Baseclass
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactsPage;
	String Sheetname = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactPage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel()
	{
	contactsPage = homePage.clickOnContactsLink();
	 Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectContactsTest()
	{
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContacts("vatsal modi"); 
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest()
	{
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContacts("abc patel"); // to check another checkbox call this method agian.
		contactsPage.selectContacts("ABC PATEL");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Throwable
	{
		Object data[][]=testUtil.getTestData(Sheetname);
		return data;
	}
	/*
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title , String fname , String lname , String company) throws Throwable  // it's coumpalsary bcoz we rae fetching data from excel sheet
	{   // whatever fields are in excel coumpalsary we have decalre as parameter
		homePage.clkonNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, fname, lname, company);	
		}
	*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
